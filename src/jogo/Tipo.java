package jogo;

/**
 * Enumerado com os tipos de cartas existentes.
 * @author Bernardo
 *
 */
public enum Tipo {
	MAIS_2(0), PROIBIDO(1), INVERTER_SENTIDO(2), MUDAR_COR(3), MAIS_4(4);

	private int nTipo;

	private Tipo(int n) {
		nTipo = n;
	}
}
