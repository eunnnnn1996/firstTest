package kr.s08.score;

import java.sql.Date;

public class ScoreVO { // VO�� ���̺��� �࿡ ������ �����ϰ� �����κ��� ���� �о�ͼ� ���� �����ϴ� ��ü
	private int num; //��ȣ
	private String name; //�̸�
	private int korean; //����
	private int english; //����
	private int math; //����
	private int sum; //����
	private int avg; //���
	private String grade; //���
	private Date reg_date; //�����
	
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