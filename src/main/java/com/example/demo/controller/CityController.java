package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class CityController {
    @Autowired
    CityService cityService;
    @GetMapping()
    public ModelAndView showHome(){
        ModelAndView mv = new ModelAndView("home");
        Iterable<City> cityList = cityService.findAll();
        mv.addObject("cityList",cityList);
        mv.addObject("city", new City());
        return mv;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView cityDetail(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("cityDetail");
        City city = cityService.findById(id);
        mv.addObject("city", city);
        return mv;
    }
    @PostMapping("/addCity")
    public String saveCity(@ModelAttribute City city){
        cityService.save(city);
        return "redirect:/";
    }
    @GetMapping("/addCity")
    public ModelAndView addCity(){
        ModelAndView mv = new ModelAndView("creatNewCity");
        List<String> myNationalList = new ArrayList<>();
        myNationalList.add("Viet Nam");
        myNationalList.add("Lao");
        myNationalList.add("Thai Lan");
        myNationalList.add("Nhat Ban");
        myNationalList.add("Capuchia");
        mv.addObject("city", new City());
        mv.addObject("nationalList", myNationalList);
        return mv;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editCity(@PathVariable Long id){
        City city = cityService.findById(id);
        ModelAndView mv = new ModelAndView("editCity");
        mv.addObject("city", city);
        return mv;
    }
    @PostMapping("/edit")
    public String updateCity(@ModelAttribute City city){
        cityService.save(city);
        return "redirect:/";

    }
    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable Long id){
        cityService.remove(id);
        return "redirect:/";
    }
}
