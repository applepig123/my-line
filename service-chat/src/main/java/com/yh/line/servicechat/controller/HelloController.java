package com.yh.line.servicechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanghua on 2019/3/14.
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String hi() {
        return "hi, man";
    }
}
