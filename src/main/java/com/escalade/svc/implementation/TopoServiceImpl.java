package com.escalade.svc.implementation;

import com.escalade.data.repository.TopoRepository;
import com.escalade.data.model.Topo;
import com.escalade.svc.contracts.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("topoService")
public class TopoServiceImpl implements TopoService {

    @Autowired
    private TopoRepository repo;

    /**
     * Créer un topo
     * @param t
     */
    @Override
    public void createTopo(Topo t) {
        repo.save(t);
     }

    /**
     * Permet d'obtenir un topo via son ID
     * @param topoId
     * @return
     */
    @Override
    public Topo getTopoById(int topoId) {
        return repo.findByTopoId(topoId);
    }

    /**
     * Récupère tous les topos
     * @return une liste
     */
    @Override
    public Iterable<Topo> getAllTopo() {
        return repo.findAll();
    }

    /**
     * Récupère tous les topos
     * @param pageable
     * @return une page
     */
    @Override
    public Page<Topo> getAllTopo(Pageable pageable) {

        return repo.findAll(pageable);
    }

    /**
     * Récupère tous les topos selon le paramètre
     * @param userEscalad filtre
     * @param pageable
     * @return une page
     */
    @Override
    public Page<Topo> getAllByUserEscaladName(String userEscalad, Pageable pageable) {
        return repo.findAllByUserEscaladName(userEscalad, pageable);
    }

    /**
     * Permet d'update le topo selon l'action choisi par l'utilisateur
     * @param action partager ou libérer un topo
     * @param reserve un topo
     * @param user utilisateur courrant
     * @param topoId Id du topo sélectionné
     */
    @Override
    public void updateTopo(String action, Boolean reserve, String user, int topoId) {

        final Integer emptyUser = 0;

        if(action.equals(",partager"))
        {
            System.out.println(topoId);
        }
        else if(action.equals(",liberer")){
            repo.setTopoReserveUserIdByTopoId(false, topoId);
            repo.setTopoUserNameByUserEscaladId(emptyUser, topoId);
        }
        repo.setTopoUnvailableById(true, topoId);


    }

    /**
     * Récupère tous les topos selon l'utilisateur courrant
     * @param currentUserEscalad filtre
     * @param pageable
     * @return une page
     */
    @Override
    public Page<Topo> getAllByCurrentlyUserEscalad(Integer currentUserEscalad, Pageable pageable) {
        return repo.findAllByUserEscaladCurrentProprio(currentUserEscalad, pageable);
    }

    /**
     * Récupère tous les topos selon la disponibilité
     * @param available filtre
     * @param pageable
     * @return une page
     */
    @Override
    public Page<Topo> getAllByAvailableIsTrue(Boolean available, Pageable pageable) {
        return repo.getAllByAvailableIsTrue(available, pageable);
    }

    /**
     * Update un topo
     * @param userEscaladId clause WHERE
     * @param topoId
     */
    @Override
    public void setTopoUserNameByUserEscaladId(Integer userEscaladId, Integer topoId) {
        repo.setTopoUserNameByUserEscaladId(userEscaladId, topoId);

    }

    /**
     * Update un topo
     * @param unvailable clause WHERE
     * @param topoId
     */
    @Override
    public void setTopoUnvailableById(Boolean unvailable, Integer topoId) {
        repo.setTopoUnvailableById(unvailable, topoId);

    }

    /**
     * Update un topo
     * @param reserve clause WHERE
     * @param topoId
     */
    @Override
    public void setTopoReserveUserEscaladIdByTopoId(Boolean reserve, Integer topoId) {
        repo.setTopoReserveUserIdByTopoId(reserve,topoId);

    }

}

