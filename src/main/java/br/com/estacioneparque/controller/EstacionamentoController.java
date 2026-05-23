package br.com.estacioneparque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacioneparque.EstacionamentoFacade;
import br.com.estacioneparque.model.TipoVeiculo;

@RestController
@RequestMapping("/api/estacionamento")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoFacade facade;
	
	@PostMapping("/entrada")
	public ResponseEntity<String> registrarEntrada (@RequestParam String placa, @RequestParam TipoVeiculo tipo){
		facade.registrarEntrada(placa, tipo);
		return ResponseEntity.ok("Entrada do " + tipo + " com resgistrada com sucesso de placa: " + placa);
	}
	
	@PostMapping("/saida")
	public ResponseEntity<String> registrarSaida(@RequestParam String placa){
		facade.registrarSaida(placa);
		return ResponseEntity.ok("Saida do veículo com sucesso!");
	}
}
