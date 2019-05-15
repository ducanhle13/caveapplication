package com.game.cave.service;

import com.game.cave.model.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ZoneService {
    Page<Zone> findAll(Pageable pageable);

    Optional<Zone> findById(Long id);
    void save(Zone zone);
    void delete(Long id);
}
