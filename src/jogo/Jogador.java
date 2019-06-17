package jogo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A classe <code> Jogador </code> serve para representar quais s�o os jogadores que
 * est�o a jogar e 
 * 
 * @author quinz
 *
 */
public class Jogador {
	private String nome;
	private ArrayList<Carta> mao = new ArrayList<Carta>();
	private ArrayList<Carta> jogaveis = new ArrayList<Carta>();
	private boolean proibido;

	public boolean isProibido() {
		return proibido;
	}

	public void setProibido(boolean proibido) {
		this.proibido = proibido;
	}

	/**
	 * M�todo de acesso (leitura) do nome do Jogador
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	
/**
 * M�todo de acesso (leitura) do registo das cartas m�o
 * @return
 */
	public ArrayList<Carta> getMao() {
		return mao;
	}
/**
 * M�todo de acesso (leitura) do registo das cartas jogaveis
 * @return
 */
	public ArrayList<Carta> getJogaveis() {
		return jogaveis;
	}

	/**
	 * Constr�i um objeto da classe <code> Jogador </code>
	 */
	public Jogador() {
	}

	/**
	 * 	 
	 * Constr�i um objeto da classe <code> Jogador </code>
	 * @param nome Identificador do Jogador
	 */
	public Jogador(String nome) {
		this.nome = nome;

	}


	private String getJogaveisString() {
		return jogaveis.toString();
	}

	public Carta jogarCarta(Estado estado) {
		verificarJogaveis(estado);
		System.out.println(getJogaveisString());
		System.out.println("Que carta quer jogar?");
		Scanner LerS = new Scanner(System.in);
		int n = LerS.nextInt();
		Carta carta = jogaveis.get(n);
		jogaveis.remove(n);
		mao.addAll(jogaveis);
		jogaveis.clear();
		return carta;
	}

	public void receberCarta(Carta carta) {
		mao.add(carta);
	}

	public void receberCartas(ArrayList<Carta> cartas) {
		mao.addAll(cartas);
	}
	
/**
 * M�todo que verifica se a m�o est� vazia
 * 
 * @return
 */
	public boolean isVazia() {
		if (mao.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * M�todo que move as cartas que est�o na m�o para o arraylist das jogaveis
	 * 
	 * @param pos Valor que indica qual � a posi��o que a carta est� na m�o
	 */
	private void moverJogaveis(int pos) {
		jogaveis.add(mao.get(pos));
		mao.remove(pos);
	}
	
	/**
	 * M�todo que verifica se as cartas da m�o s�o jogevis, caso forem, move
	 * a carta da m�o para o arraylist das jogaveis
	 * 
	 * @param estado Devolve a o estado atual da carta que est� no jogo
	 */
	public void verificarJogaveis(Estado estado) {
		mao.addAll(jogaveis);
		jogaveis.clear();
		for (int j = 0; j < mao.size(); j++) {
			if (mao.get(j) instanceof ActionCard) {
				if (estado.cartaAtual instanceof ActionCard) {
					if (((ActionCard) mao.get(j)).getCor() == ((ActionCard) estado.cartaAtual).getCor()) {
						moverJogaveis(j);
						j--;
					} else if (((ActionCard) mao.get(j)).getTipo() == ((ActionCard) estado.cartaAtual).getTipo()) {
						moverJogaveis(j);
						j--;
					}
				} else if (estado.cartaAtual instanceof CartaNumero) {
					if (((ActionCard) mao.get(j)).getCor().ordinal() == ((CartaNumero) estado.cartaAtual).getCor().ordinal()) {
						moverJogaveis(j);
						j--;
					}
				}

			} else if (mao.get(j) instanceof CartaNumero) {
				if (estado.cartaAtual instanceof CartaNumero) {
					if (((CartaNumero) mao.get(j)).getCor().ordinal() == ((CartaNumero) estado.cartaAtual).getCor().ordinal()) {
						moverJogaveis(j);
						j--;
					} else if (((CartaNumero) mao.get(j)).getNumero() == ((CartaNumero) estado.cartaAtual)
							.getNumero()) {
						moverJogaveis(j);
						j--;
					}
				} else if (estado.cartaAtual instanceof ActionCard) {
					if (((CartaNumero) mao.get(j)).getCor().ordinal() == ((ActionCard) estado.cartaAtual).getCor().ordinal()) {
						moverJogaveis(j);
						j--;
					}
				}

			} else if (mao.get(j) instanceof WildCard) { // instanceof verifica se � uma classe daquele tipo
				moverJogaveis(j);
				j--;
			}
		}
	}

	@Override
	public String toString() {
		String separador = "\n+----------------------------------------------+\n";
		return separador + "Jogador: +" + nome + "\n Cartas na m�o: " + mao + "\n Cartas jog�veis: " + jogaveis;
	}
}
