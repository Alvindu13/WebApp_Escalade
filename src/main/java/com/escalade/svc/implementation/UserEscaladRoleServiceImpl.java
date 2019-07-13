package com.escalade.svc.implementation;

import com.escalade.data.model.UserEscaladRole;
import com.escalade.data.repository.UserEscaladRoleRepository;
import com.escalade.svc.contracts.UserEscaladRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userEscaladRoleService")
public class UserEscaladRoleServiceImpl implements UserEscaladRoleService {

    @Autowired
    private UserEscaladRoleRepository repo;

    /**
     * Créer un rôle pour l'utilisateur qui s'enregistre
     * @param userEscaladRole
     * @return
     */
    @Override
    public UserEscaladRole saveRoleUser(UserEscaladRole userEscaladRole) {
        return repo.save(userEscaladRole);
    }
}
