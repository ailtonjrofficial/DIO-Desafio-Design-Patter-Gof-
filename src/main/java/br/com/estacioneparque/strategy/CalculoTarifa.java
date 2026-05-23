package br.com.estacioneparque.strategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface CalculoTarifa {

	BigDecimal calcular(LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida);
}
