package JUnitTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jogo.*;

class JogadorTeste {

	@BeforeEach
	void setUp() throws Exception {
		Baralho B1 = new Baralho();         
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	//VERIFICA SE AS JOGAVEIS ESTAO VAZIAS NO INICIO
	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas na Jogaveis")
	void jogaveis_vazia_inicio() {
		Jogador J1 = new Jogador();
		
		assertEquals(0,J1.getJogaveis().size());
	}
	
	//VERIFICA SE O JOGADOR TEM 7 CARTAS NO INCIO
	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas no Inicio")
	void sete_cartas_no_inicio() {
		Jogador J1 = new Jogador();
		
		assertEquals(7,J1.getMao().size());
	}
	
	//NAO JOGAR MAIS DO QUE UMA CARTA
	@Test 
	@DisplayName("╯°□°）╯ Jogar Uma Carta")
	void jogar_mais_de_uma_carta(Estado estado) {
		Jogador J1 = new Jogador();
		
		assertEquals(1,J1.jogarCarta(estado));
	}

}
