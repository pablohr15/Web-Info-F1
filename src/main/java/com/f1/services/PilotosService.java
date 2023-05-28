package com.f1.services;

import com.f1.models.Piloto;
import com.f1.repositories.PilotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotosService implements InterfacePilotosService{

    @Autowired
    PilotosRepository repository;

    @Override
    public List<Piloto> getAllDrivers() {
        return this.repository.findAll();
    }

    @Override
    public Piloto getDriverByName(int id) {
        return this.repository.findById(id).orElse(new Piloto());
    }
}
