package com.example.binar.demotugas.repository;

import com.example.binar.demotugas.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
  @Query("SELECT s FROM Staff s WHERE LOWER(s.username) LIKE LOWER(concat('%',:username,'%') ) ")
  List<Staff> findByUsername(String username);

  @Query("SELECT s FROM Staff s WHERE LOWER(s.email) LIKE LOWER(concat('%',:email,'%') ) ")
  List<Staff> findByEmail(String email);

}
