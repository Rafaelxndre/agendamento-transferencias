package com.go2Win.agendamentotransf.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferenciaDTO {
	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valor;
	private LocalDate dataTransferencia;

	// Getters e Setters
	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
}
