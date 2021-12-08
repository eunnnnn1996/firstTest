import java.sql.Date;
import java.text.SimpleDateFormat;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long nowTime = System.currentTimeMillis();
		long checkTime = nowTime - (60*60*1000);
		long checkTime2 = nowTime - (120*60*1000);
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str2 = timeFormat.format(new Date(checkTime));
		String str3 = timeFormat.format(new Date(checkTime2));
		System.out.println();
		System.out.println("cjeckTime ="+str2 + "/"+checkTime);
		System.out.println("cjeckTime2 ="+str3 + "/"+checkTime2);
		
		System.out.println("-----------------------");
		
		if(checkTime > nowTime) {
			System.out.println("¾ÈÁö³µ´Ù");
		}else {
			System.out.println("Áö³µ´Ù");
		}
		System.out.println("----------------------");
	
		
	}

}
