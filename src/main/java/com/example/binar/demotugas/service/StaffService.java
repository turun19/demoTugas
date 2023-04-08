package com.example.binar.demotugas.service;

import com.example.binar.demotugas.model.Staff;
import com.example.binar.demotugas.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    StaffRepository sf;
    public List<Staff> getAll() {
        return sf.findAll();
    }

    public Staff createAll(Staff param) {
        Optional<Staff> staff = sf.findById(param.getStaff_id()); // untuk pengecekan lewat id
        if(staff.isPresent()){
            throw new RuntimeException("Sudah Ada Databasenya");
        }else{
            return sf.save(param);
        }
    }

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

    public Staff deleteColumn(int staffId) {
        Staff staff = sf.findById(staffId).get();
        sf.deleteById(staffId);
        return staff;
    }
}
