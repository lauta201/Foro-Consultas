package com.foro.consultas.service;

import com.foro.consultas.model.Topicos;
import com.foro.consultas.repository.ITopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;

@Service
public class TopicoService implements ITopicoService {

    @Autowired
    private ITopicoRepository topicoRepo;

    @Override
    public List<Topicos> getTopicos() {
        List<Topicos> listaTopicos = topicoRepo.findAll();
        return listaTopicos;
    }

    @Override
    public String saveTopico(Topicos topico) {
        topico.setCreacion(LocalDate.now());
        topico.setStatus("Esperando repuesta");
        List<Topicos> listaDeTopicos = topicoRepo.findAll();



        for (int i = 0; i < listaDeTopicos.size(); i++) {
            if (listaDeTopicos.get(i).getMensaje().length() == topico.getMensaje().length() && listaDeTopicos.get(i).getTitulo().length() == topico.getTitulo().length()) {

                return "Esta Consulta ya existe";

            }else {
                topicoRepo.save(topico);
            }
        }
        return  "Se creo el Nuevo topico";
    }

    @Override
    public void deleteTopico(Long id) {

       topicoRepo.deleteById(id);

    }

    @Override
    public Topicos findTopico(Long id) {

        return topicoRepo.findById(id).orElse(null);
    }

    @Override
    public Topicos actualizarTopico(Long id,Topicos topi) {

       Topicos topicoEdit = this.findTopico(id);
        topicoEdit.setId(id);
        topicoEdit.setTitulo(topi.getTitulo());
        topicoEdit.setAutor(topi.getAutor());
        topicoEdit.setMensaje(topi.getMensaje());
        topicoEdit.setCurso(topi.getCurso());
        this.saveTopico(topicoEdit);
        return topicoEdit;
    }


}
