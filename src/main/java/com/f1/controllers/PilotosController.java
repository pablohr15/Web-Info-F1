package com.f1.controllers;

import com.f1.models.Piloto;
import com.f1.services.PilotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@CrossOrigin
public class PilotosController {

    @Autowired
    PilotosService services;

    @GetMapping()
    public List<Piloto> getAllDrivers(){
        return this.services.getAllDrivers();
    }

    @GetMapping("/{id}")
    public Piloto getDriverById(@PathVariable(name = "id") int id){
        return this.services.getDriverByName(id);
    }
}
