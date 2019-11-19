package com.java98k.alipay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.ChongQianDao;
import com.java98k.alipay.dao.YongHuDao;
import com.java98k.alipay.dao.ZhangDanDao;
import com.java98k.alipay.dao.ZuoWeiDao;
import com.java98k.alipay.service.chongQianService;
import com.java98k.alipay.vo.ZuoWeiBiao;
import com.java98k.alipay.vo.chongQianPojo;
import com.java98k.common.exception.ServiceException;


@Service
public class chongQianServiceImp implements chongQianService{
	@Autowired
	private ChongQianDao c;
	@Autowired
	private YongHuDao yongHuDao;
	@Autowired
	private ZuoWeiDao zuoWeiDao;
	private ZhangDanDao zhangDanDao;
	@Override
	public String chongQian(chongQianPojo cq) {
		
		return c.chongQian(cq);
	}
	@Override
	public Integer update(String yhm) {
		// TODO Auto-generated method stub
		return c.update(yhm);
	}
	@Override
	public Integer updateQian(Double allQian, String yhm) {
		// TODO Auto-generated method stub
		return c.updateQian(allQian,yhm);
	}
	@Override
	public Integer saveDingDan(Integer palce, String[] ids, Integer changciid, String yhm) {
		Integer yue = yongHuDao.findByname(yhm);
		System.err.println("**************************************");
		System.out.println("yue"+yue);
		if (yue<palce) {
			throw new ServiceException("余额不足");
		}
		yue=yue-palce;
		Integer yuE = c.updateQian(Double.valueOf(yue), yhm);
		System.out.print(yuE);
		Integer id=null;
		Integer yongHuID = yongHuDao.selcetID(yhm);
		for(int i=0;i<ids.length;i++) {
			String [] idd=ids[i].split("-");
			int pai=Integer.valueOf(idd[0]);
			int lie=Integer.valueOf(idd[1]);
			int rows = zuoWeiDao.saveByChangCiID(changciid, pai, lie);
			int zuoWeiID = zuoWeiDao.findByID(changciid, pai, lie);
			System.err.println("***************************************************************");
			System.out.println(changciid);
			System.out.println(yongHuID);
			System.out.println(zuoWeiID);
			System.err.println("***************************************************************");
//			id = zhangDanDao.saveDD(changciid, yongHuID,zuoWeiID);
//			System.out.println(id);
		}
		return id;
	}
	@Override
	public Integer saveDing(Integer changciid, String[] ids, String yhm) {
		Integer yongHuID = yongHuDao.selcetID(yhm);
		Integer id=null;
		for(int i=0;i<ids.length;i++) {
			String [] idd=ids[i].split("-");
			int pai=Integer.valueOf(idd[0]);
			int lie=Integer.valueOf(idd[1]);
			int rows = zuoWeiDao.saveByChangCiID(changciid, pai, lie);
			int zuoWeiID = zuoWeiDao.findByID(changciid, pai, lie);
			System.err.println("***************************************************************");
			System.out.println(changciid);
			System.out.println(yongHuID);
			System.out.println(zuoWeiID);
			System.err.println("***************************************************************");
//			id = zhangDanDao.saveDD(changciid, yongHuID,zuoWeiID);
//			System.out.println(id);
		}
		return id;
	}
	
	
}
