/*
�����������Ͷ����װ�ࡣ

byte	Byte
short	Short
int		Integer
long	Long
boolean Boolean
float	Float
double	Double
char	Character



�����������Ͷ����װ���������ã�
�������ڻ����������ͺ��ַ�������֮����ת��

������������ת���ַ�����

	������������+""

	������������.toString(������������ֵ);

	�磺 Integer.toString(34);//��34�������"34";


�ַ���ת�ɻ����������͡�

	xxx a = Xxx.parseXxx(String);

	int a = Integer.parseInt("123");

	double b = Double.parseDouble("12.23");

	boolean b = Boolean.parseBoolean("true");

	Integer i = new Integer("123");

	int num = i.intValue();

	


ʮ����ת���������ơ�
	toBinaryString();
	toHexString();
	toOctalString();


��������ת��ʮ���ơ�
	parseInt(string,radix);


*/
class IntegerDemo 
{
	public static void sop(String str)
	{
		System.out.println(str);
	}
	
	public static void main(String[] args) 
	{
		//�������͵����ֵ��
		//sop("int max :"+Integer.MAX_VALUE);

//		��һ���ַ���ת��������

		int num = Integer.parseInt("123");//���봫�����ָ�ʽ���ַ�����
		//long x = Long.parseLong("123");

//		sop("num="+(num+4));

//		sop(Integer.toBinaryString(-6));
//		sop(Integer.toHexString(60));

		int x = Integer.parseInt("3c",16);

		sop("x="+x);
	}


	//JDK1.5�汾�Ժ���ֵ������ԡ�
	public static void IntegerDemo1()
	{
		Integer x = 4;//�Զ�װ�䣬�൱��new Integer(4);��˵��4��ֵ

		x = x + 2;//���ڣ�x = x.intValue() + 2; x �����Զ����䡣��ɳ���int���͡���2���мӷ����㣬�ٽ��ͽ���װ�丳��x��

		Integer m = 128;
		Integer n = 128;

		sop("m==n:"+(m==n));//���Ϊfalse����Ϊm��n������byte��Χ��

		Integer a = 127;
		Integer b = 127;

		sop("a==b:"+(a==b));//���Ϊtrue����Ϊa��bָ����ͬһ��Integer����
						//��Ϊ����ֵ��byte��Χ���ݣ����������ԣ��������ֵ�Ѿ����ڣ��򲻻��ڿ����µĿռ䡣�������Ƕ���ֱ�Ӹ�ֵ���ԡ�
	}

//---------------------------------------------------------------------------------------------------------------------------------
	public static void method()
	{
		Integer x = new Integer("123");
		Integer y = new Integer(123); 

		System.out.println("x==y:"+(x==y)); // false���Ƚ϶����Ƿ���ͬ��X��Y����ָ��ͬһ����ַ��
		System.out.println("x.equals(y):"+x.equals(y)); //true���Ƚ���ֵ�Ƿ���ͬ���Զ�ת��int���͡�
	}
}