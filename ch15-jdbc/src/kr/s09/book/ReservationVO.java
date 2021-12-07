package kr.s09.book;

import java.sql.Date;

public class ReservationVO {
	private int re_num; //대출번호
	private int bk_num; //도서번호
	private int me_num; //회원번호
	private int re_status; //대출여부(0:반납,미대출 1:대출중)
	private Date re_regdate; //대출일 
	private Date re_modifydate; //반납일
	
	
	int getRe_num() {
		return re_num;
	}
	void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	int getBk_num() {
		return bk_num;
	}
	void setBk_num(int bk_num) {
		this.bk_num = bk_num;
	}
	int getMe_num() {
		return me_num;
	}
	void setMe_num(int me_num) {
		this.me_num = me_num;
	}
	int getRe_status() {
		return re_status;
	}
	void setRe_status(int re_status) {
		this.re_status = re_status;
	}
	Date getRe_regdate() {
		return re_regdate;
	}
	void setRe_regdate(Date re_regdate) {
		this.re_regdate = re_regdate;
	}
	Date getRe_modifydate() {
		return re_modifydate;
	}
	void setRe_modifydate(Date re_modifydate) {
		this.re_modifydate = re_modifydate;
	}
}
