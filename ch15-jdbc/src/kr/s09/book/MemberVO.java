package kr.s09.book;

import java.sql.Date;

public class MemberVO {
	private int me_num; //회원번호
	private String me_id;
	private String me_passwd;
	private String me_name;
	private String me_phone;
	private Date me_regdate;
	public int getMe_num() {
		return me_num;
	}
	public void setMe_num(int me_num) {
		this.me_num = me_num;
	}
	public String getMe_id() {
		return me_id;
	}
	public void setMe_id(String me_id) {
		this.me_id = me_id;
	}
	public String getMe_passwd() {
		return me_passwd;
	}
	public void setMe_passwd(String me_passwd) {
		this.me_passwd = me_passwd;
	}
	public String getMe_name() {
		return me_name;
	}
	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}
	public String getMe_phone() {
		return me_phone;
	}
	public void setMe_phone(String me_phone) {
		this.me_phone = me_phone;
	}
	public Date getMe_regdate() {
		return me_regdate;
	}
	public void setMe_regdate(Date me_regdate) {
		this.me_regdate = me_regdate;
	}
	
	
}
