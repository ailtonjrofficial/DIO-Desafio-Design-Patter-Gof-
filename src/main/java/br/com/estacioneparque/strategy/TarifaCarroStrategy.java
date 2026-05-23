package br.com.estacioneparque.strategy;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class TarifaCarroStrategy implements CalculoTarifa {
	@Override
	public BigDecimal calcular(LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida) {
		Duration duracao = Duration.between(dataHoraEntrada, dataHoraSaida);
		long minutos = duracao.toMinutes();
		BigDecimal minutosBD = BigDecimal.valueOf(minutos);
		BigDecimal valorMinuto = new BigDecimal("0.33");
		return minutosBD.multiply(valorMinuto);
	}
}