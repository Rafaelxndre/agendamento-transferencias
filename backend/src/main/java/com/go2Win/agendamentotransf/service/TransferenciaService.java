package com.go2Win.agendamentotransf.service;

import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;

import com.go2Win.agendamentotransf.dto.TransferenciaDTO;
import com.go2Win.agendamentotransf.model.Transferencia;
import com.go2Win.agendamentotransf.repository.TransferenciaRepository;

import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferenciaService {

	private final TransferenciaRepository transferenciaRepository;

	public TransferenciaService(TransferenciaRepository transferenciaRepository) {
		this.transferenciaRepository = transferenciaRepository;
	}

	public Transferencia agendarTransferencia(TransferenciaDTO dto) {
		BigDecimal taxa = calcularTaxa(dto);
		if (taxa == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não há taxa aplicável para esta transferência.");
        }
		
		Transferencia transferencia = new Transferencia();
		transferencia.setContaOrigem(dto.getContaOrigem());
		transferencia.setContaDestino(dto.getContaDestino());
		transferencia.setValor(dto.getValor());
		transferencia.setDataTransferencia(dto.getDataTransferencia());
		transferencia.setDataAgendamento(LocalDate.now());
		transferencia.setTaxa(calcularTaxa(dto));

		return transferenciaRepository.save(transferencia);
	}

	private BigDecimal calcularTaxa(TransferenciaDTO dto) {
		long dias = ChronoUnit.DAYS.between(LocalDate.now(), dto.getDataTransferencia());
		BigDecimal valor = dto.getValor();

		if (dias == 0)
			return valor.multiply(BigDecimal.valueOf(0.025)).add(BigDecimal.valueOf(3));
		if (dias >= 1 && dias <= 10)
			return BigDecimal.valueOf(12);
		if (dias >= 11 && dias <= 20)
			return valor.multiply(BigDecimal.valueOf(0.082));
		if (dias >= 21 && dias <= 30)
			return valor.multiply(BigDecimal.valueOf(0.069));
		if (dias >= 31 && dias <= 40)
			return valor.multiply(BigDecimal.valueOf(0.047));
		if (dias >= 41 && dias <= 50)
			return valor.multiply(BigDecimal.valueOf(0.017));
		return null;
	}

	public List<Transferencia> listarTransferencias() {
		return transferenciaRepository.findAll();
	}
}
