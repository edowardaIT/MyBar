package com.ficticia.mybar.service;

import com.ficticia.mybar.model.ItemCardapio;
import com.ficticia.mybar.model.TipoItem;
import com.ficticia.mybar.repository.ItemCardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCardapioService {

    @Autowired
    private ItemCardapioRepository repository;

    @Autowired
    private TipoItemService tipoItemService;

    public List<ItemCardapio> listarAtivos() {
        return repository.findByAtivoTrue();
    }

    public List<ItemCardapio> listarTodos() {
        return repository.findAll();
    }

    public ItemCardapio buscarPorCodigo(Integer codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Item do cardápio não encontrado: " + codigo));
    }

    public List<ItemCardapio> listarPorTipo(Integer tipoItemId) {
        return repository.findByTipoItemCodigoAndAtivoTrue(tipoItemId);
    }

    public ItemCardapio salvar(ItemCardapio item) {
        if (repository.existsById(item.getCodigo())) {
            throw new RuntimeException("Já existe um item com o código: " + item.getCodigo());
        }
        // validar se o item existe
        TipoItem tipo = tipoItemService.buscarPorCodigo(item.getTipoItem().getCodigo());
        item.setTipoItem(tipo);
        return repository.save(item);
    }

    public ItemCardapio atualizar(Integer codigo, ItemCardapio dados) {
        ItemCardapio existente = buscarPorCodigo(codigo);
        existente.setDescricao(dados.getDescricao());
        existente.setValor(dados.getValor());
        existente.setGorjeta(dados.getGorjeta());

        if (dados.getTipoItem() != null) {
            TipoItem tipo = tipoItemService.buscarPorCodigo(dados.getTipoItem().getCodigo());
            existente.setTipoItem(tipo);
        }

        return repository.save(existente);
    }

    public void inativar(Integer codigo) {
        ItemCardapio existente = buscarPorCodigo(codigo);
        existente.setAtivo(false);
        repository.save(existente);
    }
}