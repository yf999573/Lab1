package Entity;

public class Polynomial {
	public String O_Polynomial;
	public char J_Polynomial[];
	public char F_Polynomial[];
	public String S_Polynomial;
	public String D_Polynomial;
	
	public  char[]  Change(String ch)
	{
		char new_ch[];
		new_ch = ch.toCharArray();
		return  new_ch;
	}
	
	public String[] Cut(String ch)
	{
		String[] A = ch.split("\\+");
		return A;		
	}
	
	public String List(StringBuffer ch,String cha)
	{
		StringBuffer str = ch.append(cha);
		String pol = str.toString();
		return pol;
	}
	
	public int getlen(char ch[])
	{
		int len = ch.length;
		return len;
	}

}
