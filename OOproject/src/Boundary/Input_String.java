package Boundary;
import java.util.Scanner;

import Entity.Command;
import Entity.Polynomial;
import Control.Vali_Detem;
import Control.AssignSimply;
import Control.Order;
import Control.Derivative;

public class Input_String {

	private static String simp_str;

	public static String inputS()
	{
	    Scanner in = new Scanner(System.in);
	    String Polyno = in.nextLine();
	    return Polyno;
	}

	public static void main(String[] args){
	    Command cmd=new Command();
	    Polynomial pol=new Polynomial();
	    pol.O_Polynomial=inputS();
	    char[] ch = pol.Change(pol.O_Polynomial);
	    int op = Vali_Detem.Outchar(ch);
	    int Flag = Vali_Detem.expression(ch,op);
		if(Flag==0)
		{
			System.out.println("error!");
		}
		else
		{
			String com = Input_Order.inputO();
			int flag = Order.orderG(com);
			if(flag == 0)
			{
				System.out.println("error!");
			}
			else if (flag == 1)
			{
				String simp_str=AssignSimply.simplify(ch,com);
			}
			else if(flag ==2 )
			{
				String der_str =Derivative.derivative(simp_str, com);
			}
		}
    }
}