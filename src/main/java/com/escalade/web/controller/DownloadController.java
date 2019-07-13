package com.escalade.web.controller;

import com.escalade.data.model.Files;
import com.escalade.svc.contracts.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class DownloadController {


    @Autowired
    private FilesService fSvc;

    /**
     * Permet de télécharger un fichier depuis la base de données
     * @return
     * @throws IOException
     */
    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam("topoId") int topoId) throws IOException {
        Files files = fSvc.getFilesByTopoId(topoId);
        byte[] data = files.getData();
        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF).contentLength(data.length)
                .body(resource);
    }

}
