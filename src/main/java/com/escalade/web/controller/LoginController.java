package com.escalade.web.controller;

import com.escalade.data.model.UserEscalad;
import com.escalade.data.model.UserEscaladRole;
import com.escalade.svc.contracts.UserEscaladRoleService;
import com.escalade.svc.contracts.UserEscaladService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    UserEscaladService userSvc;

    @Autowired
    UserEscaladRoleService userRoleService;


    /**
     * Page d'accueil du website
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    /**
     * Affiche la page pour enregistrer un nouvel utilisateur
     * @param model
     * @return
     */
    @RequestMapping(value = {"/displayRegisterForm"}, method = RequestMethod.GET)
    public ModelAndView registerForm(Model model) {
        return new ModelAndView("login/registerForm", "user", new UserEscalad());
    }

    /**
     * Sauvegarde l'utilisateur dans la database
     * @param user
     * @return
     */
    @RequestMapping(value = {"/saveUser"}, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") UserEscalad user) {
        userSvc.createUser(user);
        userRoleService.saveRoleUser(new UserEscaladRole("USER"));
        return "redirect:/welcome";
    }


    /**
     * Affiche le formulaire de connexion
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login/loginPage";
    }

    /**
     * Affiche un message si la déconnexion de l'utilisateur s'est correctement déroulée
     * @param model
     * @return
     */
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "login/logoutSuccessfulPage";
    }

}
