package sdkd.com.ec.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/6.
 */
public class EbNotice {
    private int  noId;
    private String noTitle;
    private String noContent;
    private Date noCreateTime;

    public int getNoId() {
        return noId;
    }

    public void setNoId(int noId) {
        this.noId = noId;
    }

    public String getNoTitle() {
        return noTitle;
    }

    public void setNoTitle(String noTitle) {
        this.noTitle = noTitle;
    }

    public String getNoContent() {
        return noContent;
    }

    public void setNoContent(String noContent) {
        this.noContent = noContent;
    }

    public Date getNoCreateTime() {
        return noCreateTime;
    }

    public void setNoCreateTime(Date noCreateTime) {
        this.noCreateTime = noCreateTime;
    }
}
