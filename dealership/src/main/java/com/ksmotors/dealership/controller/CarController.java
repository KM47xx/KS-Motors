package com.ksmotors.dealership.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.ksmotors.dealership.model.Car;
import com.ksmotors.dealership.service.CarService;

@CrossOrigin(origins = "*")
@Controller //while website
public class CarController {
    @Autowired
    CarService carservice;

    @GetMapping("/listing")
    public String listingpage(){
        return "listings.html";
    }
    @GetMapping("/cardetails")
    public String detailpage(){
        return "cardetail.html";
    }
    @GetMapping("/KS-Motors")
    public String homepage(){
        return "index.html";
    }
    @GetMapping("/brands")
    public String brandpage(){
        return "brand.html";
    }
    @GetMapping("/listing/{type}")//listing page ka
    @ResponseBody
    public List<Car> getcarbytype(@PathVariable String type ) {
        return carservice.getcarbytype(type);
        
    }

    @GetMapping("/cardetails/{idno}")//single car detail page
    @ResponseBody
    public Car getdetails(@PathVariable long idno ) {
        return carservice.getcarbyidno(idno);    
    }

    @GetMapping("/listing/{idno}/image")
    @ResponseBody
    public ResponseEntity<byte[]> getimagebyid(@PathVariable long idno)
    {
        Car car=carservice.getcarbyidno(idno);

        byte[] img=car.getImgdata();
        return ResponseEntity.ok().contentType(MediaType.valueOf(car.getImgtype())).body(img);

    }

    @GetMapping("/KS-Motors/")
    @ResponseBody
    public List<Car> homecars() {
        return carservice.getrecentcars();
    }

    @GetMapping("/brands/{manufacturer}")
    @ResponseBody
    public List<Car> carsbymanufacturer(@PathVariable String manufacturer){
        return carservice.getcarbymanufacturer(manufacturer);
    }

    
    @PostMapping("/submit")
    public void addCar(@RequestPart("carData") Car car,@RequestPart("image") MultipartFile image) throws IOException{
        carservice.addCar(car,image);
    }
}
// this shit is controller, page address set karto,output cha pn kam karto
// also db reset karna hai toh ye dalna only: TRUNCATE TABLE car; isse idno back to 1 hoga