package com.KnockKnock.Controllers;


import com.KnockKnock.Entities.*;
import com.KnockKnock.Repositories.CityRepository;
import com.KnockKnock.Services.CityService;
import com.KnockKnock.Services.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ProfessionalService professionalService;

    @GetMapping( value = "/getCountry")
    public ResponseEntity<List<Object>> getCategory() {

        try {

            List<Object> country=cityService.getAllCountry();

            System.out.println("I am fetching countries.........");

            return new ResponseEntity<List<Object>>(country, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Object>>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping( value = "/getState/{coun}")
    public ResponseEntity<List<Object>> getState(@PathVariable(value="coun") String count) {
        System.out.println("I am fetching States.........");
        try {
            List<Object> state=cityService.getAllState(count);

            return new ResponseEntity<List<Object>>(state, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Object>>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping( value = "/getCity/{stat}")
    public ResponseEntity<List<Object>> getCity(@PathVariable(value="stat") String state) {
        System.out.println("I am fetching Cities.........");
        try {
            List<Object> city=cityService.getAllCity(state);

            return new ResponseEntity<List<Object>>(city, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Object>>(HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("/postcity/{id}")
    public ResponseEntity<Long> postcity(@PathVariable("id") Long id, @RequestBody City a)
    {
        List<City> city;

        city=cityRepository.findAll();

            for (City c : city) {
                if ((a.getCityName().equals(c.getCityName())) && (a.getCityState().equals(c.getCityState())) &&
                        (a.getCityCountry().equals(c.getCityCountry()))) {
                    System.out.println("good to goo...................");




                        Professional professional = professionalService.findById(id);
                        // addressRepository.save(ad);
                        System.out.println("byeee..................");
                        professional.setServingCity(c);
                        professionalService.save(professional);
                        System.out.println("saved..................");
                    }
                }

        return new ResponseEntity<Long>(id, HttpStatus.OK);






    }


}
































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































