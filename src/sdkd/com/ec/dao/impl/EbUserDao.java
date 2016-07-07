package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户DAO
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUserDao extends BaseDao{
    public boolean hasRegisterUser(String user,String password){
        //查重
        String sql=null;
        sql ="select eu_user_name FROM easybuy_user ORDER BY eu_user_id";

        ResultSet rs=this.executeSearch(sql,null);
        try {
            while(rs.next()){
                if(rs.getString("eu_user_name").trim().equals(user)){
                    return true;
                }

            }
            //用户添加
            sql ="insert into easybuy_user(eu_user_name,eu_password) values(?,?)";
            List<String> params =new ArrayList<String>();
            params.add(user);
            params.add(password);
            int result =this.exeucteModify(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }



        return false;

    }
    public boolean  getUser(String user,String password){

        String sql ="select eu_user_name ,eu_password FROM easybuy_user ORDER BY eu_user_id";

        ResultSet rs=this.executeSearch(sql,null);
        try {
            while(rs.next()){
                if(rs.getString("eu_user_name").trim().equals(user)&&rs.getString("eu_password").equals(password)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }

        return false;
    }

}
