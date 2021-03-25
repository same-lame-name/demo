package com.samelamename.demo.controllers;

import com.samelamename.demo.entity.Hotel;
import com.samelamename.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelResource {
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/all")
    public List<Hotel> getAll(){
        return hotelRepository.findAll();
    }

    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country){
        return hotelRepository.findByCountry(country);
    }
}
