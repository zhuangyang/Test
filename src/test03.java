import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class test03 {
	public static void main(String[] args) throws Exception{
		
		Calendar calstart = Calendar.getInstance(); 
		Date punchDta = calstart.getTime();
		SimpleDateFormat sdf01 = new SimpleDateFormat("yyyy-M-d");
		SimpleDateFormat sdf02 = new SimpleDateFormat("HH:mm:ss");
		System.out.println("sdf01="+sdf01.format(punchDta));
		System.out.println("sdf02="+sdf02.format(punchDta));
		
		int i =0;
		String[] yearmonth = "2015-09".split("-");
		System.out.println("yearmonth="+Integer.parseInt(yearmonth[0]));
		System.out.println("yearmonth="+yearmonth[1]);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M");
		String month = "2015-09";
//		date = sdf.parse( "2015-11-22 14:34:09" );
		System.out.println(sdf.parse(month));
		System.out.println(sdf.format(sdf.parse(month)));
		
		test12();
		Date date02 = new Date("transTime");
		String timestamp = String.valueOf(date02.getTime());
		System.out.println("timestamp="+timestamp);
	}
	
	public static int test12() throws ParseException{
		String currentDate = "2015-11-20";
		Calendar cweek = Calendar.getInstance();
		System.out.println("cweek="+cweek);
		
		String str="2012-5-27";
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-M-d");
		Date date =sdf.parse(str);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar);
		
		return 0;
	}
	
	
	public static int test11() throws ParseException{
		String currentDay = new String();
		int actUserDay = 0;
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-M-d");
		Date myDate1 = dateFormat1.parse("2015-11-11");
		Calendar cweek=Calendar.getInstance();
		cweek.setTime(myDate1);
		//Calendar cweek = Calendar.getInstance();
		int day_of_week = cweek.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0){
			day_of_week = 7;
		}
		cweek.add(Calendar.DATE, -day_of_week + 1);
		StringBuffer actUserWeekBuffer = new StringBuffer("["); 
		String actUserWeekDatas = new String();
		cweek.add(Calendar.DATE,-1);
		for(int i=0; i<7; i++){
			cweek.add(Calendar.DATE,1);
			currentDay = dateFormat1.format(cweek.getTime());
			System.out.println("currentDay="+currentDay);
		}
		return day_of_week;
	}
	
	public static int  getCurrentMonthDays() {
		Calendar a = Calendar.getInstance();  
		a.set(Calendar.DATE, 1);  
		a.roll(Calendar.DATE, -1);  
		int maxDate = a.get(Calendar.DATE);  
		return maxDate; 
	}
	
	public static String getMondayOfThisMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		Calendar cmonth = Calendar.getInstance();
		cmonth.add(Calendar.MONTH, 0);
		cmonth.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		System.out.println("cmonth="+sdf.format(cmonth.getTime()));
		
		
		//cmonth.set(Calendar.DATE, 1);  
		cmonth.roll(Calendar.DATE, -1);  
        int maxDate = cmonth.get(Calendar.DATE);  
		System.out.println("maxDate="+maxDate);
		System.out.println("cmonth="+sdf.format(cmonth.getTime()));
		StringBuffer actUserWeekBuffer = new StringBuffer("["); 
		String actUserWeekDatas = new String();
		String currentDay = new String();
		for(int i=0; i<7; i++){
			/*cmonth.add(Calendar.DATE,1);
			currentDay = sdf.format(cmonth.getTime());
			System.out.println("currentDay="+currentDay);
			actUserWeekBuffer.append(1111);
			actUserWeekBuffer.append(",");
			if(i == 6){
				System.out.println("actUserWeekBuffer="+actUserWeekBuffer);
				actUserWeekDatas = actUserWeekBuffer.substring(0, actUserWeekBuffer.length()-1);
				actUserWeekDatas = actUserWeekDatas + "]";
				System.out.println("actUserWeekDatas="+actUserWeekDatas);
			}
			*/
		}
		return null;
	 }
	
	public static String getMondayOfThisWeek() {
		/*
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
	  Calendar c = Calendar.getInstance();
	  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
	  if (day_of_week == 0)
	  day_of_week = 7;
	  c.add(Calendar.DATE, -day_of_week + 1);
	  System.out.println("getMondayOfThisWeek="+sdf.format(c.getTime()));
	  c.add(Calendar.DATE,1);
	  System.out.println("getMondayOfThisWeek="+sdf.format(c.getTime()));
	  
	  return sdf.format(c.getTime());
	  */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		Calendar c = Calendar.getInstance();
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0){
			day_of_week = 7;
		}
		c.add(Calendar.DATE, -day_of_week);
		StringBuffer actUserWeekBuffer = new StringBuffer("["); 
		String actUserWeekDatas = new String();
		String currentDay = new String();
		for(int i=0; i<7; i++){
			c.add(Calendar.DATE,1);
			currentDay = sdf.format(c.getTime());
			System.out.println("currentDay="+currentDay);
			actUserWeekBuffer.append(1111);
			actUserWeekBuffer.append(",");
			if(i == 6){
				System.out.println("actUserWeekBuffer="+actUserWeekBuffer);
				actUserWeekDatas = actUserWeekBuffer.substring(0, actUserWeekBuffer.length()-1);
				actUserWeekDatas = actUserWeekDatas + "]";
				System.out.println("actUserWeekDatas="+actUserWeekDatas);
			}
		}
		return null;
	 }
	
	public static void test05() throws Exception{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
		String url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=E:/DB2/db1.mdb";
		Connection con = DriverManager.getConnection(url); 
		Statement st = con.createStatement(); 
//		String sql = "select * from IOData where CardNo = '1432'"; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
		Date date;
		date = sdf.parse( "2012-6-29 14:34:09" );
			sdf.format(date);
			String dateNow = sdf.format(date).toString();
			String[] dateNowStr = dateNow.split(" ");
			
			String dateLater = sdf.format(new Date(date.getTime() -5 * 1000));
			String[] strLaterStr = dateLater.split(" ");
//			{cardNo=0616, currentDay=2015-9-16, userid=000004@smartdot}
			String sql =  "select  CardNo,HolderNo,HolderName, "+
			"format(IODate,'yyyy-m-d') as IODateTime, "+
			"MIN(IOTime) as earlytime, "+
			"MAX(IOTime) as latertime, "+
			"format(IODate,'d') as daydate "+
			 "from IOData "+
			 "where format(IODate,'yyyy-m-d') = '2015-9-16' "+
			 "and CardNo = '0616' "+
			 "group by CardNo,HolderNo,HolderName,IODate ";
			
//			String sql =  "select  CardNo,HolderNo,HolderName, "+
//			 "format(IODate,'yyyy-m-d') as IODateTime, "+
//			 "MIN(IOTime) as earlytime, "+
//			 "MAX(IOTime) as latertime, "+
//			 "format(IODate,'d') as daydate "+
//			 "from IOData "+
//			 "where format(IODate,'yyyy-m') = '2015-9' "+
//			 "and CardNo = '0082' "+
//			 "group by CardNo,HolderNo,HolderName,IODate ";
			
//		String sql = "select CardNo,HolderNo,HolderName,format(IODate,'yyyy-m') as timeaaa,IOTime " +
//					 "from IOData " +
//					 "where format(IODate,'yyyy-m') = '2012-10'" +
//					 "and CardNo = '0165' ";
//		String sql = "select * from IOData " +
//		"where Format(#IODate#, 'yyyy') = #2012#";
//		"where datepart(\"yyyy\",#"+dateNowStr[0]+"#)="+dateNowStr[0].substring(0,4);
//		String sql = "select * from IOData " +
//		"where IODate like '%'&#"+dateNowStr[0]+"#&'%'  "
//		+ "and CardNo = '0349' "; 
//		"where IODate between #2012-6-29# ";
  		
		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println("CardNo ="+rs.getString(1));
			System.out.println("HolderNo ="+rs.getString(2));
			System.out.println("HolderName ="+
					new String(rs.getBytes("HolderName"),"GB2312")
			);
//			new String(rs.getBytes("HolderName"),"UTF-8");
			System.out.println("IODate ="+rs.getString(4));
			System.out.println("earlytime ="+rs.getString(5));
			System.out.println("latertime ="+rs.getString(6));
		}
	} 
	
	public static void test01() throws Exception{
//		Date date = new Date("2015-9-2 14:34:04");
		SimpleDateFormat datefor = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
		Date date = datefor.parse( "2015-9-2 14:34:04" );
		datefor.format(date);
		String datestr = datefor.format(date).toString();
		String[] strs = datestr.split(" ");
		for (String string : strs) {
			System.out.println("string="+string);
		}
		System.out.println("当前时间："+datefor.format(date));   
		System.out.println("5s前          ："+datefor.format(new Date(date.getTime() -5 * 1000)));  
		/**
		  SimpleDateFormat函数语法：
		  G 年代标志符
		  y 年
		  M 月
		  d 日
		  h 时 在上午或下午 (1~12)
		  H 时 在一天中 (0~23)
		  m 分
		  s 秒
		  S 毫秒
		  E 星期
		  D 一年中的第几天
		  F 一月中第几个星期几
		  w 一年中第几个星期
		  W 一月中第几个星期
		  a 上午 / 下午 标记符 
		  k 时 在一天中 (1~24)
		  K 时 在上午或下午 (0~11)
		  z 时区
		 */
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url = "jdbc:odbc:JDBC-ODBC";
		Properties pro = new Properties();
		 pro.setProperty("charSet","GB2312");
		Connection con = DriverManager.getConnection(url,pro); 
		Statement st = con.createStatement(); 
		String sql = "select * from IOData " +
				"where IODate between #2012-6-29# and #2012-6-29# " +
				"  and IOTime between '07:21:28'  and '07:21:28' "; 
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println("CardNo ="+rs.getString(1));
			System.out.println("HolderNo ="+rs.getString(2));
			System.out.println("HolderName ="+rs.getString(3));
			System.out.println("IODate ="+rs.getString(4));
			System.out.println("IOTime ="+rs.getString(5));
		}
	}
	
	public static void test02() throws Exception{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
		String url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=E:/DB2/db1.mdb";
		Connection con = DriverManager.getConnection(url); 
		Statement st = con.createStatement(); 
//		String sql = "select * from IOData where CardNo = '1432'"; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
		Date date;
		date = sdf.parse( "2015-9-2 14:34:09" );
			sdf.format(date);
			String dateNow = sdf.format(date).toString();
			String[] dateNowStr = dateNow.split(" ");
			
			String dateLater = sdf.format(new Date(date.getTime() -5 * 1000));
			String[] strLaterStr = dateLater.split(" ");
			
		String sql = "select * from IOData " +
		"where IODate between #"+dateNowStr[0]+"# and #"+dateNowStr[0]+"# " +
		"  and IOTime between '"+dateNowStr[1]+"' and '"+strLaterStr[1]+"' "; 
  			System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println("CardNo ="+rs.getString(1));
			System.out.println("HolderNo ="+rs.getString(2));
			System.out.println("HolderName ="+
					new String(rs.getBytes("HolderName"),"GB2312")
			);
//			new String(rs.getBytes("HolderName"),"UTF-8");
			System.out.println("IODate ="+rs.getString(4));
			System.out.println("IOTime ="+rs.getString(5));
		}
	}
}


