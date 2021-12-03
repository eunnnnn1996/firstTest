package ProductProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductMain {
	private BufferedReader br;
	private ProductDAO pro;
	
	public ProductMain() {
		pro = new ProductDAO();
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			choiceMenu();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(br!=null) try {br.close();}catch(IOException e) {}
		}

	}
	
	
	private void choiceMenu() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("1.물건등록 2.물건보기 3.상세글보기 4.글삭제 5.글수정 6.종료>");
		try {
		int no = Integer.parseInt(br.readLine());
		while(true) {
			if(no == 1) {
				
				System.out.println("물건이름>");
				String proname = br.readLine();
				
				
				System.out.println("가격>");
				int price =  Integer.parseInt(br.readLine());
				
				System.out.println("개수>");
				int count = Integer.parseInt(br.readLine());
				
				System.out.println("물건상태>");
				String condition = br.readLine();
				
				
				pro.InsertProduct(proname, price, count, condition);
			} else if(no==2) {
				
				
				pro.SelectProduct();
				
				
			}else if(no==3) {
				
			}
			else if(no == 4) {
				System.out.println("삭제할 행의 번호 입력>");
				int num = Integer.parseInt(br.readLine());
				pro.DeleteProduct(num);
			}else if(no==5) {
				
				

				System.out.println("수정할 행의 번호 입력>");
				int num = Integer.parseInt(br.readLine());
				
				System.out.println("물건이름>");
				String proname = br.readLine();
				
				System.out.println("가격>");
				int price =  Integer.parseInt(br.readLine());
				
				System.out.println("개수>");
				int count = Integer.parseInt(br.readLine());
				
				System.out.println("물건상태>");
				String condition = br.readLine();
				
				pro.UpdateProduct(proname, price, count, condition,num);
				
			}else if(no==6) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
	}catch(NumberFormatException e) {e.printStackTrace();}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProductMain();
	}

	}

	
