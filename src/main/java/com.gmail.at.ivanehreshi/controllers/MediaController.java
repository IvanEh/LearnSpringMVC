package com.gmail.at.ivanehreshi.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MediaController {

    /**
     * from reference:
     * parameters for access to the Servlet request HTTP headers and contents.
     * The request stream will be converted to the entity body using HttpMessageConverter
     */
    @RequestMapping("/info")
    @ResponseBody
    public String info(HttpEntity<String> header) {
        return header.toString();
    }

    @RequestMapping(value = "/media/txt", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String txt() {
        return "<html><body> No html </body></html>";
    }

    @RequestMapping(value = "/media/html", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String html() {
        return "<html><body> No html </body></html>";
    }

    @RequestMapping(value = "/media/css-demo")
    public String cssDemo() {
        return "cssDemo";
    }

    @RequestMapping(value = "/media/request-css", consumes = "text/css", produces = "text/css")
    @ResponseBody
    public String css() {
        return "body { background: #FCFDFB }";
    }
}
