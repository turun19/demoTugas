package com.example.binar.demotugas.repository;

import com.example.binar.demotugas.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
  @Query("SELECT s FROM Staff s WHERE LOWER(s.username) LIKE LOWER(concat('%',:username,'%') ) ")
    List<Staff> findByUsername(@Param("username") String username);

  @Query("SELECT s FROM Staff s WHERE LOWER(s.email) LIKE LOWER(concat('%',:email,'%') ) ")
    List<Staff> findByEmail(@Param("email") String email);

}
