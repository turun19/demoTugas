package com.example.binar.demotugas.controller;

import com.example.binar.demotugas.model.Staff;
import com.example.binar.demotugas.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/staff")
public class StaffController {
    @Autowired
    StaffService ss;
    @GetMapping
    public List<Staff> getAll(){
        return ss.getAll();
    }

    @PostMapping(value = "/staff-add")
    public Staff addOne(@RequestBody Staff param){
        return ss.createAll(param);
    }

    @PutMapping(value = "/staff-update")
    public Staff updateOne(@RequestBody Staff param){
        return ss.uodateAll(param);
    }

    @DeleteMapping(value = "/delete/{staff_id}")
    public Staff deleteOne(@PathVariable int staff_id){
        return ss.deleteColumn(staff_id);
    }

}
