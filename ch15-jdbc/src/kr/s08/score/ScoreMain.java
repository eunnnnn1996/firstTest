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
			System.out.println("1.�����Է� 2.��Ϻ��� 3.������ 4.���� 5.���� 6.����>");
		
		try {
			int no = Integer.parseInt(br.readLine());
			
			if(no ==1) { //�����Է�
				System.out.println("�̸� : ");
				String name = br.readLine();
				System.out.println("���� : ");
				int korean = Integer.parseInt(br.readLine());
				System.out.println("���� : ");
				int english = Integer.parseInt(br.readLine());
				System.out.println("���� : ");
				int math = Integer.parseInt(br.readLine());
				ScoreVO score = new ScoreVO();
				score.setName(name);
				score.setKorean(korean);
				score.setEnglish(english);
				score.setMath(math);
				
				dao.insertInfo(score);
				
			}else if(no==2) { //��Ϻ���
				 dao.selectListInfo();
			}else if(no==3) { //������
				System.out.print("��ȣ:");
				int num = Integer.parseInt(br.readLine());
				dao.selectDetailInfo(num);
			}else if(no==4) { //����
				//��ȣ Ȯ�ο� ��Ϻ���
				dao.selectListInfo();
				System.out.println("----------------------------");
				System.out.print("��ȣ:");
				int num = Integer.parseInt(br.readLine());
				System.out.print("�̸�:");
				String name = br.readLine();
				System.out.println("���� : ");
				int korean = Integer.parseInt(br.readLine());
				System.out.println("���� : ");
				int english = Integer.parseInt(br.readLine());
				System.out.println("���� : ");
				int math = Integer.parseInt(br.readLine());
				
				ScoreVO score = new ScoreVO();
				score.setNum(num);
				score.setName(name);
				score.setKorean(korean);
				score.setEnglish(english);
				score.setMath(math);
				
				dao.updateInfo(score);
				
				
			}else if(no==5) { // ����
				System.out.print("��ȣ:");
				int num = Integer.parseInt(br.readLine());
				
				dao.deleteInfo(num);
			}else if(no==6) {
				System.out.println("���α׷� ����");
				break;
			}else {
				System.out.println("�߸� �Է��߽��ϴ�.");
			}
			
		}catch(NumberFormatException e) {
			System.out.println("���ڸ� �Է� ����!!");
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
