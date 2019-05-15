package com.game.cave.service;

import com.game.cave.model.Cave;
import com.game.cave.model.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CaveService {
    Page<Cave> findAll(Pageable pageable);

    Optional<Cave> findById(Long id);
    void save(Cave cave);
    void delete(Long id);

    Page<Cave> findAllByNameContaining(String name ,Pageable pageable);
    Page<Cave> findAllByZone(Optional<Zone> zone, Pageable pageable);
}
