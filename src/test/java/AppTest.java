import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest 
{
	@Test
	public void testApp()
    {
        assertEquals(0,new App().calculateSomething());
    }
	@Test
	public void testPrintHelloWorld() {

		assertEquals(App.getHelloWorld(), "Hello World");

	}

}
