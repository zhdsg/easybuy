package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbPCategoryDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbPCategory;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
@WebServlet(name = "EbProConServlet")
public class EbProConServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("ep_id"));
        EbProductDao ebProductDao =new EbProductDao();
        EbProduct ebProduct=ebProductDao.getProductbyId(id);
        request.setAttribute("proCon",ebProduct);


        EbPCategoryDao ebPCategory=new EbPCategoryDao();
        List<EbPCategory> ebPCategoryList=ebPCategory.getCategories();
        request.setAttribute("categoryList",ebPCategoryList);


        request.getRequestDispatcher("/product-view.jsp").forward(request,response);


    }
}
