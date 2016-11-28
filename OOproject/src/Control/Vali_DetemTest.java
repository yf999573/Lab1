package Control;

import static org.junit.Assert.*;

import org.junit.Test;

public class Vali_DetemTest {

	@Test
	public void testExpression() {
		String str = "xy+(x+3)"; 
		char ch[]=str.toCharArray(); 
		Vali_Detem test = new Control.Vali_Detem();
		int result = test.expression(ch, 1);
		assertEquals(0, result);
	}

}
