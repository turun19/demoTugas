package com.example.binar.demotugas.service;

import com.example.binar.demotugas.model.Staff;
import com.example.binar.demotugas.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    StaffRepository sf;
    //business logic
    public List<Staff> getAll() {
        return sf.findAll();
    }

    //business logic
    public Staff createAll(Staff param) {
        Optional<Staff> staff = sf.findById(param.getStaff_id()); // untuk pengecekan lewat id
        if(staff.isPresent()){
            throw new RuntimeException("Sudah Ada Databasenya");
        }else{
            return sf.save(param);
        }
    }

    //business logic
    public Staff uodateAll(Staff param) {
        Staff staff = sf.findById(param.getStaff_id()).get();
        staff.setFirst_name(param.getFirst_name());
        staff.setLast_name(param.getLast_name());
        staff.setAddress_id(param.getAddress_id());
        staff.setEmail(param.getEmail());
        staff.setStore_id(param.getStore_id());
        staff.setActive(param.getActive());
        staff.setUsername(param.getUsername());
        staff.setPassword(param.getPassword());

        return sf.save(param);

    }

    //business logic
    public Staff deleteColumn(int staffId) {
        Staff staff = sf.findById(staffId).get();
        sf.deleteById(staffId);
        return staff;

    }

    public List<Staff> MakeAll(List<Staff> parame) {
        List<Staff> list = new ArrayList<>();

        for(Staff staff : parame){
            Optional<Staff> filmExsist = sf.findById(staff.getStaff_id());
            if(filmExsist.isPresent()){
                throw new RuntimeException("Film Code " + staff.getStaff_id() + " Sudah Ada");
            }
            else {
                list.add(sf.save(staff));
            }
        }
        return sf.saveAll(list);
    }

    public List<Staff> findByUsername(String username){
        return sf.findByUsername(username);
    }

    public List<Staff> findByEmail(String email){
        return sf.findByEmail(email);
    }

}
