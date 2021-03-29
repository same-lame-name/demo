package com.samelamename.demo.controllers;

import com.samelamename.demo.entity.Hotel;
import com.samelamename.demo.repository.HotelMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mongoRepository")
public class HotelMongoRepositoryController {
    @Autowired
    private HotelMongoRepository hotelMongoRepository;

    @GetMapping("/all")
    public List<Hotel> getAll(){
        return hotelMongoRepository.findAll();
    }

    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country){
        return hotelMongoRepository.findByCountry(country);
    }
}
