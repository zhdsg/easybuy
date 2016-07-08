package sdkd.com.ec.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/7.
 */
@WebServlet(name = "LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);//防止创建Session
        if (session==null){
            request.getRequestDispatcher("/news.do").forward(request,response);
            return;
        }
        session.removeAttribute("user");
        request.getRequestDispatcher("/news.do").forward(request,response);

    }
}
