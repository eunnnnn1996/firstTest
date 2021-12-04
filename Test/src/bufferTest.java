import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bufferTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int korean = parseInputData("±¹¾î : ");
		int num = Integer.parseInt(br.readLine());
		System.out.println(num);
	}

}
