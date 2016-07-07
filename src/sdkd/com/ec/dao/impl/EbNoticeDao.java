package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNotice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class EbNoticeDao extends BaseDao {
    public List<EbNotice>  getNotice(){
        List<EbNotice> ebNoticeList=new ArrayList<EbNotice>();
        String sql ="select * FROM easybuy_notice ORDER BY notice_create_time DESC LIMIT 0,7 ";
        ResultSet rs =this.executeSearch(sql,null);
        try {
            while(rs.next()){
                EbNotice ebNotice =new EbNotice();
                ebNotice.setNoId(rs.getInt("notice_id"));
                ebNotice.setNoTitle(rs.getString("notice_title"));
                ebNoticeList.add(ebNotice);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return ebNoticeList;
    }






}
