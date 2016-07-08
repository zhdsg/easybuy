package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/7/6.
 */

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user =request.getParameter("userName");
        String password =request.getParameter("passWord");
        EbUserDao ebUserDao=new EbUserDao();

        if(!ebUserDao.hasRegisterUser(user,password)){
            request.getRequestDispatcher("/reg-result.jsp").forward(request,response);
        }else{

            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }



    }
}
