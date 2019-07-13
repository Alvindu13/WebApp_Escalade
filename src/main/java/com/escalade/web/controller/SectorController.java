package com.escalade.web.controller;

import com.escalade.data.model.Sector;
import com.escalade.svc.contracts.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SectorController {



    @Autowired
    SectorService svcSector;

    /**
     * afficher les Sectors d'escalade selon le site sur lequel nous nous trouvons
     *
     * @param model
     * @return la page Sector
     */
    @RequestMapping(value = "/sector", method = RequestMethod.GET)
    public String displaySector(@RequestParam("siteId") int siteId,
                                Model model) {

        model.addAttribute("siteId", siteId);
        model.addAttribute("sectors", svcSector.listSector(siteId));
        return "sector/sector";
    }


    /**
     * Affiche le formulaire pour créer un secteur
     *
     * @return
     */
    @RequestMapping(value = "/addsector", method = RequestMethod.GET)
    public String formSector(@RequestParam("siteId") int siteId,
                             @ModelAttribute("sector") Sector sector,
                             Model model) {
        model.addAttribute("siteId", siteId);
        return "sector/addsector";
    }

    /**
     * Créer un nouveau secteur
     *
     * @param sector
     * @return
     */
    @RequestMapping(value = "/addsector", method = RequestMethod.POST)
    public ModelAndView createSector(@RequestParam("siteId") int siteId,
                                     @ModelAttribute("sector") Sector sector) {
        svcSector.createSector(sector);
        return new ModelAndView("redirect:/sector?siteId=" + siteId);
    }

}
