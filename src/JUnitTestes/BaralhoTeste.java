package JUnitTestes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import jogo.*;

class BaralhoTeste {

	@BeforeEach
	void setUp() throws Exception {
		Baralho B1 = new Baralho();
	}

	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas")
	void Testar_total_Cartas() {
		Baralho B1 = new Baralho();
		assertEquals(108, B1.getBaralho().size());
	}

	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas de Cada Tipo")
	void Testar_total_tipo() {
		Baralho B1 = new Baralho();
		Carta instancia;
		int cartanumero = 0;
		int cartaacao = 0;
		int cartawild = 0;
		for (int i = 0; i < 108; i++) {
			instancia = B1.getBaralho().get(i);
			if (instancia instanceof CartaNumero) {
				cartanumero++;
			} else if (instancia instanceof ActionCard) {
				cartaacao++;
			} else if (instancia instanceof WildCard) {
				cartawild++;
			}
		}
		assertEquals(76, cartanumero, "total de Cartas Numero:" + cartanumero);
		assertEquals(24, cartaacao, "total de Cartas Ação:" + cartaacao);
		assertEquals(8, cartawild, "total de Wildcards" + cartawild);
	}

	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas da mesma cor")
	void Testar_total_mesma_cor() {
		Baralho B1 = new Baralho();
		Carta instancia;
		int amarelo=0;
		int vermelho=0;
		int verde=0;
		int azul=0;
		for (int i = 0; i < 108; i++) {
			instancia = B1.getBaralho().get(i);
			if (instancia instanceof CartaNumero) {
			switch (((CartaNumero) instancia).getCor()) {
			case AMARELO:
				amarelo++;
				break;
			case VERMELHO:
				vermelho++;
				break;
			case VERDE:
				verde++;
				break;
			case AZUL:
				azul++;
			}
			} else if (instancia instanceof ActionCard) {
				switch (((ActionCard) instancia).getCor()) {
				case AMARELO:
					amarelo++;
					break;
				case VERMELHO:
					vermelho++;
					break;
				case VERDE:
					verde++;
					break;
				case AZUL:
					azul++;
				}
		}
		}
		assertEquals(25, amarelo, "total de Cartas Numero:"+ amarelo);
		assertEquals(25, vermelho, "total de Cartas Ação:"+ vermelho);
		assertEquals(25, verde, "total de Cartas Numero:"+ verde);
		assertEquals(25, azul, "total de Cartas Ação:"+ azul);
	}
	@Test
	@DisplayName("╯°□°）╯ Quantas Cartas iguais")
	void Testar_total_iguais() {
		Baralho B1 = new Baralho();
		Carta instancia;
		
		for (int i = 0; i < 108; i++) {
			instancia = B1.getBaralho().get(i);
			if (instancia instanceof CartaNumero) {
			switch (((CartaNumero) instancia).getCor()) {
			case AMARELO:
				amarelo++;
				break;
			case VERMELHO:
				vermelho++;
				break;
			case VERDE:
				verde++;
				break;
			case AZUL:
				azul++;
			}
			} else if (instancia instanceof ActionCard) {
				switch (((ActionCard) instancia).getCor()) {
				case AMARELO:
					amarelo++;
					break;
				case VERMELHO:
					vermelho++;
					break;
				case VERDE:
					verde++;
					break;
				case AZUL:
					azul++;
				}
		}
		}
		assertEquals(25, amarelo, "total de Cartas Numero:"+ amarelo);
		assertEquals(25, vermelho, "total de Cartas Ação:"+ vermelho);
		assertEquals(25, verde, "total de Cartas Numero:"+ verde);
		assertEquals(25, azul, "total de Cartas Ação:"+ azul);
	}

}
