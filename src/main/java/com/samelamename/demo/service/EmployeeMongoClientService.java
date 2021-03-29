package com.samelamename.demo.service;

import com.samelamename.demo.domain.EmployeeDTO;
import com.samelamename.demo.repository.EmployeeMongoClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeMongoClientService {
    @Autowired
    private EmployeeMongoClientRepository repository;

    public List<EmployeeDTO> getAll() {
        return repository.getAll();
    }

    public String add(EmployeeDTO employeeDTO) {
        return repository.add(employeeDTO);
    }

//    public String update(EmployeeDTO employeeDTO) {
//        return repository.update(employeeDTO);
//    }
}
