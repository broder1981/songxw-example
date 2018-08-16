package com.songxw.universalbox.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SimpleMVC {

    @RequestMapping(value = "/homePage")
    //页面跳转
    public ModelAndView homePage () {
        ModelAndView modelAndView = new ModelAndView ();
        modelAndView.setViewName("simplemvc/transmit_value.html");
        modelAndView.addObject("param","Hello World");
        return modelAndView;
    }

    @RequestMapping(value = "/transmitValue")
    @ResponseBody
    //前后台值传递
    public String transmitValue (String testValue) {
        System.out.println(testValue);
        return testValue;
    }

}
