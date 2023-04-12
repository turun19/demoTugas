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
    public List<Staff> getAll(){ // read data
        return ss.getAll();
    }

    @PostMapping(value = "/staff-add")
    public Staff addOne(@RequestBody Staff param){ // add data
        return ss.createAll(param);
    }

    @PutMapping(value = "/staff-update")
    public Staff updateOne(@RequestBody Staff param){ // update data
        return ss.uodateAll(param);
    }

    @DeleteMapping(value = "/delete/{staff_id}")
    public Staff deleteOne(@PathVariable int staff_id){ // delete data
        return ss.deleteColumn(staff_id);
    }

    @PostMapping(value = "/staff-addList")
    public List<Staff> MakeAll(@RequestBody List<Staff> parame){ // add data
        return ss.MakeAll(parame);
    }

    @GetMapping(value = "/check-username/{username}")
    public List<Staff> findByUsername(@PathVariable("username") String username){
        return ss.findByUsername(username);
    }

    @GetMapping(value = "/check-email/{email}")
    public List<Staff> findByEmail(@PathVariable("email") String email){
        return ss.findByEmail(email);
    }
}
