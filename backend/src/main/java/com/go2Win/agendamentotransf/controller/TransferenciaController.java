package com.go2Win.agendamentotransf.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.go2Win.agendamentotransf.dto.TransferenciaDTO;
import com.go2Win.agendamentotransf.model.Transferencia;
import com.go2Win.agendamentotransf.service.TransferenciaService;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	private final TransferenciaService transferenciaService;

	public TransferenciaController(TransferenciaService transferenciaService) {
		this.transferenciaService = transferenciaService;
	}

	@PostMapping
	public ResponseEntity<Transferencia> agendarTransferencia(@RequestBody TransferenciaDTO dto) {
		Transferencia transferencia = transferenciaService.agendarTransferencia(dto);
		return ResponseEntity.ok(transferencia);
	}

	@GetMapping
	public ResponseEntity<List<Transferencia>> listarTransferencias() {
		return ResponseEntity.ok(transferenciaService.listarTransferencias());
	}
}
