package Control;
import java.util.Scanner;

public class Derivative {
	
	public static String substitute(String SS) //简化
	{
		StringBuffer S_new=new StringBuffer();
		String[] B=SS.split("\\+");
		for(int i=0;i<B.length;i++)
		{
			String C[] = B[i].split("\\*");
			int value =1;
			StringBuffer SSS = new StringBuffer();
			for(int n=0;n<C.length;n++)
			{
				try
				{
					int num=Integer.parseInt(C[n]);
				    value *= num;
				}catch(Exception e)
				{
					SSS.append("*"+C[n]);
				}
			}
			String SSS_new=SSS.toString();
			if(value==1) 
			{
				if(SSS_new.length()==0)
					S_new.append(value);
				else if (SSS_new.length()>1)
				    S_new.append(SSS_new.substring(1, SSS_new.length()));
			}
			else 
			{
				S_new.append(value+SSS_new);
			}
		    if(i<B.length-1)
		    {
		    	 S_new.append("+");
		    }
         }
		String SSS_three=S_new.toString();
		String[] C=SSS_three.split("\\+");
		int value2 = 0;
		StringBuffer SSSEND = new StringBuffer();
		StringBuffer SS_new=new StringBuffer();
		for(int n=0;n<C.length;n++)
		{
			try
			{
				int num=Integer.parseInt(C[n]);
				value2 += num;
			}catch(Exception e)
			{
           	   SSSEND.append("+"+C[n]);
			}
		}
		String SSS_TWO=SSSEND.toString();
		if(value2==0) 
		{
			
			SS_new.append(SSS_TWO.substring(1,SSS_TWO.length()));
		}
		else 
		{
			SS_new.append(value2+SSS_TWO);
		}
		String DerStr=SS_new.toString();;
		return DerStr;
     }
    
	public static String derivative(String DerStr,String str) //求导
	{
		String chnew;
		StringBuffer Dered = new StringBuffer();
		if(str.length()>5)
			return "Error, no variable";
		else
		{
			chnew = str.substring(4,5);
			int DerCont=0;
			for(int n=0;n<DerStr.length();n++)
			{
				if(chnew.equals(DerStr.substring(n,n+1)))
					break;
				else
					DerCont++;
			}
			if(DerCont==DerStr.length())
			{
				return "Error,no variable!";
			}
		    String DerStr_Cut[] = DerStr.split("\\+");
			for(int i=0;i<DerStr_Cut.length;i++)
			{
				String B[] = DerStr_Cut[i].split("\\*");
				int count=0;
				for(int j=0;j<B.length;j++)
				{
					if(chnew.equals(B[j])==true)
					{
						count++;
					}
				}
				if(count!=0)
				{
					int flag = 0;
					for(int j=0;j<B.length;j++)
					{
						if(j!=B.length-1)
						{
						    if(chnew.equals(B[j])==true)
						    {
							    if(flag == 0)
							    {
									Dered.append(count+"*");
									flag=1;
							    }
						        else
						        {
							        Dered.append(B[j]+"*");
							        
						        }
						   }
						   else
						   {
							   Dered.append(B[j]+"*");
						   }
						}
						else
						{
							if(chnew.equals(B[j])==true)
							{
								if(flag == 0)
								{
									Dered.append(count);
									flag=1;
								}
							    else
							    {
								    Dered.append(B[j]);
							    }
						   }
						   else
						   {
								Dered.append(B[j]+"*");
						   }
						}
					}
					if(i<DerStr_Cut.length-1)
					{
					    Dered.append("+"); 
					}
				}
			}
		String DeredStr = Dered.toString();
		String der = substitute(DeredStr);
		return der;
		}
	}
}
