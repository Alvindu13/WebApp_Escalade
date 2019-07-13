package com.escalade.data.repository;

import com.escalade.data.model.Way;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface WayRepository extends CrudRepository<Way, Integer> {

    Page<Way> findAllBySectorId(Integer sectorId, Pageable pageable);
}
