package Control;

import static org.junit.Assert.*;

import org.junit.Test;

public class DerivativeTest {

	@Test
	public void testDerivative() {
		String TestStr = "1+3*x";
		String str = "!d/dx";
		Derivative test = new Control.Derivative();
		String result=test.derivative(TestStr,str);
		assertEquals("3",result);	
	}

}
