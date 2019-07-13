package com.escalade.data.repository;

import com.escalade.data.model.Sector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SectorRepository extends CrudRepository<Sector, Integer> {


    @Query(value= "select * from sector  where site_id = ?1", nativeQuery = true)
    List<Sector> findAllBySiteId(int site_id);

    @Query(value= "select COUNT(*) from sector  where site_id = ?1", nativeQuery = true)
    long getCountBySiteId(int site_id);


}
