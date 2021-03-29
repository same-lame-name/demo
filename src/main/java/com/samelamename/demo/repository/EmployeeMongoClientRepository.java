package com.samelamename.demo.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.samelamename.demo.domain.EmployeeDTO;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeMongoClientRepository {
    @Autowired
    private MongoClient client;

    public List<EmployeeDTO> getAll() {
        MongoDatabase database = client.getDatabase("HotelBase");
        MongoCollection<Document> collection = database.getCollection("Employee");

        List<EmployeeDTO> response = new ArrayList<>();
        FindIterable<Document> documents = collection.find();

        for(Document entry : documents){
            EmployeeDTO employee = new EmployeeDTO(entry.get("_id").toString(), entry.getString("firstName"), entry.getString("lastName"), entry.getString("address"));
            response.add(employee);
        }

        return response;
    }

    public String add(EmployeeDTO employeeDTO) {
        MongoDatabase database = client.getDatabase("HotelBase");
        MongoCollection<Document> collection = database.getCollection("Employee");

        String response;
        Document employee = new Document();
        employee.append("firstName", employeeDTO.getFirstName());
        employee.append("lastName", employeeDTO.getLastName());
        employee.append("address", employeeDTO.getAddress());

        try{
            collection.insertOne(employee);
            response = "Successfully Added!";
        }catch(Exception exception){
            response = "Something went wrong!";
        }

        return response;
    }

//    public String update(EmployeeDTO employeeDTO) {
//        MongoDatabase database = client.getDatabase("HotelBase");
//        MongoCollection collection = database.getCollection("Employee");
//
//        String response;
//        Document employee = new Document();
//        employee.append("firstName", employeeDTO.getFirstName());
//
//    }
}
