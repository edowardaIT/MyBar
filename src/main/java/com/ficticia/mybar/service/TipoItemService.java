package com.ficticia.mybar.service;

import com.ficticia.mybar.model.TipoItem;
import com.ficticia.mybar.repository.TipoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoItemService {

    @Autowired
    private TipoItemRepository repository;

    public List<TipoItem> listarAtivos() {
        return repository.findByAtivoTrue();
    }

    public List<TipoItem> listarTodos() {
        return repository.findAll();
    }

    public TipoItem buscarPorCodigo(Integer codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Tipo de item não encontrado: " + codigo));
    }

    public TipoItem salvar(TipoItem tipoItem) {
        if (repository.existsById(tipoItem.getCodigo())) {
            throw new RuntimeException("Já existe um tipo de item com o código: " + tipoItem.getCodigo());
        }
        return repository.save(tipoItem);
    }

    public TipoItem atualizar(Integer codigo, TipoItem dados) {
        TipoItem existente = buscarPorCodigo(codigo);
        existente.setDescricao(dados.getDescricao());
        existente.setGorjeta(dados.getGorjeta());
        existente.setVaiCozinha(dados.getVaiCozinha());
        return repository.save(existente);
    }

    public void inativar(Integer codigo) {
        TipoItem existente = buscarPorCodigo(codigo);
        existente.setAtivo(false);
        repository.save(existente);
    }
}