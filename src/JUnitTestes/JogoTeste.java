package JUnitTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jogo.*;

class JogoTeste {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("╯°□°）╯ ||____|| jogador foi buscar cartas dps de +2 ou +4?")
	void test() {
		Baralho b1=new Baralho();
		Jogo j1=new Jogo();
		Jogador pl1 = new Jogador("bot sadam");
		Jogador pl2 = new Jogador("hallauh AKBAR");
		j1.getJogadores().add(pl1);
		j1.getJogadores().add(pl2);
		Carta carta = new WildCard(Tipo.values()[3]);
		j1.setBaralho(b1);
		
		
		
		fail("Not yet implemented");
	}
	

}
