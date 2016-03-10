import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Test05 {
	public static void main(String args[]){
		float a = 3.0f;
		int a1[] = {0,1,2,3,4,5,6};
		
//		Calendar c = Calendar.getInstance(); 
//		c.getMaximum(Calendar.MONTH); 
//		Date date = new Date(c.getTimeInMillis());
//		System.out.println(date);
//		c.getMinimum(Calendar.MONTH); 
//		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		Calendar cal=Calendar.getInstance();//获取当前日期 
		cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		Date date = new Date(cal.getTimeInMillis());
		System.out.println(sdf.format(date));
		cal.add(Calendar.MONTH,1);//月增加1天 
		cal.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天 
		date = new Date(cal.getTimeInMillis());
		System.out.println(sdf.format(date));
		
	}
	static public void main01(String args[]){
	System.out.println("hello");	
	}
}
