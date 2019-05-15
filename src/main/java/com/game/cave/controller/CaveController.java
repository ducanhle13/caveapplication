package com.game.cave.controller;

import com.game.cave.model.Cave;
import com.game.cave.model.Zone;
import com.game.cave.service.ZoneService;
import com.game.cave.service.impl.CaveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.Optional;

@Controller
public class CaveController {

    @Autowired
    private CaveServiceImpl caveService;

    @Autowired
    private ZoneService zoneService;

    @ModelAttribute("zones")
    public Page<Zone> zones(Pageable pageable) {
        return zoneService.findAll(pageable);
    }

    @GetMapping("/caves")
    public ModelAndView list(@PageableDefault(size = 5) Pageable pageable,
                             @RequestParam("mid") Optional<String> mid,
                             @RequestParam("zone_id") Optional<Long> zone_id) {
        ModelAndView modelAndView = new ModelAndView();
        Page<Cave> caves;
        if (mid.isPresent()) {
            caves = caveService.findAllByNameContaining(mid.get(), pageable);
        }
        else if(zone_id.isPresent()){
            Optional<Zone> zone = zoneService.findById(zone_id.get());
            caves = caveService.findAllByZone(zone,pageable);
            modelAndView.addObject("zone_id", zone_id.get());
        }
        else {
            caves = caveService.findAll(pageable);
        }
        modelAndView.setViewName("cave/list");
        modelAndView.addObject("caves", caves);
        return modelAndView;
    }

    @GetMapping("/create-cave")
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cave/create");
        mv.addObject("cave", new Cave());
        return mv;
    }

    @PostMapping("/save-cave")
    public ModelAndView save(@ModelAttribute("cave") Cave cave) {
        ModelAndView mv = new ModelAndView();
        caveService.save(cave);
        mv.setViewName("cave/create");
        mv.addObject("msg", "create success");
        mv.addObject("cave", new Cave());
        return mv;
    }

    @GetMapping("edit-cave/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Optional<Cave> cave = caveService.findById(id);
        mv.setViewName("cave/edit");
        mv.addObject("cave", cave);
        return mv;
    }

    @PostMapping("/update-cave")
    public ModelAndView update(@ModelAttribute("cave") Cave cave) {
        ModelAndView mv = new ModelAndView();
        caveService.save(cave);
        mv.setViewName("cave/edit");
        mv.addObject("msg", "update success");
        mv.addObject("cave", new Cave());
        return mv;
    }

    @GetMapping("/delete-cave/{id}")
    public ModelAndView delete(@ModelAttribute("cave") Cave cave) {
        ModelAndView mv = new ModelAndView();
        caveService.delete(cave.getId());
        mv.setViewName("redirect:/caves");
        return mv;
    }

    @GetMapping("/view-cave/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Optional<Cave> cave = caveService.findById(id);
        mv.setViewName("cave/view");
        mv.addObject("cave", cave);
        return mv;
    }


}
