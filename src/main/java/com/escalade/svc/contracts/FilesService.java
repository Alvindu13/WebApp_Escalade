package com.escalade.svc.contracts;

import com.escalade.data.model.Files;

public interface FilesService {

    void createFiles(Files f);
    Files getFilesByTopoId(int fileId);
    Boolean existsAllByTopoId(int topoId);
    void updateFiles(byte[] data, String name, Integer topoId);
}
