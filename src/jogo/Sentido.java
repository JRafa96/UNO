package jogo;

/**
 * Enumerado com os sentidos existentes.
 * Sentidos:
 * <ul>
 * 	<li>ESQUERDA(Jogo em sentido contra-relógio)</li>
 * 	<li>DIREITA(Jogo em sentido dos ponteiros do relógio)</li>
 * </ul>
 * @author Bernardo
 *
 */
public enum Sentido {
	ESQUERDA(-1), DIREITA(1);

	private int nSentido;

	private Sentido(int n) {
		nSentido = n;
	}
}
