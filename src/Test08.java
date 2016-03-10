import java.net.InetAddress;


public class Test08 {
		public static void main(String[] args) throws Exception{
			byte ip[] = new byte[] { (byte) 141, (byte) 146, 8 , 66};
			InetAddress address1 = InetAddress.getByAddress(ip);
			InetAddress address2 = InetAddress.getByAddress("Oracle官方网站", ip);
			System.out.println(address1);
			System.out.println(address2);
			
			InetAddress ipAddress = InetAddress.getLocalHost();
			String ipadd = ipAddress.getHostAddress();
			System.out.println("ipAddress="+ipadd);
			 System.out.println("==============================");
			
			 try{    
                 //获得本机的InetAddress信息    
                 InetAddress IP = InetAddress.getLocalHost();    
                 showInfo(IP);    
                  
                 //从名字获得 InetAddress信息    
                 IP = InetAddress.getByName("www.sina.com.cn");    
                 showInfo(IP);    
                  
                 //从IP 地址 获得 InetAddress信息    
                 byte[] bs = new byte[]{(byte)61,(byte)172,(byte)201,(byte)194};    
                 IP = InetAddress.getByAddress(bs);    
                 showInfo(IP);    
         }    
         catch(java.net.UnknownHostException e){    
                 e.printStackTrace();    
         } 
		}
		
        //将InetAddress 中的信息显示出来    
        public static void showInfo(InetAddress IP){    
                String name = IP.getHostName();    
                String address = IP.getHostAddress();    
                System.out.println(name);    
                System.out.println(address);    
                System.out.println("------------------------------");    
        } 
}
