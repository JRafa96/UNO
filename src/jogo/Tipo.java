package jogo;

/**
 * Enumerado com os tipos de cartas existentes.
 * Tipos: 
 * 	<ul>
 * 		  <li>MAIS_2(Cartas que fazem o jogador seguinte ir buscar 2 cartas ao baralho);</li>
 * 		  <li>PROIBIDO(Cartas que proibem o jogador seguinte);</li>
 * 		  <li>INVERTER_SENTIDO(Cartas que permitem inverter o sentido atual do jogo);</li>
 * 		  <li> MUDAR_COR(Cartas que permitem mudar a cor atual do jogo);</li>
 * 		  <li>MAIS_4(Cartas que permitem ao jogador atual mudar a cor atual do jogo e fazem o jogador seguinte ir buscar 4 cartas ao baralho);</li>	
 * 	</ul>
 * @author Bernardo
 *
 */
public enum Tipo {
	MAIS_2(0), PROIBIDO(1), INVERTER_SENTIDO(2), MUDAR_COR(3), MAIS_4(4),COR(5);

	private int nTipo;

	private Tipo(int n) {
		nTipo = n;
	}
}
