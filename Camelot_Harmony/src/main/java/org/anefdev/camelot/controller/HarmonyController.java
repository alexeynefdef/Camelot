package org.anefdev.camelot.controller;

import org.anefdev.camelot.service.HarmonyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HarmonyController {

    private final HarmonyService service;

    public HarmonyController(HarmonyService service) {
        this.service = service;
    }
    @GetMapping("/camelot")
    public String home() {
        return "homepage";
    }



}
