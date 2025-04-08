package com.ksmotors.dealership.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksmotors.dealership.model.Car;

@Repository
public interface CarRepo extends JpaRepository<Car,Long>{
    List<Car> findBytype(String type);
    Car findByIdno(long idno);

}
//this shit is required for sql/db