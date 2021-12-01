
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
	int Number = num(3,0);
	System.out.println(Number);
		}catch(Exception e) {
			System.out.println("0Á¦¿Ü");
		}
	}
	
public static int num(int i , int j) throws Exception{
	int k = i/j;
	return k;
}
}
