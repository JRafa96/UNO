package jogo;

public class MudaCor extends Exception{

private Cor cor;
	
	public Cor getCor() {
		return cor;
	}
	
	public MudaCor(Cor cor) {
		super("Muda de cor");
		this.cor = cor;
	}

}
