package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class EbProductDao extends BaseDao{

    public List<EbProduct>  getProduct(){
        List<EbProduct>  ebProductList =new ArrayList<EbProduct>();
        String sql ="select * FROM easybuy_product ORDER BY epc_id DESC LIMIT 0,7";
        ResultSet rs =this.executeSearch(sql,null);
        try {
            while(rs.next()){
                EbProduct ebProduct =new EbProduct();
                ebProduct.setEpId(rs.getInt("ep_id"));
                ebProduct.setEpName(rs.getString("ep_name"));
                ebProduct.setEpDescription(rs.getString("ep_description"));
                ebProduct.setEpPrice(rs.getDouble("ep_price"));
                ebProduct.setEpDiscount(rs.getInt("ep_discount"));
                ebProduct.setEpcId(rs.getInt("epc_id"));
                ebProductList.add(ebProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }

        return ebProductList;
    }

}
