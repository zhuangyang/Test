

public class Test2 {
	//懒汉式单例
	private Test2(){}
	
	private static Test2 obj = null;
	
	public static Test2 getInstance(){
		if(obj == null){
			obj = new Test2();
		}
		return obj;
	}
	
	//饿汉式单例
	private static final Test2 obj2 = new Test2();
	
	public static Test2 getInstance2(){
		return obj2;
	}
}
