package com.ksmotors.dealership.service;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.ksmotors.dealership.model.Car;
import com.ksmotors.dealership.repository.CarRepo;

@Service
public class CarService {
    @Autowired
    private CarRepo repo;
    
    public List<Car> getcars(){
        return repo.findAll();
    }

    public Car getcarbyidno(@PathVariable long idno) {
        return repo.findByIdno(idno);
    }
    
    public Car getcarbyid(@PathVariable long idno) {
        return repo.findByIdno(idno);
    }

    public void addCar(Car car,MultipartFile image) throws IOException {
        System.out.println("Saving car: " + car);

        car.setImgname(image.getOriginalFilename());
        car.setImgtype(image.getContentType());
        car.setImgdata(image.getBytes());
        System.out.println("Saving car: " + car);

        repo.save(car);
        System.out.println("Saving car: " + car);

    }
    public List<Car> getcarbytype(@PathVariable String type)
    {
        return repo.findBytype(type);
    }


}
// this shit carries out logical shit