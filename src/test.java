

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class test {
	public static void main(String[] args){
	    try {
	    	
	    	MyThread myThread1 = new MyThread();  
	    	MyThread myThread2 = new MyThread();
	    	
	    	myThread1.start();  
	    	myThread2.start();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      
  }
	public static void test10(){
	    try {
	    	
	    	test08();
	    	Date date = new Date();
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm");
	    	sdf.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test09(){
		  List<String> list = new ArrayList<String>();
	       List<String> list2 = new ArrayList<String>();   
	       list.add("重");
	       list.add("复");
	       list.add("的");
	       list.add("值");
	       list.add("值");
	       list.add("值");
	       list.add("去");
	       list.add("除");
	       list.add("重");
	       list.add("复");
	       list.add("的");
	       list.add("值");
	       list.add("值");
	       list.add("值");
	       list.add("去");
	       list.add("除");
	        for (int i=0;i<list.size();i++){
	            if(!list2.contains(list.get(i))) 
	            	list2.add(list.get(i));
	        }
	        System.out.println(list2);//去队重复后
	}
	
	public static void test08() throws DocumentException{
		//解析字符串
		String xmlStr = 
			"<monitor type='hello' msgid='15632' timestamp='15454878512' result='ok'> " +
			"<server " +
				"id='d2126675-79f4-45e7-b338-aea349f0bc51' " +
				"name='sys01' " +
				"type='RabbitMQ(Client)01' " +
				"memo='sys' " +
				"ip='192.168.0.1;192.168.0.2' " +
				"version='1.9.2'  >" +
				"</server>"+
			"<server " +
				"id='d2126675-79f4-45e7-b338-aea349f0bc51' " +
				"name='sys02' " +
				"type='RabbitMQ(Client)02' " +
				"memo='sys' " +
				"ip='192.168.0.1;192.168.0.2' " +
				"version='1.9.2'  >" +
				"</server>"+
			"</monitor>"; 
		 Document document = DocumentHelper.parseText(xmlStr);
		 Element root = document.getRootElement(); 
		 for(Iterator it=root.elementIterator();it.hasNext();){      
		        Element book = (Element) it.next();  
		        String type=book.attributeValue("type");
		        String name=book.attributeValue("name");
				  System.out.println("type："+type);
				  System.out.println("name："+name);
		       System.out.println(book.toString()); 
		 }
//		 String str="<root><book type='science01'><Name>Java01</Name><price>10001</price></book>" +
//		 				  "<book type='science02'><Name>Java02</Name><price>10002</price></book>" +
//		 			"</root>";
//		  //生成一个Document
//		 Document document = DocumentHelper.parseText(str);
//		 Element root = document.getRootElement(); 
//		 for(Iterator it=root.elementIterator();it.hasNext();){      
//		        Element book = (Element) it.next();  
//		        String type=book.attributeValue("type");
//				  Element name=book.element("Name");
//				  String bookname=name.getText();
//				  int price=Integer.parseInt(book.element("price").getText());
//				  System.out.println("书名："+bookname);
//				  System.out.println("所属类别："+type);
//				  System.out.println("价格："+price);
//		       System.out.println(book.toString()); 
//		 }
	}
	
	public static void test07() throws DocumentException{
		String xmlStr = 
			"<monitor type='hello' msgid='15632' timestamp='15454878512' result='ok'> " +
			"<server " +
				"id='d2126675-79f4-45e7-b338-aea349f0bc51' " +
				"name='sys' " +
				"type='RabbitMQ(Client)' " +
				"memo='sys' " +
				"ip='192.168.0.1;192.168.0.2' " +
				"version='1.9.2'  >" +
				"</server>"+
			"<server " +
				"id='d2126675-79f4-45e7-b338-aea349f0bc51' " +
				"name='sys' " +
				"type='RabbitMQ(Client)' " +
				"memo='sys' " +
				"ip='192.168.0.1;192.168.0.2' " +
				"version='1.9.2'  >" +
				"</server>"+
			"</monitor>"; 
		//解析字符串
		 String str="<root><book type='science01'><Name>Java01</Name><price>10001</price></book>" +
		 				  "<book type='science02'><Name>Java02</Name><price>10002</price></book>" +
		 			"</root>";
		  //生成一个Document
		  Document document = DocumentHelper.parseText(str);
		  //取得根结点
		  Element root=document.getRootElement();
		  Element book=root.element("book");
		  String type=book.attributeValue("type");
		  Element name=book.element("Name");
		  String bookname=name.getText();
		  int price=Integer.parseInt(book.element("price").getText());
		  System.out.println("书名："+bookname);
		  System.out.println("所属类别："+type);
		  System.out.println("价格："+price);
		  
		  Document document01=DocumentHelper.parseText(xmlStr);
		  System.out.println(document.asXML());
		  System.out.println(document01.asXML());
		  Element root01=document01.getRootElement();
		  String  timestamp01 = root01.attributeValue("timestamp");
		  String  type01 = root01.attributeValue("type");
		  String  msgid01 = root01.attributeValue("msgid");
		  System.out.println(timestamp01);
		  System.out.println(type01);
		  System.out.println(msgid01);
		  
		  String server01 = document01.getRootElement().element("server").attributeValue("id");
		  String server02 = document01.getRootElement().element("server").attributeValue("name");
		  String server03 = document01.getRootElement().element("server").attributeValue("type");
		  String server04 = document01.getRootElement().element("server").attributeValue("memo");
		  String server05 = document01.getRootElement().element("server").attributeValue("ip");
		  String server06 = document01.getRootElement().element("server").attributeValue("version");
		  System.out.println(server01);
		  System.out.println(server02);
		  System.out.println(server03);
		  System.out.println(server04);
		  System.out.println(server05);
		  System.out.println(server06);
	}
	
  public static void test06(){
	// \u0022 是双引号的Unicode转义字符   
	  System.out.println("\u005C\u005C\u005C\u005C\u0022);
	  System.out.println("a\u0022.length()+\u0022b".length());  
  }
	
	public static void test04(){
		String str = "[{'name1':{'name2':{'name3':'value1','name4':'value2'}}}]";
	      JSONArray getJsonArray=JSONArray.fromObject(str);
	      System.out.println("getJsonArray="+getJsonArray);
	      JSONObject getJsonObj = getJsonArray.getJSONObject(0);//获取json数组中的第一项  
	      System.out.println("getJsonObj="+getJsonObj);
	      //getJsonObj.getJSONObject("name1").getJSONObject("name2").getJSONObject("name4");
	      System.out.println(getJsonObj.getJSONObject("name1").getJSONObject("name2").get("name4"));
	      
	      /**
	      SimpleDateFormat函数语法：
	      
	      G 年代标志符				y 年
	      M 月						d 日
	      h 时 在上午或下午 (1~12)    H 时 在一天中 (0~23)
	      m 分           					s 秒
	      S 毫秒 					E 星期
	      D 一年中的第几天 			F 一月中第几个星期几
	      w 一年中第几个星期 			W 一月中第几个星期
	      a 上午 / 下午 标记符  		k 时 在一天中 (1~24)
	      K 时 在上午或下午 (0~11) 	z 时区
	     */
	      Date dd = new Date();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS 一月中第F个星期E");//时:分:秒:毫秒
	      System.out.println(sdf.format(dd));
	      System.out.println("#######################");
	}
	
	public void function01(){
	  	  // JSON格式数据解析对象
	      JSONObject jo = new JSONObject();

	      // 下面构造两个map、一个list和一个Employee对象
	      Map<String, String> map1 = new HashMap<String, String>();
	      map1.put("name", "Alexia");
	      map1.put("sex", "female");
	      map1.put("age", "23");

	      Map<String, String> map2 = new HashMap<String, String>();
	      map2.put("name", "Edward");
	      map2.put("sex", "male");
	      map2.put("age", "24");

	      List<Map> list = new ArrayList<Map>();
	      list.add(map1);
	      list.add(map2);

	      // 将Map转换为JSONArray数据
	      JSONArray ja1 = JSONArray.fromObject(map1);
	      // 将List转换为JSONArray数据
	      JSONArray ja2 = JSONArray.fromObject(list);

	      System.out.println("JSONArray对象数据格式：");
	      System.out.println(ja1.toString());
	      System.out.println(ja2.toString());

	      // 构造Json数据，包括一个map和一个Employee对象
	      jo.put("map", ja1);
	      jo.put("employee", ja2);
	      System.out.println("\n最终构造的JSON数据格式：");
	      System.out.println(jo.toString());
	      System.out.println("#################");
	}
	
    public  void ParseJson(String jsonString) {

      // 以employee为例解析，map类似
      JSONObject jb = JSONObject.fromObject(jsonString);
      JSONArray ja = jb.getJSONArray("employee");

      JSONObject jsonObject = JSONObject.fromObject(ja);
      String map = jsonObject.getString("map");
      String employee = jsonObject.getString("employee");
      System.out.println("map is:" + map);
      System.out.println("employee is:" + employee);
      JSONArray jsonArray = jsonObject.getJSONArray("employee");
      for (int i = 0; i < jsonArray.size(); i++) {
      	System.out.println("item " + i + " :" + jsonArray.getString(i));
      }
      
      System.out.println("################################");
      // 循环添加Employee对象（可能有多个）
      for (int i = 0; i < ja.size(); i++) {

          System.out.println(i+ja.getJSONObject(i).getString("name"));
          System.out.println(i+ja.getJSONObject(i).getString("sex"));
          System.out.println(i+ja.getJSONObject(i).getInt("age"));

      }
  }
    
   public static void test03 () throws ClassNotFoundException, InstantiationException, IllegalAccessException{
	   Class c=Class.forName("cn.nowhelp.issurance.Car"); //要包名+类名
	   Object o=c.newInstance();
	   Person car=(Person)o;
	   Field[] fields=c.getDeclaredFields();//拿到数据成员
	   Method[] methods=c.getMethods();//拿到函数成员
	   /*System.out.println(fields.length);
	   System.out.println(methods.length);*/
	   for(Field f : fields){
	    System.out.println("该类的内部变量有:"+f.getName());
	   }
	   for(Method m : methods) {
	    System.out.println("该类的方法有:"+m.getName());
	   }
   } 
   
   public static void test05(){
		String hello = "啊";
		if(hello.length()>=1){
			System.out.println(hello.substring(0,1));
		}else{
			System.out.println(hello.substring(0, 1000));
		}
	
		
		//jsonarray转为list
       String json="[{'name':'huangbiao','age':15},{'name':'nimei','age':16}]";  
       JSONArray jsonarray = JSONArray.fromObject(json);  
       System.out.println(jsonarray);  
       List list01 = JSONArray.toList(jsonarray,Person.class);
       Iterator it = list01.iterator();  
       while(it.hasNext()){  
           Person p = (Person)it.next();  
           //System.out.println(p.getAge());  
       } 
       List list2 = JSONArray.toList(jsonarray, new Person(), new JsonConfig());
       //参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
       Person person = (Person) list2.get(0);
       System.out.println(person.getAge());
		
       
   	String str3 = "{'userid':'zhuangyang@smartdot'," +
		"'msgid':'50',"+
		"'oldmsg':[{'id':'99','timestamp':'time1'}," +
		"{'id':'100','timestamp':'time2'}]}";

	      String str2 = "{'userid':'zhuangyang@smartdot'," +
	      			   "'guid':['gid1','gid2']}";
	    	String str = "{'userid':'zhuangyang@smartdot'," +
	    	   "'msgcontent':'这是一条工作圈消息',"+
	    	   "'msgimages':['image1.jpg','image2.jpg'],"+
	    	   "'type':'3',"+
			   "'guid':['gid1','gid2']}";
	      System.out.println(str);
	      JSONObject jb = JSONObject.fromObject(str);
	      
	      
	      System.out.println(jb.get("userid").toString());
//	      JSONObject ja = jb.getJSONObject("userid");
	      
	      
	      JSONArray arr = jb.getJSONArray("guid");
	      for(int i=0;i < arr.size();i++){
	    	  
	    	  String hell = String.valueOf(arr.get(i));
	    	  
	    	  System.out.println("hell="+hell);
	    	  
	      }
	      System.out.println("############################");
	      System.out.println(str3);
	      JSONObject jb3 = JSONObject.fromObject(str3);
	      System.out.println(jb3.get("oldmsg"));
	      JSONArray arr3 = (JSONArray) jb3.get("oldmsg");
	      JSONObject jb33 =  (JSONObject) arr3.get(0);
	      System.out.println(arr3.get(0));
	      System.out.println(jb33.get("timestamp"));
	      System.out.println("############################");
	      Date dd = new Date();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时:分:秒:毫秒
	      System.out.println(sdf.format(dd));
//	      String name1 = ja.getString("name1");
//	      System.out.println("name1"+name1);
	      /*
	      JSONArray getJsonArray=JSONArray.fromObject(str);
	      System.out.println("getJsonArray="+getJsonArray);
	      JSONObject getJsonObj = getJsonArray.getJSONObject(0);//获取json数组中的第一项  
	      System.out.println("getJsonObj="+getJsonObj);
	      //getJsonObj.getJSONObject("name1").getJSONObject("name2").getJSONObject("name4");
	      System.out.println(getJsonObj.getJSONObject("name1").getJSONObject("name2").get("name4"));
		
	      Date dd = new Date();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//时:分:秒:毫秒
	      System.out.println(sdf.format(dd));
	      System.out.println("#######################");
	      
	      String data = "";
	      */
	      System.out.println("#####################");
	      List list = new ArrayList();
	      list.add( "first" );
	      list.add( "second" );
	      list.add( "third" );
	      Iterator<String> iter = list.iterator();
	      String ssttrr = "";
	      while(iter.hasNext()){  
	            ssttrr = ssttrr + iter.next().toString()+",";
	      }  
	      System.out.println("ssttrr="+ssttrr);
	      System.out.println(ssttrr.length());
	      ssttrr = ssttrr.substring(0, ssttrr.length()-1);
	      System.out.println("ssttrr="+ssttrr);
	      
	      Map<String,Object> map = new HashMap<String, Object>();
	      System.out.println(map.get("hah"));
	      
	      Date date = new Date();
			Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			f.format(date);
	      System.out.println(f.format(date));
//	      int globaltimestamp = Integer.parseInt(date);
	      
	      
	      ServerSocket server;
		try {
			server = new ServerSocket(9902);
			Socket socket = server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	      //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的  
	      
	   }

}
