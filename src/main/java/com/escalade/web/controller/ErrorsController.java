package com.escalade.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorsController {

    /**
     * Génère des erreurs génériques pour toutes les exceptions web
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        return new ModelAndView("error/exception_error");
    }
}
