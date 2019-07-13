package com.escalade.svc.implementation;


import com.escalade.data.model.Files;
import com.escalade.data.repository.FilesRepository;
import com.escalade.svc.contracts.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("filesService")
public class FilesServiceImpl implements FilesService {

    @Autowired
    FilesRepository repo;

    /**
     * Créer un fichier
     * @param f
     */
    @Override
    public void createFiles(Files f) {
        repo.save(f);
    }

    /**
     * Permet de récupérer tous les fichiers
     * @param topoId filtre
     * @return
     */
    @Override
    public Files getFilesByTopoId(int topoId) {
        return repo.getFilesByTopoId(topoId);
    }

    /**
     * Contrôle s'il existe des fichiers pour le paramètre défini
     * @param topoId filtre
     * @return
     */
    @Override
    public Boolean existsAllByTopoId(int topoId) {
        return repo.existsAllByTopoId(topoId);
    }

    /**
     * Permet d'update le fichier
     * @param data
     * @param name
     * @param topoId
     */
    @Override
    public void updateFiles(byte[] data, String name, Integer topoId) {
    }

}
