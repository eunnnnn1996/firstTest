interface good{
	int i = 31313;
	public void prt();
}
class B implements good{
	public void prt() {
		System.out.println("a");

	}
}
public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		b.prt();
		System.out.println(b.i);
	}

}
