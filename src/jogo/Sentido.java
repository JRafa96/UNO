package jogo;

/**
 * 
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
