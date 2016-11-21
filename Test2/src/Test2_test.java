import static org.junit.Assert.*;

import org.junit.Test;

public class Test2_test {

	@Test
	public void testExpression() {
		String str = "x+10*y+y*y"; 
		char ch[]=str.toCharArray(); 
		Test2 test = new Test2();
		int result = Test2.expression(ch, 0);
		assertEquals(1, result);
	}

	@Test
	public void testOutChar() {
		String str = "x+10*y+y*y"; 
		char ch[]=str.toCharArray(); 
		Test2 test = new Test2();
		int result = Test2.OutChar(ch);
		assertEquals(0, result);
	}

}
