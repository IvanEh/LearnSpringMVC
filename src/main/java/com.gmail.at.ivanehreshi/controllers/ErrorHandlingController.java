package com.gmail.at.ivanehreshi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class ErrorHandlingController {

    /**
     * Display custom page with 403 response status
     */
    @RequestMapping("/forbidden")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String forbidden() {
        return "error/forbidden";
    }


    /**
     * Default page with 400 response status
     * Method bad request and web.xml changes default 400 page
     */
    @RequestMapping("/throwBadRequest")
    public String throwBadRequest() throws BindException {
        throw new BindException(true, null);
    }

    @RequestMapping("/400")
    public String badRequest() {
        return "/error/400";
    }
}
