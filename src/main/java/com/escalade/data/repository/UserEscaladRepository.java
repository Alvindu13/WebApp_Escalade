package com.escalade.data.repository;

import com.escalade.data.model.UserEscalad;
import org.springframework.data.repository.CrudRepository;

public interface UserEscaladRepository extends CrudRepository<UserEscalad, String> {


    UserEscalad findByUserName(String user);

    UserEscalad findByUserEscaladId(int userId);

}
