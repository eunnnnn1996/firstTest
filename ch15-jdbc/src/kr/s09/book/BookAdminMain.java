package kr.s09.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookAdminMain {
	private BufferedReader br;
	private BookDAO dao;
	
	public BookAdminMain() {
		dao = new BookDAO();
		
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
			System.out.println("1.회원목록 2.도서등록 3.도서목록 4.대출목록 5.종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				
				if(no==1) {
					dao.selectListMember();
				}else if(no==2) {
					System.out.print("도서명 : ");
					String bk_name = br.readLine();
					System.out.print("분류 : ");
					String bk_category = br.readLine();
					
					BookVO vo = new BookVO();
					vo.setBk_name(bk_name);
					vo.setBk_category(bk_category);
					
					dao.insertBook(vo);
				}else if(no==3) {
					dao.selectListBook();
				}else if(no==4) {
					
				}else if(no==5) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("숫자만 입력 가능!!");
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BookAdminMain();
	}

}
