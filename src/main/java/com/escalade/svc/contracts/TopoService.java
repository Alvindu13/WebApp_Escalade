package com.escalade.svc.contracts;

import com.escalade.data.model.Topo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopoService {

    void createTopo(Topo t);
    Topo getTopoById(int topo_id);
    Iterable<Topo> getAllTopo();
    Page<Topo> getAllTopo(Pageable pageable);
    Page<Topo> getAllByUserEscaladName(String userEscalad, Pageable pageable);
    void updateTopo(String action,Boolean reserve, String userEscalad, int topoId);
    Page<Topo> getAllByCurrentlyUserEscalad(Integer currentUserEscalad, Pageable pageable);
    Page<Topo> getAllByAvailableIsTrue(Boolean available, Pageable pageable);
    void setTopoUserNameByUserEscaladId(Integer userEscaladId, Integer topoId);
    void setTopoUnvailableById(Boolean unvailable, Integer topoId);
    void setTopoReserveUserEscaladIdByTopoId(Boolean reserve, Integer topoId);

}
