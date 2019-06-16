package jogo;

public enum Cor {
	AMARELO(0), VERMELHO(1), VERDE(2), AZUL(3);

	private int nCor;
	
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