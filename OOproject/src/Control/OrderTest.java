package Control;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testOrderG() {
		String str = "!simplify x=1";
		Order test = new Control.Order();
		int result=test.orderG(str);
		assertEquals(1,result);	
	}

}
