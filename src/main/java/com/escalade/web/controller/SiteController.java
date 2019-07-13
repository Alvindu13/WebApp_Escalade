package com.escalade.web.controller;

import com.escalade.data.model.Comment;
import com.escalade.data.model.Site;
import com.escalade.data.model.Topo;
import com.escalade.data.repository.CommentRepository;
import com.escalade.svc.contracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping("sites")
public class SiteController {


    @Autowired
    SiteService svcSite;
  
    @Autowired
    TopoService svcTopo;

    @Autowired
    UserEscaladService svcUser;

    @Autowired
    CommentService svcCmt;

    @Autowired
    SectorService svcSect;

    /**
     * afficher tous les sites d'escalades
     *
     * @param model
     * @return la page sites
     */
    @RequestMapping(value = "/sites", method = RequestMethod.GET)
    public String displayAllSites(@ModelAttribute("site") Site site,
                                  @RequestParam("topoId") int topoId,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  Model model) {

            Page<Site> pagesSite = svcSite.getAllByTopoId(topoId, PageRequest.of(page, 5));
            model.addAttribute("topoId", topoId);
            model.addAttribute("sites",pagesSite.getContent());
            model.addAttribute("arrayNbPagesSite", new int[pagesSite.getTotalPages()]);
            model.addAttribute("currentPageSite", page);
            model.addAttribute("nbPagesSite", pagesSite.getTotalPages());

            return "site/sites";
    }

    /**
     * afficher le site d'escalade sélectionné ainsi que les commentaires rattachés
     *
     * @param model
     * @return la page site
     */
    @RequestMapping(value = "site", method = RequestMethod.GET)
    public String displaySelectedSiteAndCmt(@RequestParam(name="page", defaultValue = "0") int page,
                                   @RequestParam("siteId") int siteId,
                                   @RequestParam(name = "user") String user,
                                   Model model) {

        Page<Comment> pageCmt = svcCmt.getAllCommentBySiteId(siteId, PageRequest.of(page, 5));
        model.addAttribute("site", svcSite.getSiteBySiteId(siteId));
        model.addAttribute("countSect", svcSect.getCountSector(siteId));
        model.addAttribute("cmt",pageCmt.getContent());
        model.addAttribute("pages", new int[pageCmt.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("nbPagesCmt", pageCmt.getTotalPages());
        model.addAttribute("user", svcUser.getUserEscaladByUserName(user));
        return "site/site";
    }

    /**
     * Affiche le formulaire d'ajout de site
     *
     * @return
     */
    @RequestMapping(value = "/addsite", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("topo") Topo topo, @RequestParam("topoId") int topoId, Model model) {
        model.addAttribute("topo", svcTopo.getTopoById(topoId));
        return "site/addsite";
    }


    /**
     * Créer un nouveau site selon les informations entrées par l'utilisateur
     * @param site
     * @param topoId
     * @param topo
     * @return
     */
    @RequestMapping(value = "/addsite", method = RequestMethod.POST)
    public ModelAndView createSite(@ModelAttribute("site") Site site,@RequestParam("topoId") int topoId, @ModelAttribute("topo") Topo topo ) {
        site.setTopoId(topoId);
        svcSite.createSite(site);
        return new ModelAndView("redirect:/sites?topoId=" + topoId);
    }

    /**
     * Ajoute un Comment dans la db
     * @param cmt
     * @return
     */
    @RequestMapping(value = "/addcmt", method = RequestMethod.POST)
    public ModelAndView postComment(@ModelAttribute("Comment") Comment cmt) {
        svcCmt.saveComment(cmt);
        return new ModelAndView("redirect:/site?siteId=" + cmt.getSiteId() + "&user=" + cmt.getUserName());
    }

}
