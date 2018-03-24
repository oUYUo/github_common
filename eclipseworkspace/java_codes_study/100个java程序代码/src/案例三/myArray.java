package 案例三;
//演示一维数组和多维数组的初始化和基本操作
public class myArray {
	char[] cNum={'1','2','3','4','5','6','7','8','9','0'};
	char[] cStr={'a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p',
            'q','r','s','t','u','v','w','x','y','z'};
	int[] iMonth={31,28,31,30,31,30,31,31,30,31,30,31};
	String[] sMail ={"@","."};
	public boolean isMail(String sPara){
		for(int i=0;i<sMail.length;i++){
			if(sPara.indexOf(sMail[i])==-1)
				return false;
		}
		return true;
	}
	public boolean isNumber(String sPara){
		int iPlength = sPara.length();
		for(int i=0;i<iPlength;i++){
			char cTemp = sPara.charAt(i);
			boolean bTemp=false;
			for(int j = 0;j<cNum.length;j++){
				if(cTemp==cNum[j]){
					bTemp = true;
					break;
				}
				if(!bTemp)return false;
			}return true;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
