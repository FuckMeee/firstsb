package com.hope.firstsb.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author zwh
 */

@RestController
@RequestMapping("/test2")
public class Test2Controller extends BaseController {
    @GetMapping("/file")
    public String file() {
        return "file";
    }

}
