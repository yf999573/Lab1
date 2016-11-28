package Entity;

public class Command {
	public String F_command;
	public String D_command;
	public char F_Var[];
	public char D_var;
	
	public String[] Cut(String ch)
	{
		String[] A = ch.split("\\*");
		return A;		
	}
	
	public int Getlen(char ch[])
	{
		int len = ch.length;
		return len;
	}
}
