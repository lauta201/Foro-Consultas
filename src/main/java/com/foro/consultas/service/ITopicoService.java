package com.foro.consultas.service;

import com.foro.consultas.model.Topicos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITopicoService {
    public List<Topicos> getTopicos();
    public String saveTopico(Topicos topico);

    public void deleteTopico(Long id);
    public Topicos findTopico(Long id);
    public Topicos actualizarTopico(Long id,Topicos topi);
}
