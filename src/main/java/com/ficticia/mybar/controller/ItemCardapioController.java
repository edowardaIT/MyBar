package com.ficticia.mybar.controller;

import com.ficticia.mybar.model.ItemCardapio;
import com.ficticia.mybar.service.ItemCardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-cardapio")
@CrossOrigin(origins = "*")
public class ItemCardapioController {

    @Autowired
    private ItemCardapioService service;

    @GetMapping
    public List<ItemCardapio> listar() {
        return service.listarAtivos();
    }

    @GetMapping("/todos")
    public List<ItemCardapio> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ItemCardapio> buscar(@PathVariable Integer codigo) {
        return ResponseEntity.ok(service.buscarPorCodigo(codigo));
    }

    @GetMapping("/por-tipo/{tipoItemId}")
    public List<ItemCardapio> listarPorTipo(@PathVariable Integer tipoItemId) {
        return service.listarPorTipo(tipoItemId);
    }

    @PostMapping
    public ResponseEntity<ItemCardapio> criar(@RequestBody ItemCardapio item) {
        return ResponseEntity.ok(service.salvar(item));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ItemCardapio> atualizar(@PathVariable Integer codigo,
                                                   @RequestBody ItemCardapio dados) {
        return ResponseEntity.ok(service.atualizar(codigo, dados));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> inativar(@PathVariable Integer codigo) {
        service.inativar(codigo);
        return ResponseEntity.noContent().build();
    }
}