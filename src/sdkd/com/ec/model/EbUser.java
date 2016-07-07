package sdkd.com.ec.model;

import java.util.Date;

/**
 * 用户表
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUser {
    /*
    eu_user_id
eu_user_name
eu_password
eu_sex
eu_birthday
eu_identity_code
eu_email
eu_mobile
eu_address
eu_status

     */
    private int euUserId;
    private String  euUserName;
    private String euPassword;
    private String euSex;
    private Date euBirthday;
    private String euIdentityCode;
    private String euEmail;
    private String euMobile;
    private String euAddress;
    private int  euStatus;

    public int getEuUserId() {
        return euUserId;
    }

    public void setEuUserId(int euUserId) {
        this.euUserId = euUserId;
    }

    public String getEuUserName() {
        return euUserName;
    }

    public void setEuUserName(String euUserName) {
        this.euUserName = euUserName;
    }

    public String getEuPassword() {
        return euPassword;
    }

    public void setEuPassword(String euPassword) {
        this.euPassword = euPassword;
    }

    public String getEuSex() {
        return euSex;
    }

    public void setEuSex(String euSex) {
        this.euSex = euSex;
    }

    public Date getEuBirthday() {
        return euBirthday;
    }

    public void setEuBirthday(Date euBirthday) {
        this.euBirthday = euBirthday;
    }

    public String getEuIdentityCode() {
        return euIdentityCode;
    }

    public void setEuIdentityCode(String euIdentityCode) {
        this.euIdentityCode = euIdentityCode;
    }

    public String getEuEmail() {
        return euEmail;
    }

    public void setEuEmail(String euEmail) {
        this.euEmail = euEmail;
    }

    public String getEuMobile() {
        return euMobile;
    }

    public void setEuMobile(String euMobile) {
        this.euMobile = euMobile;
    }

    public String getEuAddress() {
        return euAddress;
    }

    public void setEuAddress(String euAddress) {
        this.euAddress = euAddress;
    }

    public int getEuStatus() {
        return euStatus;
    }

    public void setEuStatus(int euStatus) {
        this.euStatus = euStatus;
    }
}
