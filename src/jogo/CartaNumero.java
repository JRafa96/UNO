package jogo;

/**
 * A class <code>CartaNumero</code> é constituida por um número e uma cor.
 * @author João Rafael
 *
 */
public class CartaNumero extends Carta {

	private int numero;
	private Cor cor;

	/**
	 * Método de acesso ao número da carta.
	 * @return número
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Método de acesso à cor da carta.
	 * @return cor
	 */
	public Cor getCor() {
		return cor;
	}

	/**
	 * Contrutor da classe, recebe um número e uma cor.
	 * @param numero
	 * @param cor
	 */
	public CartaNumero(int numero, Cor cor) {
		super();
		this.numero = numero;
		this.cor = cor;
	}

	@Override
	public String toString() {
		return numero + " "+cor.name();
	}
}
