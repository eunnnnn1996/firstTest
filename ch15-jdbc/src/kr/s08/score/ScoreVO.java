package kr.s08.score;

import java.sql.Date;

public class ScoreVO { // VO는 테이블의 행에 정보를 제공하고 행으로부터 값을 읽어와서 값을 저장하는 객체
	private int num; //번호
	private String name; //이름
	private int korean; //국어
	private int english; //영어
	private int math; //수학
	private int sum; //총점
	private int avg; //평균
	private String grade; //등급
	private Date reg_date; //등록일
	
	public int makeSum() {
		return korean+english+math;
	}
	
	public int makeAvg() {
		return makeSum()/3;
	}
	
	public String makeGrade() {
		String grade;
		switch (makeAvg()/10) {
		case 10:
		case 9: grade = "A";break;
		case 8:	grade = "B";break;
		case 7:	grade = "C";break;
		case 6:	grade = "D";break;
		default: grade = "F";
			break;
		}
		return grade;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

}
