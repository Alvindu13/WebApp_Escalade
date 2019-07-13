package com.escalade.web.controller;

import com.escalade.data.model.Way;
import com.escalade.svc.contracts.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WayController {

    @Autowired
    private WayService svcW;

    /**
     * Affiche la page des voies
     * @param model
     * @return
     */
    @RequestMapping(value = "/way", method = RequestMethod.GET)
    public String displayTopo(@RequestParam(name = "sectorId", defaultValue = "") int sectorId,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              Model model) {


        model.addAttribute("sectorId", sectorId);
        Page<Way> pagesWay = svcW.findAllBySectorId(sectorId,PageRequest.of(page, 5));
        model.addAttribute("ways",pagesWay.getContent());
        model.addAttribute("arrayNbPagesW", new int[pagesWay.getTotalPages()]);
        model.addAttribute("currentPageW", page);
        model.addAttribute("nbPagesW", pagesWay.getTotalPages());

        return "way/way";
    }


    /**
     * Affiche le formulaire pour créer une voie
     *
     * @return
     */
    @RequestMapping(value = "/addway", method = RequestMethod.GET)
    public String formSector(@RequestParam("sectorId") int sectorId,
                             @ModelAttribute("way") Way way,
                             Model model) {
        model.addAttribute("sectorId", sectorId);
        return "way/addway";
    }

    /**
     * Créer une nouvelle voie
     *
     * @param sectorId
     * @return
     */
    @RequestMapping(value = "/addway", method = RequestMethod.POST)
    public ModelAndView createSector(@RequestParam("sectorId") int sectorId,
                                     @ModelAttribute("way") Way way) {
        svcW.createWay(way);
        return new ModelAndView("redirect:/way?sectorId=" + sectorId);
    }

}
