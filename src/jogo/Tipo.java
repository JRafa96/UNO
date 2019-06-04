package jogo;

public enum Tipo {
	MAIS2(0), PROIBIDO(1), INVERTERSENTIDO(2), MUDARCOR(3), MAIS4(4);

	private int nTipo;

	private Tipo(int n) {
		nTipo = n;
	}
}
