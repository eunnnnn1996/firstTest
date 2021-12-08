

import java.sql.Date;

public class StudentVO {

    private int st_num;
    private String st_id;
    private String st_passwd;
    private String st_name;
    private String st_major;
    private int st_info;
    private int st_phone;
    private String st_email;
    private double st_score;
    private Date st_regdate;

    public int getSt_num() {
        return st_num;
    }
    public void setSt_num(int st_num) {
        this.st_num = st_num;
    }
    public String getSt_id() {
        return st_id;
    }
    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }
    public String getSt_passwd() {
        return st_passwd;
    }
    public void setSt_passwd(String st_passwd) {
        this.st_passwd = st_passwd;
    }
    public String getSt_name() {
        return st_name;
    }
    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }
    public String getSt_major() {
        return st_major;
    }
    public void setSt_major(String st_major) {
        this.st_major = st_major;
    }
    public int getSt_info() {
        return st_info;
    }
    public void setSt_info(int st_info) {
        this.st_info = st_info;
    }
    public int getSt_phone() {
        return st_phone;
    }
    public void setSt_phone(int st_phone) {
        this.st_phone = st_phone;
    }
    public String getSt_email() {
        return st_email;
    }
    public void setSt_email(String st_email) {
        this.st_email = st_email;
    }
    public double getSt_score() {
        return st_score;
    }
    public void setSt_score(double st_score) {
        this.st_score = st_score;
    }
    public Date getSt_regdate() {
        return st_regdate;
    }
    public void setSt_regdate(Date st_regdate) {
        this.st_regdate = st_regdate;
    }


}
