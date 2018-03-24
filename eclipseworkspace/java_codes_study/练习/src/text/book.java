package text;

public class book {
	float screen=100;
	float cpu;
	float mem;
	int var;
	//方法
	void call(){
		int var=40;
		int local=222;
		System.out.println("打电话"+var);
	}
	void sendMessage(){
		int local=2;
		System.out.println("发信息"+screen+','+var+local);
	}
			
	

}
