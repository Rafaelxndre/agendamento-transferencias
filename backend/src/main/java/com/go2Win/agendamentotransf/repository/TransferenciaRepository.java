package com.go2Win.agendamentotransf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go2Win.agendamentotransf.model.Transferencia;


@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
