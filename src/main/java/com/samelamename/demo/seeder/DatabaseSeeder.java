package com.samelamename.demo.seeder;

import com.samelamename.demo.domain.Address;
import com.samelamename.demo.domain.Review;
import com.samelamename.demo.entity.Hotel;
import com.samelamename.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        Hotel hareKrishna = new Hotel(
                "Hare Krishna Hotel",
                150,
                new Address("Mathura", "Uttarpradesh", "India"),
                Arrays.asList(
                        new Review("Shashank", 8, false),
                        new Review("Anil", 9, true)
                )
        );

        Hotel tajMahal = new Hotel(
                "Tajmahal Hotel",
                3000,
                new Address("Mumbai", "Maharashtra", "India"),
                Arrays.asList(
                        new Review("Shashank", 10, false),
                        new Review("Anil", 10, false)
                )
        );

        Hotel olive = new Hotel(
                "Olive Hotel",
                560,
                new Address("Roorkee", "Uttarakhand", "India"),
                Arrays.asList(
                        new Review("Shashank", 7, true),
                        new Review("Aman", 7, true)
                )
        );

        Hotel ghost = new Hotel(
                "Ghost",
                100,
                new Address("Nowhere", "Unknown", "Undefined"),
                new ArrayList<>()
        );

        this.hotelRepository.deleteAll();

        List<Hotel> hotels = Arrays.asList(hareKrishna, tajMahal,olive, ghost);
        this.hotelRepository.saveAll(hotels);

    }
}
