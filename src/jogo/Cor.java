package jogo;

/**
 * Enumerado das diferentes cores das cartas.
 * Cores:
 * <ul>
 * 	<li>AMARELO(0)(Cartas com a cor amarela)</li>
 * 	<li>VERMELHO(1)(Cartas com a cor amarela)</li>
 * 	<li>VERDE(2)(Cartas com a cor verde)</li>
 * 	<li>AZUL(3)(Cartas com a cor azul)</li>
 * </ul>
 * @author Bernardo
 *
 */
public enum Cor {
	AMARELO(0), VERMELHO(1), VERDE(2), AZUL(3);

	private int nCor;
	
	/**
	 * Método para receber uma String e retornar um tipo cor. 
	 * @param s
	 * @return
	 */
	public static Cor stringToCor(String s) {
		for (Cor cor : Cor.values()) {
			if (cor.name().equalsIgnoreCase(s)) {
				return cor;
			}
		}
		return null;
	}
	
	private Cor(int n) {
		nCor = n;
	}
}