package com.vitor.cdc.demo.autor.controller;

import com.vitor.cdc.demo.autor.model.Autor;
import com.vitor.cdc.demo.autor.model.AutorRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController()
@RequestMapping("/autores")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(consumes = {"application/json"},produces = {"application/json"})
    @Transactional
    public ResponseEntity<Autor> cadastrar(@RequestBody @Validated AutorRequest autorRequest){

        Autor autor = autorRequest.paraModel();

        manager.persist(autor);
        System.out.println(autor);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

}
