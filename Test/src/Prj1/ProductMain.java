package Prj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Menu {
	ArrayList<Product> list;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void start() throws NumberFormatException, IOException {
		while (true) {

			System.out.println("1.제품입력 2.제품출력 3.종료");
			int num = Integer.parseInt(br.readLine());
			if (num == 1) {
				input();
			} else if (num == 2) {
				output();
			} else if (num == 3) {
				System.out.println("시스템 종료");
				break;
			}

		}
	}
	public Menu() {
		list = new ArrayList<Product>();
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			start();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(br != null)
				try {
					br.close();
				}catch (IOException e) {}
		}
	}

	private void output() {
		// TODO Auto-generated method stub

		for(Product p : list) {
			System.out.print(p.getName());
			System.out.print(p.getNum());
			System.out.print(p.getPrice());
			System.out.println(p.getCondition());	
			}
	}
	private void input() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Product p = new Product();
		try {
			System.out.print("제품명 : ");
			p.setName(br.readLine());
			System.out.print("가격 : ");
			p.setPrice(Integer.parseInt(br.readLine()));
			System.out.print("갯수 : ");
			p.setNum(Integer.parseInt(br.readLine()));
			System.out.print("상태 : ");
			p.setCondition(Integer.parseInt(br.readLine()));
			list.add(p);
		} catch (Exception e) {
			System.out.println("오류");
		}

	}

}

public class ProductMain {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Menu mu = new Menu();
		mu.start();
	}
}
