

import java.io.IOException;

public class JBeesBase64 {
    
    private static final byte[] enc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes();
    private static final byte pad = (byte)'=';
    
    public JBeesBase64(){
    }
    
    /**
     * 
     * @param strInput String
     * @return String
     */
    public static String encode(String strInput) {
        if(strInput == null) {
            return null;
        }
        String temp = (new sun.misc.BASE64Encoder()).encode(strInput.getBytes());
        byte[] strB = temp.getBytes();
        int i=0;
        for(byte B : strB){
            if(B==43){
                strB[i]=0;
            }
            i++;
        }
        String s = new String(strB);
        s = s.replaceAll(new String(new byte[]{13,10}),"");
        s = s.replaceAll(new String(new byte[1]), "@`1^1@");
        s = s.replaceAll("&", "@`2^1@");
        s = s.replaceAll("#", "@`3^1@");
        s = s.replaceAll("/", "@`4^1@");
        s = s.replaceAll("=", "@`5^1@");
        return s;
    }
    
    /**
     * 
     * @param strInput String
     * @throws java.lang.Exception Excetion
     * @return String
     */
    public static String decode(String strInput) throws Exception{
    	if(strInput==null){
            return null;
        }
        byte[] strIn = strInput.getBytes();
        int si=0;
        for(byte B : strIn){
            if(B==94){
                strIn[si]=0;
            }
            si++;
        }
        String s = new String(strIn);
        s = s.replaceAll(new String(new byte[1]),"");
        s = s.replaceAll("@`11@", "+");
        s = s.replaceAll("@`21@", "&");
        s = s.replaceAll("@`31@", "#");
        s = s.replaceAll("@`41@", "/");
        s = s.replaceAll("@`51@", "=");
        byte in[] = s.getBytes();
        
        int len = in.length;
        int loop = len / 4;
        int remainder = len % 4;
        if(remainder != 0) throw new Exception();
        byte[] out;
        if(in[len - 2] == pad) out = new byte[loop * 3 - 2];
        else if(in[len - 1] == pad) out = new byte[loop * 3 -1];
        else out = new byte[loop * 3];
        
        for(int i = 0; i < loop; i++) {
            byte index0 = getIndex(in[i * 4 ]);
            byte index1 = getIndex(in[i * 4 + 1]);
            if(index0 == - 1 || index1 == -1) throw new Exception();
            out[i * 3 ] = (byte)((index0 << 2) | (index1 >> 4));
            if(in[i * 4 + 2] == pad) break;
            else{
                index0 = getIndex(in[i * 4 + 2]);
                if(index0 == -1) throw new Exception();
                out[i * 3 + 1] = (byte)((index1 << 4) | ( index0 >> 2));
            }
            
            if(in[i * 4 + 3] == pad) break;
            else {
                index1 = getIndex(in[i * 4 + 3]);
                if(index1 == -1) throw new Exception();
                out[i * 3 + 2] = (byte)((index0 << 6) | index1);
            }
        }
        
        return new String(out);
    }
    
    private static byte getIndex(byte b) {
        for(int i = 0; i < enc.length; i++)
            if(b == enc[i]) return (byte)i;
        return -1;
    }
    
    public static void main(String[] args) {
		String str ="E10ADC3949BA59ABBE56E057F20F883E";
		str ="admin";
		str = "c21hcnRkb3QmMjAwOA==";
//		String str2 = encode(str);
		String str2 = null;
		try {
			str2 = decode(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("str2= "+str2);
		/*try {
			String str3 = new String(decode(str2));
			System.out.println("str3= "+str3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
