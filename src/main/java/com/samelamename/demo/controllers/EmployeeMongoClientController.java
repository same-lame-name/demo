package com.samelamename.demo.controllers;

import com.samelamename.demo.domain.EmployeeDTO;
import com.samelamename.demo.service.EmployeeMongoClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongoClient")
public class EmployeeMongoClientController {
    @Autowired
    private EmployeeMongoClientService service;

    @GetMapping("/all")
    public List<EmployeeDTO> getAll(){
        return service.getAll();
    }

    @PostMapping("/")
    public String add(@RequestBody EmployeeDTO employeeDTO){
        return service.add(employeeDTO);
    }

//    @PutMapping("/")
//    public String update(@RequestBody EmployeeDTO employeeDTO){
//        return service.update(employeeDTO);
//    }
}
