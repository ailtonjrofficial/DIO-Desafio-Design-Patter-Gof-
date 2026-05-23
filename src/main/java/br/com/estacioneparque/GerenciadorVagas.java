package br.com.estacioneparque;

public class GerenciadorVagas {
	private int vagasDisponiveis = 50;
	private static GerenciadorVagas instancia;

	private GerenciadorVagas() {
	}

	public static GerenciadorVagas getInstancia() {
		if (instancia == null) {
			instancia = new GerenciadorVagas();
		}
		return instancia;
	}

	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}
}