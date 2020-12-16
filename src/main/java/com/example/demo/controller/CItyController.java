package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.city.ICityService;
import com.example.demo.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/city")
public class CItyController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;
    @GetMapping
    public ModelAndView showListCity(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("listCity",cityService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("listCountry",countryService.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public void saveCity(@ModelAttribute City city, HttpServletResponse response){
        cityService.save(city);
        try {
            response.sendRedirect("/city/create");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/info/{id}")
    public ModelAndView showInfoCity(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("city", cityService.findById(id).get());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city",cityService.findById(id).get());
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public void deleteCity(@PathVariable Long id, HttpServletResponse response){
        cityService.delete(id);
        try {
            response.sendRedirect("/city");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
