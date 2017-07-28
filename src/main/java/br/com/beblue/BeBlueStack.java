package br.com.beblue;

import java.util.Stack;

/**
 * Como você implementaria uma classe de pilha de inteiros que possui os métodos push, pop e min. Onde min retorna o
 * menor inteiro na pilha e todos os métodos são O(1).
 * 
 * @author falvojr
 */
public class BeBlueStack {

	private static final String MSG_EMPTY_STACK = "Empty stack!";

	private Stack<Integer> stack;
	private Integer min;

	public BeBlueStack() {
		this.stack = new Stack<Integer>();
	}

	public void push(Integer newItem) {
		Integer topItem = newItem;
		if (this.stack.isEmpty()) {
			this.min = newItem;
		} else if (newItem < this.min) {
			// Se o novo item (push) for menor que o mínimo, o mínimo deve ser atualizado.
			// Antes isso, executamos uma equacão para o cálculo do valor de referência,
			// que viabilizará as operacões em O(1).
			topItem = this.evalMin(newItem, this.min);
			this.min = newItem;
		}
		this.stack.push(topItem);
	}

	public void pop() {
		if (this.stack.isEmpty()) {
			throw new RuntimeException(MSG_EMPTY_STACK);
		}
		final Integer topItem = this.stack.pop();
		if (topItem < this.min) {
			// Se o valor do pop (topo) for menor que o mínimo, então ele é o próprio mínimo (vide método evalMin).
			// Com isso, usamos novamente a equacão para calcular o novo minimo (já que o atual foi removido).
			this.min = this.evalMin(this.min, topItem);
		}
	}

	public Integer min() {
		if (this.stack.isEmpty()) {
			throw new RuntimeException(MSG_EMPTY_STACK);
		}
		return this.min;
	}

	public Integer peek() {
		if (this.stack.isEmpty()) {
			throw new RuntimeException(MSG_EMPTY_STACK);
		}
		// Caso o item do pop (topo) for menor que o mínimo, então ele é o próprio mínimo. Senão o item é 
		// retornado normalmente.
		final Integer topItem = this.stack.peek();
		return topItem < this.min ? this.min : topItem;
	}

	/**
	 * Equacao generica para manipular a inclusão de elementos minimos na pilha. Essencial para para que o algoritmo
	 * seja O(1).
	 */
	private int evalMin(Integer x, Integer min) {
		return 2 * x - min;
	}
}