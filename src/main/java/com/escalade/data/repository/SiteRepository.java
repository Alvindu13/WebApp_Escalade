package com.escalade.data.repository;

import com.escalade.data.model.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface SiteRepository extends CrudRepository<Site, Integer>, JpaSpecificationExecutor {



    @Query(value= "SELECT DISTINCT s.location FROM Site s")
    List<String> findDistinct();


    Page<Site> findAllByTopoId(int topo_id, Pageable pageable);


    @Query(value="SELECT s FROM Site s WHERE \n" +
            "       s.location LIKE :x OR \n" +
            "               s.name LIKE :x")
    Page<Site> findAllSiteByCritera(@Param("x") String mc, Pageable pageable);

    Site findBySiteId(int siteId);

    @Query (value ="SELECT distinct s.* " +
            "FROM Site s \n" +
            "INNER JOIN sector sec ON sec.site_id = s.site_id \n" +
                "INNER JOIN way v ON v.sector_id = sec.sector_id \n" +
            "WHERE s.location = ?1 AND (v.cotation BETWEEN ?2 AND ?3)", nativeQuery = true)
    List<Site> findSiteByMultiCriterias(String location, String cotationMini, String cotationMaxi);







}
