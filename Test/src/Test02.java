import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���ڸ� �Է��ϼ��� : ");
		int num = Integer.parseInt(bu.readLine());
		System.out.println(num);
	}

}
