package sdkd.com.ec.model;

import java.util.Date;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbNews {
    private Integer enId;
    private String enTitle;
    private String enContent;
    private Date enCreateTime;

    public Integer getEnId() {
        return enId;
    }

    public void setEnId(Integer enId) {
        this.enId = enId;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    public String getEnContent() {
        return enContent;
    }

    public void setEnContent(String enContent) {
        this.enContent = enContent;
    }

    public Date getEnCreateTime() {
        return enCreateTime;
    }

    public void setEnCreateTime(Date enCreateTime) {
        this.enCreateTime = enCreateTime;
    }
}
