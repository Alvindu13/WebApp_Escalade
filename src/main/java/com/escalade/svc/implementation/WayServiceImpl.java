package com.escalade.svc.implementation;

import com.escalade.data.model.Way;
import com.escalade.data.repository.WayRepository;
import com.escalade.svc.contracts.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("WayService")
public class WayServiceImpl implements WayService {

    @Autowired
    private WayRepository repo;



    /**
     * Counter du total des voies
     * @param sectorId filtre
     * @return
     */
    @Override
    public Way getCountWay(int sectorId) {
        return getCountWay(sectorId);
    }

    /**
     * Page de toutes les voies
     * @param sectorId filtre
     * @param pageable
     * @return
     */
    @Override
    public Page<Way> findAllBySectorId(Integer sectorId, Pageable pageable) {
        return repo.findAllBySectorId(sectorId, pageable);
    }

    /**
     * Créer une voie
     * @param way
     */
    @Override
    public void createWay(Way way) {
        repo.save(way);
    }

}
