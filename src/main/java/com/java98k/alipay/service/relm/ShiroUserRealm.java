package com.java98k.alipay.service.relm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.YongHuDao;
import com.java98k.alipay.entity.SysUser;

@Service
@Scope("singleton")
public class ShiroUserRealm extends AuthorizingRealm{
	@Autowired
	private	YongHuDao yongHuDao;
	/**
	 * 密码加密
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		//1.构建凭证匹配对象
		HashedCredentialsMatcher hcm=new HashedCredentialsMatcher();
		//2.设置加密算法
		hcm.setHashAlgorithmName("MD5");
		//3.设置加密次数
		hcm.setHashIterations(1);
		super.setCredentialsMatcher(hcm);
	}
	/**
	 * 通过此对象完成认证信息的获取和封装
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.从token中获取用户信息(前端用户输入)
		UsernamePasswordToken upToken=
		(UsernamePasswordToken)token;
		String username = upToken.getUsername();
		//2.基于用户名从数据库中查询用户信息
		SysUser user = yongHuDao.findUserByUserName(username);
		//3.判定用户是否存在
		if (user==null) {
            throw new UnknownAccountException("用户不存在");
        }
		ByteSource bytes = ByteSource.Util.bytes(user.getSalt());
		//4.封装用户信息并返回
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user, //表示身份信息，此身份信息是程序员自行设定的
				user.getMiMa(), //表示已加密的密码
				bytes, 
				getName());
		return info;//此对象返回给认证管理器
	}
	//完成授权操作
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

}
