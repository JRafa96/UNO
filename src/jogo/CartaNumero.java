package jogo;

/**
 * A class <code>CartaNumero</code> � constituida por um n�mero e uma cor.
 * @author Jo�o Rafael
 *
 */
public class CartaNumero extends Carta {

	private int numero;
	private Cor cor;

	/**
	 * M�todo de acesso ao n�mero da carta.
	 * @return n�mero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * M�todo de acesso � cor da carta.
	 * @return cor
	 */
	public Cor getCor() {
		return cor;
	}

	/**
	 * Contrutor da classe, recebe um n�mero e uma cor.
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
