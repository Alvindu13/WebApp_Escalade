package com.escalade.svc.contracts;

import com.escalade.data.model.Way;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WayService {

    Way getCountWay(int sectorId);
    Page<Way> findAllBySectorId(Integer sectorId, Pageable pageable);
    void createWay(Way way);


}
