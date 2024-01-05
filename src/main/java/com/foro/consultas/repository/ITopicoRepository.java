package com.foro.consultas.repository;

import com.foro.consultas.model.Topicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicoRepository extends JpaRepository<Topicos,Long> {
}
