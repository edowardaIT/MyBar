package com.ficticia.mybar.controller;

import com.ficticia.mybar.model.TipoItem;
import com.ficticia.mybar.service.TipoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-item")
@CrossOrigin(origins = "*")
public class TipoItemController {

    @Autowired
    private TipoItemService service;

    @GetMapping
    public List<TipoItem> listar() {
        return service.listarAtivos();
    }

    @GetMapping("/todos")
    public List<TipoItem> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<TipoItem> buscar(@PathVariable Integer codigo) {
        return ResponseEntity.ok(service.buscarPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<TipoItem> criar(@RequestBody TipoItem tipoItem) {
        return ResponseEntity.ok(service.salvar(tipoItem));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<TipoItem> atualizar(@PathVariable Integer codigo,
                                               @RequestBody TipoItem dados) {
        return ResponseEntity.ok(service.atualizar(codigo, dados));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> inativar(@PathVariable Integer codigo) {
        service.inativar(codigo);
        return ResponseEntity.noContent().build();
    }
}