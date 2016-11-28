package Control;
import java.util.Scanner;

public class AssignSimply {
	
	public static String simplify(char ch[],String str) //赋值
	{
		str=str+' ';
		int j = 0;
		StringBuffer S=new StringBuffer();
		int count[] = new int[26];
		for(int i= 9;i<str.length();i++)
		{
			if(str.charAt(i) == ' ')
			{
				count[j]=i;
				j++;
			}
		}
		
		for(int m=0;m<j-1;m++)
		{
			int cont=0;
			for(int k=0;k<ch.length;k++)
			{
				if(ch[k]==str.charAt(count[m]+1))
				{
				   break;
				}  
				else
					cont++;
			}
			if(cont==ch.length)
			{ 
				String SS="Error,no variable!";
				return SS;
			}						  
		}
		for(int k=0;k<ch.length;k++)
		{
			int flag=0;
			for(int m=0;m<j-1;m++)
			{
				if(ch[k]==str.charAt(count[m]+1))
				{
				   S.append(str.substring(count[m]+3,count[m+1]));
				   flag = 1;
				   break;
				}  
				else
					continue;
			}
			if(flag==0)
			{ 
				S.append(ch[k]);
			}						  
		}
		String SS = S.toString();
		substitute(SS);
		return SS;
	}
	
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
}
