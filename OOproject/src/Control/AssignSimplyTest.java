package Control;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssignSimplyTest {

	@Test
	public void testSimplify() {
		String TestStr = "x+y*3";
		String str = "!simplify x=3 y=25";
		char ch1[]=TestStr.toCharArray();
		AssignSimply test = new Control.AssignSimply();
		String result=test.simplify(ch1,str);
		assertEquals("3+25*3",result);	
	}
}
