package com.escalade.svc.implementation;

import com.escalade.data.model.*;

import com.escalade.data.repository.SiteRepository;
import com.escalade.svc.contracts.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service("siteService")
public class SiteServiceImpl implements SiteService {


    @Autowired
    private SiteRepository repo;

    /**
     * Permet de créer un site de grimpe
     * @param s
     */
    @Override
    public void createSite(Site s) {
        Site site = repo.save(s);
    }

    /**
     * Permet de trouver tous les sites qui sont filtrés en fonction du premier paramètre
     * @param topoId
     * @param pageable
     * @return
     */
    @Override
    public Page<Site> getAllByTopoId(int topoId, Pageable pageable) {
        return repo.findAllByTopoId(topoId, pageable);
    }

    /**
     * Permet de récupérer un site grâce à son ID
     * @param siteId
     * @return
     */
    @Override
    public Site getSiteBySiteId(int siteId){
        return repo.findBySiteId(siteId);
    }


    /**
     * Permet de trouver un site grâce à des critères de resereach
     * @param location
     * @param cotationMin
     * @param cotationMax
     * @return
     */
    @Override
    public List<Site> getAllSiteByResearch(String location, String cotationMin, String cotationMax) {
        return repo.findSiteByMultiCriterias(location, cotationMin, cotationMax);
    }

    /**
     * Réucpère une liste de toutes les locations qui existent dans la db
     * @return
     */
    @Override
    public Iterable<String> getDisctinctLocation() {
        return repo.findDistinct();
    }

    /**
     * Récupèree tous les sites qui correspond au mc
     * @param mc filtre
     * @param pageable
     * @return
     */
    @Override
    public Page<Site> getAllSiteByCritera(String mc, Pageable pageable) {
        return repo.findAllSiteByCritera(mc, pageable);
    }


}
