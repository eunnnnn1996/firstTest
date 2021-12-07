package kr.s09.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookUserMain {

	private BufferedReader br;
	private BookDAO dao;
	private boolean flag; //�α��� O : true , �α��� X : false
	private int me_num; // ȸ����ȣ
	
	public BookUserMain() {
		dao = new BookDAO();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	public void callMenu() throws IOException{
		
		while(true) {
			System.out.print("1.�α��� 2.ȸ������ 3.����>");
			
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) {
					System.out.println("���̵� : ");
					String me_id = br.readLine();
					
					System.out.println("��й�ȣ : ");
					String me_passwd = br.readLine();
					
					me_num = dao.loginCheck(me_id, me_passwd);
					
					if(me_num!=0) {
						System.out.println(me_id + "("+me_num+")"+"�� �α��� �Ǿ����ϴ�");
						flag = true;
						break;
					}
					System.out.println("���̵� �Ǵ� ��й�ȣ�� ����ġ�մϴ�.");
					
				
				}else if(no==2) {
					System.out.print("���̵� : ");
					String me_id = br.readLine();
					
					//���̵� �ߺ� üũ
					int check = dao.checkId(me_id);
					if(check ==1) {
						System.out.println("���̵� �ߺ��Ǿ����ϴ�.");
						continue;
					}
					
					
					System.out.print("��й�ȣ : ");
					String me_passwd = br.readLine();
					
					System.out.print("�̸� : ");
					String me_name = br.readLine(); 
					
					System.out.print("��ȭ��ȣ : ");
					String me_phone = br.readLine();
					
					MemberVO vo = new MemberVO();
					vo.setMe_id(me_id);
					vo.setMe_passwd(me_passwd);
					vo.setMe_name(me_name);
					vo.setMe_phone(me_phone);
					
					dao.insertMember(vo);
				
				}else if(no==3) {
					System.out.println("���α׷� ����");
					break;
				}else {
					System.out.println("�߸� �Է��߽��ϴ�.");
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("���ڸ� �Է°���!!");
			}
		}
		
		
		while(flag) {
			System.out.println("1.������� 2.���������ϱ� 3.MY������ 4.����>");
			
			try {
				int no = Integer.parseInt(br.readLine());
				if(no==1) {
					dao.selectListBook();
				}else if(no==2) {
					System.out.println("====�����˻�=====");
					dao.selectListBook();
					
					//while(true) {
						System.out.println("���⵵����ȣ:");
						int bk_num = Integer.parseInt(br.readLine());
						
						ReservationVO vo = new ReservationVO();
						vo.setMe_num(me_num); //ȸ����ȣ
						vo.setBk_num(bk_num); //������ȣ
						
						dao.insertReservation(vo);	
					//}
						
				}else if(no==3) {
					dao.selectMyList(me_num);
					
				}else if(no==4) {
					System.out.println("���α׷� ����");
					break;
				}else {
					System.out.println("�߸��Է�");
				}
						
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("���ڸ� �Է°���!!");
			}
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BookUserMain();
	}

}
