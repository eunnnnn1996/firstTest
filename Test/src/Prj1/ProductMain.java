package Prj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Menu {
	ArrayList<Product> list;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public void start() throws NumberFormatException, IOException {
	while(true)
	{
		
			System.out.println("1.��ǰ�Է� 2.��ǰ��� 3.����");
			int num = Integer.parseInt(br.readLine());
			if (num == 1) {
				input();
			} else if (num == 2) {
				output();
			} else if (num == 3) {
				System.out.println("�ý��� ����");
				break;
			}

	}
	}
	
	private void output() {
		// TODO Auto-generated method stub
		try {
		for(Product p : list) {
			System.out.println(p.getName());
			System.out.println(p.getNum());
			System.out.println(p.getPrice());
			System.out.println(p.getCondition());
		}
		}catch(Exception e) {}
		
	}
	private void input() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Product p = new Product();
		try {
		System.out.println("��ǰ�� : ");
		p.setName(br.readLine());
		System.out.println("���� : ");
		p.setPrice(Integer.parseInt(br.readLine()));
		System.out.println("���� : ");
		p.setNum(Integer.parseInt(br.readLine()));
		System.out.println("���� : ");
		p.setCondition(Integer.parseInt(br.readLine()));
		list.add(p);
		}catch(Exception e) {
			System.out.println("����");
		}
		
	}

	
}

public class ProductMain {
	public static void main(String[] args) throws NumberFormatException, IOException {
	Menu mu = new Menu();
	mu.start();
}
}
