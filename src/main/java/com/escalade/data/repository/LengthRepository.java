package com.escalade.data.repository;

import com.escalade.data.model.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface LengthRepository extends CrudRepository<Length, Integer> {

    Page<Length> findAllByWayId(Integer wayId, Pageable pageable);
}
