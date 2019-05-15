package com.game.cave.controller;

import com.game.cave.model.Zone;
import com.game.cave.service.impl.ZoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ZoneController {

    @Autowired
    private ZoneServiceImpl zoneService;

    @GetMapping("/zones")
    public ModelAndView list (Pageable pageable) {
        ModelAndView mv = new ModelAndView("zone/list");
        Iterable<Zone> zone = zoneService.findAll(pageable);
        mv.addObject("zones", zone);
        return mv;
    }

    @GetMapping("/create-zone")
    public ModelAndView create (Zone zone) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("zone/create");
        mv.addObject("zone",new Zone());
        return mv;
    }

    @PostMapping("/save-zone")
    public ModelAndView save (@ModelAttribute("zone") Zone zone) {
        ModelAndView mv = new ModelAndView();
        zoneService.save(zone);
        mv.setViewName("zone/create");
        mv.addObject("msg", "create success");
        mv.addObject("zone", new Zone());
        return mv;
    }

    @GetMapping ("/edit-zone/{id}")
    public ModelAndView edit (@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Optional<Zone> zone = zoneService.findById(id);
        mv.setViewName("zone/edit");
        mv.addObject("zone", zone);
        return mv;
    }

    @PostMapping ("/update-zone")
    public ModelAndView update (@ModelAttribute("zone") Zone zone) {
        ModelAndView mv = new ModelAndView();
        zoneService.save(zone);
        mv.setViewName("zone/edit");
        mv.addObject("msg", "update success");
        mv.addObject("zone", new Zone());
        return mv;
    }

    @GetMapping ("/delete-zone/{id}")
    public ModelAndView delete (@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        zoneService.delete(id);
        mv.setViewName("redirect:/zones");
        return mv;
    }

}
