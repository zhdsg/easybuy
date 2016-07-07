package sdkd.com.ec.test;

import sdkd.com.ec.dao.BaseDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class BaseTest {
    public static void main(String[] args) {
        String sql = "insert into easybuy_user(eu_user_name) values(?)";
//        String sql = "update easybuy_user set eu_user_name = ? where eu_user_id = ?";
//        String sql = "delete from easybuy_user where eu_user_id = ?";
//        String sql = "select * from easybuy_user where eu_user_id = ?";
        List<String> params = new ArrayList<String>();
        params.add("赵帅");
//        params.add(3+"");
//        BaseDao.exeucteModify(sql,params);
//        BaseDao.executeSearch(sql,params);
        new BaseDao().exeucteModify(sql,params);
    }
}
