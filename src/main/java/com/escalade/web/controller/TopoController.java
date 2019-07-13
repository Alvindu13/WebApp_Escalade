package com.escalade.web.controller;

import com.escalade.data.model.Topo;
import com.escalade.data.model.UserEscalad;
import com.escalade.data.util.DefineAttributes;
import com.escalade.svc.contracts.FilesService;
import com.escalade.svc.contracts.TopoService;
import com.escalade.svc.contracts.UserEscaladService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TopoController {


    @Autowired
    private TopoService topoSvc;

    @Autowired
    private UserEscaladService userSvc;

    @Autowired
    private FilesService fSvc;


    
    /**
     * Affiche la page des topos
     * @param model
     * @return
     */
    @RequestMapping(value = "/topo", method = RequestMethod.GET)
    public String displayTopo(@RequestParam(name = "user", defaultValue = "") String user,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              Model model) {


        DefineAttributes defineAttributes = new DefineAttributes();

        model.addAttribute("defineDownload", defineAttributes.defineDownload(topoSvc, fSvc));

        Page<Topo> pagesTopo = topoSvc.getAllTopo(PageRequest.of(page, 10));
        model.addAttribute("topos",pagesTopo.getContent());
        model.addAttribute("arrayNbPagesTopo", new int[pagesTopo.getTotalPages()]);
        model.addAttribute("currentPageTopo", page);
        model.addAttribute("currentUser", userSvc.getUser(user));
        model.addAttribute("nbPagesTopo", pagesTopo.getTotalPages());

        return "topo/galeryTopo";
    }

    /**
     * Affiche le formulaire d'ajout de Topo
     *
     * @return
     */
    @RequestMapping(value = "/atopo", method = RequestMethod.GET)
    public ModelAndView showFormTopo(@RequestParam("user") String user, Model model) {
        model.addAttribute("currentUser", userSvc.getUserEscaladByUserName(user));
        return new ModelAndView("topo/addtopo", "atopo", new Topo());
    }


    /**
     * Permet d'ajouter un Topo
     *
     * @param topo
     * @return la page en cours
     */
    @RequestMapping(value = "/addtopo", method = RequestMethod.POST)
    public ModelAndView saveTopo(@ModelAttribute("atopo") Topo topo) {
        topoSvc.createTopo(topo);
        return new ModelAndView("redirect:/topo");
    }


    /**
     * Affiche les topos de l'utilisateur connecté
     * @param user
     * @param pageTopo
     * @param pageTopoShare
     * @param currentlyUser
     * @param model
     * @return
     */
    @RequestMapping(value = "/mytopo", method = RequestMethod.GET)
    public String displayUserTopos(@RequestParam("user") String user,
                                  @RequestParam(name = "pageTopo", defaultValue = "0") int pageTopo,
                                  @RequestParam(name = "pageTopoShare", defaultValue = "0") int pageTopoShare,
                                  @ModelAttribute("currentUser") UserEscalad currentlyUser,
                                  Model model) {


        currentlyUser = userSvc.getUser(user);
        Page<Topo> pagesTopo = topoSvc.getAllByUserEscaladName(user, PageRequest.of(pageTopo, 5));
        Page<Topo> pagesTopoShare = topoSvc.getAllByCurrentlyUserEscalad(currentlyUser.getUserEscaladId(), PageRequest.of(pageTopoShare, 5));
        model.addAttribute("user", userSvc.getUser(user));
        model.addAttribute("topos", pagesTopo.getContent());
        model.addAttribute("tShare",pagesTopoShare.getContent());
        model.addAttribute("arrayNbPagesTopo", new int[pagesTopo.getTotalPages()]);
        model.addAttribute("arrayNbPagesTopoShare", new int[pagesTopoShare.getTotalPages()]);
        model.addAttribute("currentPageTopo", pageTopo);
        model.addAttribute("currentPageTopoShare", pageTopoShare);
        model.addAttribute("nbPagesTopo", pagesTopo.getTotalPages());
        model.addAttribute("nbPagesTopoShare", pagesTopoShare.getTotalPages());

        return "topo/mytopo";
    }

    @RequestMapping(value = "/mytopo", method = RequestMethod.POST)
    public ModelAndView shareTopo(@RequestParam("user") String user,
                                  @RequestParam(name = "action", defaultValue = "") String action,
                                  @ModelAttribute("topo") Topo topo) {
        topoSvc.updateTopo(action, topo.getReserve(), user, topo.getTopoId());
        return new ModelAndView( "redirect:/mytopo?user=" + user);
    }

    /**
     * Affiche la page de réservation des topo
     * @param model
     * @return
     */
    @RequestMapping(value = "/displaytopoavailable", method = RequestMethod.GET)
    public String displayTopoReservation(@RequestParam(name="page", defaultValue = "0") int page,
                                         @RequestParam("user") String user,
                                         @RequestParam(name="available", defaultValue = "true") Boolean available,
                                         Model model) {

        Page<Topo> pagesTopo = topoSvc.getAllByAvailableIsTrue(available,  PageRequest.of(page, 5));
        model.addAttribute("topos",pagesTopo.getContent());
        model.addAttribute("arrayNbPagesTopo", new int[pagesTopo.getTotalPages()]);
        model.addAttribute("currentPageTopo", page);
        model.addAttribute("currentUser", userSvc.getUser(user));
        model.addAttribute("nbPagesTopo", pagesTopo.getTotalPages());

        return "topo/displaytopoavailable";
    }

    /**
     * Affiche la page de réservation des topo
     * @return
     */
    @RequestMapping(value = "/reservetopo", method = RequestMethod.POST)
    public ModelAndView reserveTopo(@RequestParam("userId") int userId,
                                    @RequestParam("topoId") int topoId) {

        topoSvc.setTopoUserNameByUserEscaladId(userId, topoId);
        topoSvc.setTopoUnvailableById(false, topoId);
        topoSvc.setTopoReserveUserEscaladIdByTopoId(true, topoId);

        return new ModelAndView( "redirect:/displaytopoavailable?user=" +  userSvc.findByUserEscaladId(userId).getUserName());
    }




}