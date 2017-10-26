package cn.leelei.servlet.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

import cn.leelei.servlet.dao.UserDao;
import cn.leelei.servlet.entity.User;

@WebServlet(asyncSupported = true, urlPatterns = { "/UserServlet" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到用户名和密码 从jsp页面获取
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String realName = request.getParameter("realName");
		//验证用户
		System.err.println(userName+password+realName);
		
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setRealName(realName);
		userDao.save(user);
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

}
