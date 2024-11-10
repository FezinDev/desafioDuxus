package br.com.duxusdesafio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.duxusdesafio.model.Time;

public interface TimeRepositorio extends JpaRepository<Time, Long> {
    List<Time> findAll();
}
