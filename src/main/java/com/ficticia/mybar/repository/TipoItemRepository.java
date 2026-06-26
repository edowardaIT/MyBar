package com.ficticia.mybar.repository;

import com.ficticia.mybar.model.TipoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TipoItemRepository extends JpaRepository<TipoItem, Integer> {
    List<TipoItem> findByAtivoTrue();
    List<TipoItem> findByDescricaoContainingIgnoreCaseAndAtivoTrue(String descricao);
}