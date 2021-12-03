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
		System.out.println("1.���ǵ�� 2.���Ǻ��� 3.�󼼱ۺ��� 4.�ۻ��� 5.�ۼ��� 6.����>");
		try {
		int no = Integer.parseInt(br.readLine());
		while(true) {
			if(no == 1) {
				
				System.out.println("�����̸�>");
				String proname = br.readLine();
				
				
				System.out.println("����>");
				int price =  Integer.parseInt(br.readLine());
				
				System.out.println("����>");
				int count = Integer.parseInt(br.readLine());
				
				System.out.println("���ǻ���>");
				String condition = br.readLine();
				
				
				pro.InsertProduct(proname, price, count, condition);
			} else if(no==2) {
				
				
				pro.SelectProduct();
				
				
			}else if(no==3) {
				
			}
			else if(no == 4) {
				System.out.println("������ ���� ��ȣ �Է�>");
				int num = Integer.parseInt(br.readLine());
				pro.DeleteProduct(num);
			}else if(no==5) {
				
				

				System.out.println("������ ���� ��ȣ �Է�>");
				int num = Integer.parseInt(br.readLine());
				
				System.out.println("�����̸�>");
				String proname = br.readLine();
				
				System.out.println("����>");
				int price =  Integer.parseInt(br.readLine());
				
				System.out.println("����>");
				int count = Integer.parseInt(br.readLine());
				
				System.out.println("���ǻ���>");
				String condition = br.readLine();
				
				pro.UpdateProduct(proname, price, count, condition,num);
				
			}else if(no==6) {
				System.out.println("���α׷� ����");
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

	
