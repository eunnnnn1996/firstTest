package kr.s08.score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreMain {
	private BufferedReader br;
	private ScoreDAO dao;

	public ScoreMain() {
		dao = new ScoreDAO();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(br!=null) try {br.close();}catch(IOException e) {}
		}
	}
	
	public void callMenu() throws IOException{
		while(true) {
			System.out.println("1.성적입력 2.목록보기 3.상세정보 4.수정 5.삭제 6.종료>");
		
		try {
			int no = Integer.parseInt(br.readLine());
			
			if(no ==1) { //성적입력
				System.out.println("이름 : ");
				String name = br.readLine();
				System.out.println("국어 : ");
				int korean = Integer.parseInt(br.readLine());
				System.out.println("영어 : ");
				int english = Integer.parseInt(br.readLine());
				System.out.println("수학 : ");
				int math = Integer.parseInt(br.readLine());
				ScoreVO score = new ScoreVO();
				score.setName(name);
				score.setKorean(korean);
				score.setEnglish(english);
				score.setMath(math);
				
				dao.insertInfo(score);
				
			}else if(no==2) { //목록보기
				 dao.selectListInfo();
			}else if(no==3) { //상세정보
				System.out.print("번호:");
				int num = Integer.parseInt(br.readLine());
				dao.selectDetailInfo(num);
			}else if(no==4) { //수정
				//번호 확인용 목록보기
				dao.selectListInfo();
				System.out.println("----------------------------");
				System.out.print("번호:");
				int num = Integer.parseInt(br.readLine());
				System.out.print("이름:");
				String name = br.readLine();
				System.out.println("국어 : ");
				int korean = Integer.parseInt(br.readLine());
				System.out.println("영어 : ");
				int english = Integer.parseInt(br.readLine());
				System.out.println("수학 : ");
				int math = Integer.parseInt(br.readLine());
				
				ScoreVO score = new ScoreVO();
				score.setNum(num);
				score.setName(name);
				score.setKorean(korean);
				score.setEnglish(english);
				score.setMath(math);
				
				dao.updateInfo(score);
				
				
			}else if(no==5) { // 삭제
				System.out.print("번호:");
				int num = Integer.parseInt(br.readLine());
				
				dao.deleteInfo(num);
			}else if(no==6) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못 입력했습니다.");
			}
			
		}catch(NumberFormatException e) {
			System.out.println("숫자만 입력 가능!!");
		}
		}
	}
	
	public int parseInputData(String cours) throws IOException{
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ScoreMain();
	}

}
