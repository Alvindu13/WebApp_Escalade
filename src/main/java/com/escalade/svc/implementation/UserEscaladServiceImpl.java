package com.escalade.svc.implementation;

import com.escalade.data.model.UserEscalad;
import com.escalade.data.repository.UserEscaladRepository;
import com.escalade.svc.contracts.UserEscaladService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserEscaladService")
public class UserEscaladServiceImpl implements UserEscaladService {


    @Autowired
    private UserEscaladRepository repo;

    /**
     * Récupère tous les utilisateurs par leur pseudo
     * @param userName filtre
     * @return
     */
    @Override
    public UserEscalad getUserEscaladByUserName(String userName) {
        return repo.findByUserName(userName);
    }

    /**
     * Créer un utilisateur
     * @param userEscalad
     */
    @Override
    public void createUser(UserEscalad userEscalad) {
        repo.save(userEscalad);
    }

    /**
     * Permet de récupérer un utilisateur par son pseudo
     * @param username filtre
     * @return
     */
    @Override
    public UserEscalad getUser(String username) {
        return repo.findByUserName(username);
    }

    /**
     * Permet de trouver un utilisateur par son ID
     * @param userEscaladId
     * @return
     */
    @Override
    public UserEscalad findByUserEscaladId(int userEscaladId) {
        return repo.findByUserEscaladId(userEscaladId);
    }


}
