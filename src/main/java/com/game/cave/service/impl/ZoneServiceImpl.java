package com.game.cave.service.impl;

import com.game.cave.model.Zone;
import com.game.cave.repository.ZoneRepository;
import com.game.cave.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Page<Zone> findAll(Pageable pageable) {
        return zoneRepository.findAll(pageable);
    }

    @Override
    public Optional<Zone> findById(Long id) {
        return zoneRepository.findById(id);
    }

    @Override
    public void save(Zone zone) {
        zoneRepository.save(zone);
    }

    @Override
    public void delete(Long id) {
        zoneRepository.deleteById(id);
    }
}
