package com.samelamename.demo.seeder;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoClientImpl;
import com.samelamename.demo.domain.Address;
import com.samelamename.demo.domain.Review;
import com.samelamename.demo.entity.Hotel;
import com.samelamename.demo.repository.HotelMongoRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private HotelMongoRepository hotelMongoRepository;

    @Autowired
    private MongoClient client;

    @Override
    public void run(String... args) throws Exception {
        //Add values in the mongoRepository collection
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

        this.hotelMongoRepository.deleteAll();

        List<Hotel> hotels = Arrays.asList(hareKrishna, tajMahal,olive, ghost);
        this.hotelMongoRepository.saveAll(hotels);

        //Add values in the mongoClient collection
        MongoDatabase database = client.getDatabase("HotelBase");
        MongoCollection<Document> collection = database.getCollection("Employee");

        Document shashank = new Document();
        shashank.append("firstName", "Shashank");
        shashank.append("lastName", "Tiwari");
        shashank.append("address", "Mumbai");

        Document aman = new Document();
        aman.append("firstName", "Aman");
        aman.append("lastName", "Nayak");
        aman.append("address", "Mumbai");

        Document sushil = new Document();
        sushil.append("firstName", "Sushil");
        sushil.append("lastName", "Pandey");
        sushil.append("address", "Mumbai");

        collection.deleteMany(new Document());
        collection.insertMany(Arrays.asList(shashank, aman, sushil));




    }
}
