package br.com.estacioneparque;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.estacioneparque.model.Ticket;
import br.com.estacioneparque.model.TipoVeiculo;
import br.com.estacioneparque.model.Veiculo;
import br.com.estacioneparque.strategy.CalculoTarifa;
import br.com.estacioneparque.strategy.TarifaCarroStrategy;
import br.com.estacioneparque.strategy.TarifaMotoStrategy;

@Service
public class EstacionamentoFacade {
	private List<Ticket> ticketsAtivos = new ArrayList<>();

	public void registrarEntrada(String placa, TipoVeiculo tipo) {
		GerenciadorVagas gerenciador = GerenciadorVagas.getInstancia();
		Veiculo veiculo = new Veiculo(placa, tipo);
		Ticket ticket = new Ticket();
		ticket.setVeiculo(veiculo);
		ticket.setDataHoraEntrada(LocalDateTime.now());
		ticketsAtivos.add(ticket);
		gerenciador.setVagasDisponiveis(gerenciador.getVagasDisponiveis() - 1);
	}

	public void registrarSaida(String placa) {
		GerenciadorVagas gerenciador = GerenciadorVagas.getInstancia();
		Ticket ticketEncontrado = null;
		
		for(Ticket t : ticketsAtivos) {
			if(t.getVeiculo().getPlaca().equals(placa)) {
				ticketEncontrado = t;
				break;
			}
		}
		
		if(ticketEncontrado != null) {
			ticketEncontrado.setDataHoraSaida(LocalDateTime.now());
			
			CalculoTarifa strategy;
			
			if(ticketEncontrado.getVeiculo().getTipo() == TipoVeiculo.CARRO) {
				strategy = new TarifaCarroStrategy();
			} else {
				strategy = new TarifaMotoStrategy();
			}
			
			BigDecimal valorFinal = strategy.calcular(ticketEncontrado.getDataHoraEntrada(), ticketEncontrado.getDataHoraSaida());
				ticketEncontrado.setValor(valorFinal);
			
			ticketsAtivos.remove(ticketEncontrado);
			gerenciador.setVagasDisponiveis(gerenciador.getVagasDisponiveis() + 1);
			
			System.out.println("Veículo de placa " + placa + " saiu. Valor cobrado: R$ " + valorFinal);
		} else {
			System.out.println("Ticket não encontrado para a placa: " + placa);
		}
	}
}
