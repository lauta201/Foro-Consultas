package com.foro.consultas.controller;

import com.foro.consultas.model.Topicos;
import com.foro.consultas.service.ITopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicoController {

    @Autowired
    private ITopicoService topicService;

    @GetMapping("/topicos")
    public List<Topicos> listaTopicos(){
        return topicService.getTopicos();
    }

    @PostMapping("/topicos/crear")
    public String crearTopico(@RequestBody Topicos topico){
        return topicService.saveTopico(topico);
    }

    @DeleteMapping("/topicos/delete/{id}")
    public void eliminarTopico(@PathVariable Long id){
        topicService.deleteTopico(id);
    }


    @GetMapping("/topicos/{id}")
    public Topicos buscarTopico(@PathVariable Long id){
        return topicService.findTopico(id);
    }

    @PutMapping("/topicos/editar/{id}")
    public Topicos editarTopico(@PathVariable Long id, @RequestBody Topicos topico){
        return topicService.actualizarTopico(id,topico);
    }

}
