package com.ksmotors.dealership.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ksmotors.dealership.model.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findBytype(String type);
    List<Car> findBymanufacturer(String manufacturer);
    
    Car findByIdno(long idno);

    @Query(value = "SELECT * FROM car ORDER BY idno DESC LIMIT 4", nativeQuery = true)
    List<Car> findLast4Cars();
}
