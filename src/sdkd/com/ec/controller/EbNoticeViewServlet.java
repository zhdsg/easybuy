package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoticeDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNotice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/7.
 */
@WebServlet(name = "EbNoticeViewServlet")
public class EbNoticeViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("notice_id"));



        EbNoticeDao ebNotice =new EbNoticeDao();
        List<EbNotice> ebNoticeList =ebNotice.getNotice();
        request.setAttribute("noticeList",ebNoticeList);
        for(int i=0;i<ebNoticeList.size();i++){
            if(id==ebNoticeList.get(i).getNoId())
            {
                request.setAttribute("noTitle",ebNoticeList.get(i).getNoTitle());
                request.setAttribute("noContent",ebNoticeList.get(i).getNoContent());
            }
        }
        EbNewsDao newsDao = new EbNewsDao();
        List<EbNews> ebNewses = newsDao.getNews();
        request.setAttribute("newList",ebNewses);


        request.getRequestDispatcher("/news-view.jsp").forward(request,response);

    }
}
