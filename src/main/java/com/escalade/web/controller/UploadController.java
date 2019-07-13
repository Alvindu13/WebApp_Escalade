package com.escalade.web.controller;

import com.escalade.data.model.Files;
import com.escalade.svc.contracts.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the file upload page.
 */
@Controller
public class UploadController {

    @Autowired
    private FilesService fSvc;


    /**
     * Permet d'upload un fichier
     * @param user
     * @param action
     * @param topoId
     * @param fileUpload
     * @param files
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public ModelAndView handleFileUpload(@RequestParam("user") String user,
                                         @RequestParam("action") String action,
                                         @RequestParam("topoId") Integer topoId,
                                         @RequestParam CommonsMultipartFile[] fileUpload,
                                         @ModelAttribute("files") Files files) throws Exception {

        if (action.equals("update,")) {
            if (fileUpload != null && fileUpload.length > 0) {
                for (CommonsMultipartFile aFile : fileUpload) {
                    fSvc.updateFiles(aFile.getBytes(), aFile.getOriginalFilename(), topoId);
                }
            }
        }

        else if(action.equals("upload,")){
            if (fileUpload != null && fileUpload.length > 0) {
                for (CommonsMultipartFile aFile : fileUpload){

                    files.setFileName(aFile.getOriginalFilename());
                    files.setData(aFile.getBytes());
                    fSvc.createFiles(files);

                }
            }
        }
        return new ModelAndView("redirect:/mytopo?user=" + user);
    }
}
