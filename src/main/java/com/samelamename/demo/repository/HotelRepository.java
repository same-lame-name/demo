package com.samelamename.demo.repository;

import com.samelamename.demo.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    @Query(value = "{'address.country' : ?0}")
    List<Hotel> findByCountry(String country);
}
