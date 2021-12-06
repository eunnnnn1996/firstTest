package kr.s09.book;

import java.sql.Date;

public class BookVO {
	private int bk_num;
	private String bk_name;
	private String bk_category;
	private Date bk_regdate;
	
	
	public int getBk_num() {
		return bk_num;
	}
	public void setBk_num(int bk_num) {
		this.bk_num = bk_num;
	}
	public String getBk_name() {
		return bk_name;
	}
	public void setBk_name(String bk_name) {
		this.bk_name = bk_name;
	}
	public String getBk_category() {
		return bk_category;
	}
	public void setBk_category(String bk_category) {
		this.bk_category = bk_category;
	}
	public Date getBk_regdate() {
		return bk_regdate;
	}
	public void setBk_regdate(Date bk_regdate) {
		this.bk_regdate = bk_regdate;
	}
}
