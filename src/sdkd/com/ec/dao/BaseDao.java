package sdkd.com.ec.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class BaseDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        try {
            //1.加载驱动
            Class.forName(getPro("driver"));
            //2.桥梁--Connection
            con = DriverManager.getConnection(getPro("url"),getPro("username"),getPro("password"));
            //1.加载驱动
            /*Class.forName("com.mysql.jdbc.Driver");
            //2.桥梁--Connection
            con = DriverManager.getConnection("jdbc:mysql://192.168.210.210:3306/easybuy","root","root");*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 释放资源
     */
    public void close(){
        try {
            if(rs!=null) rs.close();
            if(ps != null) ps.close();
            if(con!=null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取配置信息
     * @return
     */
    public String getPro(String key){
        Properties pro = new Properties();
        try {
            InputStream is =this.getClass().getResourceAsStream("/jdbc.properties");
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = pro.get(key).toString();
        return value;
    }

    //CUD
    public int exeucteModify(String sql, List<String> params){
        //JDBC的步骤
        int result = 0;
        try {
            con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            //对于集合，在使用前一定要判断非空！！！
            if(params!=null && params.size()>0){
                for(int i=0;i<params.size();i++){
                    ps.setString((i+1),params.get(i));
                }
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return result;
    }

    //R
    public ResultSet executeSearch(String sql, List<String> params){
        //JDBC的步骤
        ResultSet rs = null;
        try {
            con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            if(params!=null && params.size()>0){
                for(int i=0;i<params.size();i++){
                    ps.setString((i+1),params.get(i));
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
