package com.escalade.svc.implementation;

import com.escalade.data.model.Sector;
import com.escalade.data.repository.SectorRepository;
import com.escalade.svc.contracts.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SectorService")
public class SectorServiceImpl implements SectorService {


    @Autowired
    private SectorRepository repo;

    /**
     * Permet de créer un secteur
     * @param s
     */
    public void createSector(Sector s) {repo.save(s);}

    /**
     * Permet de compter le nb total de secteurs existants
     * @param siteId
     * @return
     */
    public long getCountSector(int siteId) { return repo.getCountBySiteId(siteId); }

    /**
     * Permet de récupér une liste de tous les secteurs
     * @param siteId
     * @return
     */
    public Iterable<Sector> listSector(int siteId) {
        return repo.findAllBySiteId(siteId);
    }

}
