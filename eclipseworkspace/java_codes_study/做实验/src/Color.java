
public class Color {
	private String name;
	private static final Color RED = new Color("��ɫ");
	private static final Color GREEN = new Color("��ɫ");
	private static final Color BLUE = new Color("��ɫ");
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.setName(name);
	}
	public Color(String name){
		this.setName(name);
	}
	public static Color getInstance(int i){
		if(i==0){
			return RED;
		}
		if(i==1){
			return GREEN;
		}
		if(i==2){
			return BLUE;
		}
		return null;
	}

}
