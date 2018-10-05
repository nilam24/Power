package in.cdac.pamr.pojos;

import java.io.Serializable;

/**
 * Created by Dell1 on 11/05/2017.
 */

public class UserDetails implements Serializable{

    private String LOGIN_ID;
    private String PW;
    private String USER_LEVEL;
    private String LOGIN_NAME;
    private String EMP_ID;
    private String DEPT_ID;
    private String DESIGNATION;
    private String REMARKS;
    private String EMAIL_ID;
    private String ISACTIVE;
    private String BLOCKED;
    private String user_name;
    private String address;
    private String plant_location;
    private String plant_capacity;
    private String meterno;

    public UserDetails() {
    }

    public UserDetails(String LOGIN_NAME, String PW) {
        this.LOGIN_NAME = LOGIN_NAME;
        this.PW = PW;
    }

    public String getLOGIN_NAME() {
        return LOGIN_NAME;
    }

    public void setLOGIN_NAME(String LOGIN_NAME) {
        this.LOGIN_NAME = LOGIN_NAME;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

}
