package arraylisttest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Movie {
	private String name;
	private int price;
	private int num;
	
	public Movie(String name , int price , int num) {	
		this.name = name;
		this.price = price;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
class Input{
	BufferedReader br;
	public void input() throws IOException {
		//System.out.println("영화 이름 입력 : ");
		//String name = br.readLine();
		//System.out.println("가격 입력 : ");
		//int price = Integer.parseInt(br.readLine());
		//System.out.println("인원 입력 : ");
		//int num = Integer.parseInt(br.readLine());
		
		//Movie m = new Movie();
		
		//m.setName(name);
		//m.setPrice(price);
		//m.setNum(num);
		ArrayList<Movie> list = new ArrayList();
		list.add(new Movie("한국영화",11000 , 2));
		list.add(new Movie("미국영화",22000 , 33));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("영화이름 입력>");
		String name = br.readLine();
		System.out.println("영화가격 입력>");
		int price = Integer.parseInt(br.readLine());
		System.out.println("인원 입력>");
		int num = Integer.parseInt(br.readLine());
		
		list.add(new Movie(name,price,num));
		
		for(Movie m : list) {
			System.out.println(m.getName()+m.getNum()+m.getPrice());
		}
	}
}

public class arrayList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Input in = new Input();
		in.input();
	}

}
