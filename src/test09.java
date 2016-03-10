import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.sun.org.apache.bcel.internal.generic.CASTORE;


public class test09 {
	public static void main(String[] args){
    	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    	new Timestamp(Long.parseLong("1453952419000"));
    	String aa = sdf.format(new Timestamp(Long.parseLong("1453952419000")));
    	System.out.println("aa=" + aa);
		String str01 = "aaa";
		String str02  = str01;
		System.out.println(str01.equals(str02));
		System.out.println(str01==str02);
		str01 = "bbb";
		System.out.println(str01.equals(str02));
		System.out.println(str01==str02);
		System.out.println("========================");
		int int01 = 111;
		int int02  = int01;
		System.out.println(int01==int02);
		int01 = 222;
		System.out.println(str01==str02);
		try {
			System.out.println("11111");
			throw new java.lang.NullPointerException();
		} catch (Exception e) {
			System.out.println("22222");
			return;
		}
		finally{
			System.out.println("33333");
			return;
		}
	}
	
}
