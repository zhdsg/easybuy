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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/7.
 */
@WebServlet(name = "EbProductServlet")
public class EbProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int epc_id =Integer.parseInt(request.getParameter("epc_id"));

        EbProductDao ebProductDao =new EbProductDao();
        List<EbProduct> ebProductList =ebProductDao.getProduct();
        List<EbProduct>  newproductList =new ArrayList<EbProduct>();
        for(EbProduct a: ebProductList){
            if(a.getEpcId()==epc_id){
                newproductList.add(a);
            }
        }


        request.setAttribute("productList",newproductList);
        EbPCategoryDao ebPCategory=new EbPCategoryDao();
        List<EbPCategory> ebPCategoryList=ebPCategory.getCategories();
        request.setAttribute("categoryList",ebPCategoryList);


        request.getRequestDispatcher("/product-list.jsp").forward(request,response);


    }
}
