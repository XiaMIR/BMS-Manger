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
import cn.leelei.servlet.util.DbUtils;

@WebServlet(asyncSupported = true, urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*//得到用户名和密码 从jsp页面获取
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		//验证用户
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);*/
		
		try {
			User user= new User();
			BeanUtils.populate(user, request.getParameterMap());
			//加密处理
//			user.setPassword(DigestUtils.md5Hex(user.getPassword()));
			UserDao userDao =new UserDao();
			//返回登陆的用户
			User loginUser = userDao.validataUser(user);
			if(loginUser !=null){
			//存储信息到session中
			request.getSession().setAttribute("loginUser", loginUser);
			//页面添加数据得到所有
			List<User> users= userDao.findall();
			request.setAttribute("users", users);
			//转反发到用户列表界面
			request.getRequestDispatcher("WEB-INF/users/index.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "用户名或密码有误请查证");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
