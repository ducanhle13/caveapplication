package com.game.cave.repository;

import com.game.cave.model.Cave;
import com.game.cave.model.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CaveRepository extends PagingAndSortingRepository<Cave,Long> {
    Page<Cave> findAllByNameContaining(String name, Pageable pageable);
    Page<Cave> findAllByZone(Optional<Zone> zone, Pageable pageable);
}
