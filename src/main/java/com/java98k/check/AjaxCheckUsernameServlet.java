package com.java98k.check;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class AjaxCheckUsernameServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4011070534012673073L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//>>处理POST请求参数乱码
		request.setCharacterEncoding("utf-8");
		//>>处理响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		
		
		//1.获取请求中携带的用户名
		String username = request.getParameter("username");
		boolean res = checkUsernameIsExist( username );
		System.out.println("doGet()..."+username);
		System.out.println("doGet()..."+res);
		//2.做出响应
		String responseText =
				res ? "用户名已存在!" : "恭喜用户名可以使用";
		response.getWriter().write( responseText );
	}
	/* 访问数据库,检查用户名是否存在, 返回一个boolean值 */
	private boolean checkUsernameIsExist(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.注册驱动、获取连接对象
			conn = JDBCUtil.getConn();
			
			//2.声明查询SQL,获取传输器对象
			String sql = "select * from yonghubiao where yongHuMing=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			//3.执行SQL语句,获取结果集
			rs = ps.executeQuery();
			
			//4.处理结果集 true:表示用户名存在,反之则不存在!
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败!");
		}
		return false;
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
