package com.escalade.svc.implementation;

import com.escalade.data.model.Length;
import com.escalade.data.repository.LengthRepository;
import com.escalade.svc.contracts.LengthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("LengthService")
public class LengthServiceImpl implements LengthService {

    @Autowired
    LengthRepository repo;


    @Override
    public Page<Length> findAllByWayId(Integer wayId, Pageable pageable) {
        return repo.findAllByWayId(wayId, pageable);
    }

    @Override
    public void saveLength(Length length) {
        repo.save(length);
    }

}
