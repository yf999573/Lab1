package Control;

public class Order {

	public static int orderG(String cmm)
	{
		
		if(cmm.substring(0,4).equals("!d/d"))
		{
			return 2;
		}
		else if(cmm.substring(0,9).equals("!simplify"))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
