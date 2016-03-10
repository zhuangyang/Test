import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.sauronsoftware.base64.Base64;

public class test04 {

	public static void main(String args[]) throws Exception{
		//YWRtaW4@`5^1@
		String username = "1";
		
		String test01 = JBeesBase64.decode("YWRtaW4@`5^1@");
		System.out.println(test01);
		String test02 = JBeesBase64.encode("admin");
		String test03 = JBeesBase64.encode("admin9");
		System.out.println("test02="+test02);
		System.out.println("test03="+test03);
		
		
		String encoded01 = Base64.encode("admin9");
//		String decoded01 = Base64.decode("YWRtaW4@`5^1@");
		System.out.println("encoded="+encoded01);
//		System.out.println("decoded="+decoded01);
		
//		JBeesBase64.decode(username);
		String encoded = Base64.encode("Hello, world!");
		String decoded = Base64.decode(encoded);
		System.out.println("encoded="+encoded);
		System.out.println("decoded="+decoded);
		
		String[] guids = { "aa","bb","cc" };
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aa", "aa");
		List<Map<String, Object>> lists = new  ArrayList<Map<String,Object>>();
		List<String> guidsList = Arrays.asList(guids); 
		if(guidsList.indexOf(map.get("aa").toString()) != -1){
			System.out.println("======");
		}
		
		System.out.println("haha="+"123456789012345678".substring(0,10));
		
		int j = 3;

		do{
			System.out.println("j is"+j++);
			if(j==2){
				continue ;
			}
		}
		while( j < 10 );
		
	}
	
}
