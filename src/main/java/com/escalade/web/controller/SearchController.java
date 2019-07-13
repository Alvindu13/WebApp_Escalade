package com.escalade.web.controller;

import com.escalade.data.util.Search;
import com.escalade.data.model.Site;
import com.escalade.data.repository.SiteRepository;
import com.escalade.data.repository.WayRepository;
import com.escalade.svc.contracts.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class SearchController {


    @Autowired
    private SiteService svcSite;

    /**
     * Permet de faire une recherche mono-critère
     * @param mc
     * @param page
     * @param model
     * @return
     */
    @GetMapping("/search")
    public String chercher(@RequestParam(name="motCle", defaultValue = "") String mc,
                           @RequestParam(name="page", defaultValue = "0") int page,
                           Model model) {
        Page<Site> pageSites = svcSite.getAllSiteByCritera(mc, PageRequest.of(page, 5));
        model.addAttribute("sites",pageSites.getContent());
        model.addAttribute("pages", new int[pageSites.getTotalPages()]);
        model.addAttribute("motCle", mc);
        model.addAttribute("currentPage", page);
        return "search/search";
    }

    /**
     * Affiche la page de recherche
     * @param model
     * @return
     */
    @GetMapping("/multisearch")
    public String chercherMultiple(Model model) {
        model.addAttribute("sites", svcSite.getDisctinctLocation());
        return "search/multisearch";
    }

    /**
     * Récupère les informations rentrées par l'utilisateur
     * @param search
     * @return
     */
    @PostMapping("/multisearch")
    public String recupDataSearch(
            @ModelAttribute("searcher") Search search) {
        return "redirect:searchresult?location=" + search.getLocation() + "&cotation_minimum=" + search.getCotationMinimum() + "&cotation_maximum=" + search.getCotationMaximum();
    }


    /**
     * Affiche le résultat de la recherche multicritères
     * @param location
     * @param cotationMini
     * @param cotationMaxi
     * @param model
     * @return
     */
    @GetMapping("/searchresult")
    public String resultSearch(@RequestParam(name="location") String location,
                               @RequestParam(name="cotation_minimum") String cotationMini,
                               @RequestParam(name="cotation_maximum") String cotationMaxi,
                               Model model) {
        model.addAttribute("sites", svcSite.getAllSiteByResearch(location, cotationMini, cotationMaxi));
        return "search/searchresult";
    }



}
