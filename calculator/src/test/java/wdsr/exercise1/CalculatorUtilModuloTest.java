package wdsr.exercise1;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilModuloTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test(expected=ArithmeticException.class)
	public void testModuloByZero() {
		
		Mockito.doThrow( new ArithmeticException()).when(calculator).modulo(anyInt(),eq(0));
		
		calcUtil.getModuloText(anyInt(),eq(0));
	}

	@Test
	public void testModulo16By4() {
		
		Mockito.doReturn(0).when(calculator).modulo(16,4);
		
		assertEquals("16 % 4 = 0", calcUtil.getModuloText(16,4));
		
	}
}
