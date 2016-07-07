package sdkd.com.ec.model;

/**
 * Created by Administrator on 2016/7/7.
 */
public class EbPCategory {
    public int getEpcParentId() {
        return epcParentId;
    }

    public void setEpcParentId(int epcParentId) {
        this.epcParentId = epcParentId;
    }

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName;
    }

    public int getEpcId() {
        return epcId;
    }

    public void setEpcId(int epcId) {
        this.epcId = epcId;
    }

    /*
        epc_id
    epc_name
    epc_parent_id

         */
    private int epcId;
    private String epcName;
    private int epcParentId;
}
