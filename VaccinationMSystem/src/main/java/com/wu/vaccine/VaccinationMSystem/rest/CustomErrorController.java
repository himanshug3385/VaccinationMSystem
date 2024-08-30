package com.wu.vaccine.VaccinationMSystem.rest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController  {
    public CustomErrorController(){

    }
    @GetMapping("/*")
    public String getError(){
        return "404Page";
    }
}
