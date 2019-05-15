package com.game.cave.service.impl;

import com.game.cave.model.Cave;
import com.game.cave.model.Zone;
import com.game.cave.repository.CaveRepository;
import com.game.cave.service.CaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaveServiceImpl implements CaveService {
    @Autowired
    private CaveRepository caveRepository;

    @Override
    public Page<Cave> findAll(Pageable pageable) {
        return caveRepository.findAll(pageable);
    }

    @Override
    public Optional<Cave> findById(Long id) {
        return caveRepository.findById(id);
    }

    @Override
    public void save(Cave cave) {
        caveRepository.save(cave);
    }

    @Override
    public void delete(Long id) {
        caveRepository.deleteById(id);
    }

    @Override
    public Page<Cave> findAllByNameContaining(String name, Pageable pageable) {
        return caveRepository.findAllByNameContaining(name , pageable);
    }

    @Override
    public Page<Cave> findAllByZone(Optional<Zone> zone, Pageable pageable) {
        return caveRepository.findAllByZone(zone, pageable);
    }
}
