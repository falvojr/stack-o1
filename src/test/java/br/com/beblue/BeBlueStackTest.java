package br.com.beblue;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Classe com alguns testes unitários básicos da {@link BeBlueStack}.
 * 
 * @author falvojr
 */
public class BeBlueStackTest {

	@Test
	public void testPush() {
		final BeBlueStack beBlueStack = new BeBlueStack();
		beBlueStack.push(3);
		beBlueStack.push(5);
		beBlueStack.push(-1);
		beBlueStack.push(0);
		assertTrue("Min should return -1", beBlueStack.min() == -1);
	}

	@Test
	public void testPop() {
		final BeBlueStack beBlueStack = new BeBlueStack();
		beBlueStack.push(3);
		beBlueStack.pop();
		beBlueStack.push(5);
		beBlueStack.push(2);
		beBlueStack.push(1);
		beBlueStack.pop();
		beBlueStack.pop();
		assertTrue("Min should return 5", beBlueStack.min() == 5);
	}

	@Test
	public void testPeek() {
		final BeBlueStack beBlueStack = new BeBlueStack();
		beBlueStack.push(3);
		beBlueStack.pop();
		beBlueStack.push(5);
		beBlueStack.push(2);
		beBlueStack.push(1);
		beBlueStack.push(-1);
		beBlueStack.pop();
		beBlueStack.pop();
		assertTrue("Peek (top) should return 2", beBlueStack.peek() == 2);
	}
}
