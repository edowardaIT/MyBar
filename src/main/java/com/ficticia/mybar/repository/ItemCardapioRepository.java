package com.ficticia.mybar.repository;

import com.ficticia.mybar.model.ItemCardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Integer> {
    List<ItemCardapio> findByAtivoTrue();
    List<ItemCardapio> findByDescricaoContainingIgnoreCaseAndAtivoTrue(String descricao);
    List<ItemCardapio> findByTipoItemCodigoAndAtivoTrue(Integer tipoItemId);
}