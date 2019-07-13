package com.escalade.data.repository;

import com.escalade.data.model.Files;
import org.springframework.data.repository.CrudRepository;

public interface FilesRepository extends CrudRepository<Files, Integer > {


    Boolean existsAllByTopoId(int topoId);

    Files getFilesByTopoId(int topoId);
}
