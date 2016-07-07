package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbPCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/7.
 */
public class EbPCategoryDao extends BaseDao{
    public List<EbPCategory>  getCategories(){
        List<EbPCategory> ebPCategoryList=new ArrayList<EbPCategory>();
        String sql ="select *from easybuy_product_category";
        ResultSet rs =this.executeSearch(sql,null);
        try {
            while(rs.next()){
            EbPCategory ebPCategory =new EbPCategory();
                ebPCategory.setEpcId(rs.getInt("epc_id"));
                ebPCategory.setEpcName(rs.getString("epc_name"));
                ebPCategory.setEpcParentId(rs.getInt("epc_parent_id"));
                ebPCategoryList.add(ebPCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return ebPCategoryList;
    }

}
