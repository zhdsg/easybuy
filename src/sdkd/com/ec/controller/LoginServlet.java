package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/6.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user =request.getParameter("userName");
        String password =request.getParameter("passWord");

        EbUserDao ebUserDao =new EbUserDao();

        if(ebUserDao.getUser(user,password)){
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/news.do").forward(request,response);
        }else{
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            String result ="用户名密码错误！！！！";
            request.setAttribute("result",result);

        }

    }
}
