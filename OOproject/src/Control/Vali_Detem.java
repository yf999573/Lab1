package Control;

public class Vali_Detem {
	
	public static int Outchar(char ch[])
	{
		int flag=0;
		int len=ch.length;
		for(int i=0;i<len;i++)
		{
			int x = ch[i];
			if(flag==0)
			{
			    if((x>=48 && x<=57) || x==42 || x==43 || (x>=97 && x<=122)) //输入为数字、小写字母或+，*符号
			    {
			    if(x>=48 && x<=57)  //当前字符为数字时，下一位不为字母
			    {
				    if(i!=len-1)
				    {
				    if(ch[i+1]>=97 && ch[i+1]<=122)
				    {
					    flag=1;
					    return 1;
				    }
				    }
			    }
			    else if(x>=97 && x<=122) //当前字符为字母时，下一位不为字母或数字
			    {
				    if(i!=len-1)
				    {
				    if((ch[i+1]>=97 && ch[i+1]<=122) || (ch[i+1]>=48 && ch[i+1]<=57))
				    {
					    flag=1;
					    return 1;
				    }
				    }
			    }
			    else//当前字符为*或+时，下一位不为*或+
			    {
				    if(i==0 || i==len-1) //运算符在首位或末位
				    {
					    flag=1;
					    return 1;
				    }
				    else if(ch[i+1]==42 || ch[i+1]==43)
				    {
					    flag=1;
					    return 1;
				    }
			    }
			    }
			    else
			    {
				    flag=1;
				    return 1;
			    }
			}
		}
		return flag;
    }
	
	public static int expression (char ch[],int op)
	 {
		    int ReFlag=1;
	 		switch(op)
	 		{
	 		case 0:
	 			for(char x:ch)
	 				System.out.print(x);
	 			System.out.println();
	 			break;
	 		case 1:
	 			ReFlag=0;
	 			break;
	 		default:
	 			ReFlag=0;
	 			break;
	 		}
	 		return ReFlag;
	 }
}
