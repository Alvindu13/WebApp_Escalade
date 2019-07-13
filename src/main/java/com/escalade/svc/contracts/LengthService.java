package com.escalade.svc.contracts;

import com.escalade.data.model.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LengthService {

    Page<Length> findAllByWayId(Integer wayId, Pageable pageable);
    void saveLength(Length length);

}
