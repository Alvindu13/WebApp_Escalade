package com.escalade.web.controller;

import com.escalade.data.model.Length;
import com.escalade.svc.contracts.LengthService;
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
public class LengthController {

    @Autowired
    LengthService lengthSvc;


    /**
     * Affiche la page des topos
     * @param model
     * @return
     */
    @RequestMapping(value = "/length", method = RequestMethod.GET)
    public String displayTopo(@RequestParam(name = "wayId", defaultValue = "") int wayId,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              Model model) {


        model.addAttribute("wayId", wayId);
        Page<Length> pagesLength = lengthSvc.findAllByWayId(wayId, PageRequest.of(page, 5));
        model.addAttribute("lengths",pagesLength.getContent());
        model.addAttribute("arrayNbPagesLength", new int[pagesLength.getTotalPages()]);
        model.addAttribute("currentPageLength", page);
        model.addAttribute("nbPagesLength", pagesLength.getTotalPages());

        return "length/length";
    }



    /**
     * Affiche le formulaire pour créer une longueur
     *
     * @return
     */
    @RequestMapping(value = "/addlength", method = RequestMethod.GET)
    public String formSector(@RequestParam("wayId") int wayId,
                             @ModelAttribute("length") Length length,
                             Model model) {
        model.addAttribute("wayId", wayId);
        return "length/addlength";
    }

    /**
     * Créer une nouvelle longueur
     *
     * @param wayId
     * @return
     */
    @RequestMapping(value = "/addlength", method = RequestMethod.POST)
    public ModelAndView createSector(@RequestParam("wayId") int wayId,
                                     @ModelAttribute("length") Length length) {
        lengthSvc.saveLength(length);
        return new ModelAndView("redirect:/length?wayId=" + wayId);
    }

}
