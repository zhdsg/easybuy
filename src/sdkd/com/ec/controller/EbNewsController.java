package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoticeDao;
import sdkd.com.ec.dao.impl.EbPCategoryDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNotice;
import sdkd.com.ec.model.EbPCategory;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbNewsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        EbNewsDao newsDao = new EbNewsDao();
        List<EbNews> ebNewses = newsDao.getNews();
        request.setAttribute("newList",ebNewses);
        EbNoticeDao ebNotice =new EbNoticeDao();
        List<EbNotice> ebNoticeList =ebNotice.getNotice();
        request.setAttribute("noticeList",ebNoticeList);
        EbProductDao ebProductDao =new EbProductDao();
        List<EbProduct> ebProductList =ebProductDao.getProduct();
        request.setAttribute("productList",ebProductList);
        EbPCategoryDao ebPCategory=new EbPCategoryDao();
        List<EbPCategory> ebPCategoryList=ebPCategory.getCategories();
        request.setAttribute("categoryList",ebPCategoryList);

        //跳转
        request.getRequestDispatcher("/index.jsp").forward(request,response);


        /**
         * login
         */
        /*EbUser user =  login();
        request.getSession().setAttribute("user",user);*/
        /*String paraId = request.getParameter("id");
        if(paraId!=null && !"".equals(paraId)){
            int id = Integer.valueOf(id);
            EbNews news = newsDao.getNewsById(id);
            request.setAttribute("news",news);
        }*/
    }
}
