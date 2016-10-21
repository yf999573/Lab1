import java.util.Scanner;

//first change test
//import javax.net.ssl.SSLContextSpi;
//second change test
//checkstyle:
//'{'应该不换行，'}'应该换行
//'+''='等符号前后应有空格
//代码中的立即数应用常量存储
//'('前不应有空格
//单行if,else后加括号
//else应跟在'}'后面
//变量名不规范
public class Test2 {
	public Test2() {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String str = in.nextLine();
			char ch[] = str.toCharArray(); // 将字符串转化为字符串数组
			String[] A = str.split("\\+");
			int op = OutChar(ch);
			int flag = expression(ch, op);
			if (flag == 0) {
				System.out.println("error!");
			} else {
				substitute(ch);
				derivative(str);
			}
		}
		in.close();
	}

	public static int expression(char ch[], int op) {
		int Reflag = 1;
		switch (op) {
		case 0:
			for (char x : ch)
				System.out.print(x);
			System.out.println();
			break;
		case 1:
			Reflag = 0;
			break;
		default:
			Reflag = 0;
			break;
		}
		return Reflag;
	}

	public static int OutChar(char ch[]) {
		int flag = 0;
		int len = ch.length;
		for (int i = 0; i < len; i++) {
			int x = ch[i];
			if (flag == 0) {
				if (x >= 48 && x <= 57 || x == 42 || x == 43 || x >= 97 && x <= 122) { // 输入为数字、小写字母或+，*符号
					if (x >= 48 && x <= 57) { // 当前字符为数字时，下一位不为字母
						if (i != len - 1) {
							if (ch[i + 1] >= 97 && ch[i + 1] <= 122) {
								flag = 1;
								return 1;
							}
						}
					} else if (x >= 97 && x <= 122) {// 当前字符为字母时，下一位不为字母或数字
						if (i != len - 1) {

							if (ch[i + 1] >= 97 && ch[i + 1] <= 122 || ch[i + 1] >= 48 && ch[i + 1] <= 57) {
								flag = 1;
								return 1;
							}
						}
					} else// 当前字符为*或+时，下一位不为*或+
					{
						if (i == 0 || i == len - 1) // 运算符在首位或末位
						{
							flag = 1;
							return 1;
						} else if (ch[i + 1] == 42 || ch[i + 1] == 43) {
							flag = 1;
							return 1;
						}
					}
				} else {
					flag = 1;
					return 1;
				}
			}
		}
		return flag;
	}

	public static int substitute(char ch[]) // 赋值
	{
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		str = str + ' ';
		int j = 0;
		StringBuffer S = new StringBuffer();
		int count[] = new int[26];
		for (int i = 9; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count[j] = i;
				j++;
			}
		}

		for (int m = 0; m < j - 1; m++) {
			int cont = 0;
			for (int k = 0; k < ch.length; k++) {
				if (ch[k] == str.charAt(count[m] + 1)) {
					break;
				} else
					cont++;
			}
			if (cont == ch.length) {
				System.out.println("Error,no variable!");
				return 0;
			}
		}
		for (int k = 0; k < ch.length; k++) {
			int flag = 0;
			for (int m = 0; m < j - 1; m++) {
				if (ch[k] == str.charAt(count[m] + 1)) {
					S.append(str.substring(count[m] + 3, count[m + 1]));
					flag = 1;
					break;
				} else
					continue;
			}
			if (flag == 0) {
				S.append(ch[k]);
			}
		}
		String SS = S.toString();
		simplify(SS);
		return 0;
	}

	public static void simplify(String SS) { // 简化
	
		StringBuffer S_new = new StringBuffer();
		String[] B = SS.split("\\+");
		for (int i = 0; i < B.length; i++) {
			String C[] = B[i].split("\\*");
			int value = 1;
			boolean flag = true;
			StringBuffer SSS = new StringBuffer();
			for (int n = 0; n < C.length; n++) {
				try {
					int num = Integer.parseInt(C[n]);
					value *= num;
					flag = false;
				} catch (Exception e) {
					SSS.append("*" + C[n]);
				}
			}
			String SSS_new = SSS.toString();
			if (flag) {
				S_new.append(SSS_new.substring(1, SSS_new.length()));
			} else {
				S_new.append(value + SSS_new);
			}
			if (i < B.length - 1) {
				S_new.append("+");
			}
		}
		String SSS_three = S_new.toString();
		String[] C = SSS_three.split("\\+");
		int value2 = 0;
		StringBuffer SSSEND = new StringBuffer();
		StringBuffer SS_new = new StringBuffer();
		for (int n = 0; n < C.length; n++) {
			try {
				int num = Integer.parseInt(C[n]);
				value2 += num;
			} catch (Exception e) {
				SSSEND.append("+" + C[n]);
			}
		}
		String SSS_TWO = SSSEND.toString();
		if (value2 == 0) {

			SS_new.append(SSS_TWO.substring(1, SSS_TWO.length()));
		} else {
			SS_new.append(value2 + SSS_TWO);
		}
		String DerStr = SS_new.toString();
		System.out.println(DerStr);
	}

	public static int derivative(String DerStr) {// 求导
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String chnew;
		StringBuffer Dered = new StringBuffer();
		if (str.length() > 5)
			System.out.println("Error, no variable");
		else {
			chnew = str.substring(4, 5);
			int DerCont = 0;
			for (int n = 0; n < DerStr.length(); n++) {
				if (chnew.equals(DerStr.substring(n, n + 1)))
					break;
				else
					DerCont++;
			}
			if (DerCont == DerStr.length()) {
				System.out.println("Error,no variable!");
				return 0;
			}
			String DerStr_Cut[] = DerStr.split("\\+");
			for (int i = 0; i < DerStr_Cut.length; i++) {
				String B[] = DerStr_Cut[i].split("\\*");
				int count = 0;
				for (int j = 0; j < B.length; j++) {
					if (chnew.equals(B[j])) {
						count++;
					}
				}
				if (count != 0) {
					int flag = 0;
					for (int j = 0; j < B.length; j++) {
						if (j != B.length - 1) {
							if (chnew.equals(B[j])) {
								if (flag == 0) {
									Dered.append(count + "*");
									flag = 1;
								} else {
									Dered.append(B[j] + "*");

								}
							} else {
								Dered.append(B[j] + "*");
							}
						} else {
							if (chnew.equals(B[j])) {
								if (flag == 0) {
									Dered.append(count);
									flag = 1;
								} else {
									Dered.append(B[j]);
								}
							} else {
								Dered.append(B[j] + "*");
							}
						}
					}
					if (i < DerStr_Cut.length - 1) {
						Dered.append("+");
					}
				}
			}
			String DeredStr = Dered.toString();
			simplify(DeredStr);
		}
		return 0;
	}
}
