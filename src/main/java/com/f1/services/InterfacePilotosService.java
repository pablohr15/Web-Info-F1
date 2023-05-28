package com.f1.services;

import com.f1.models.Piloto;

import java.util.List;

public interface InterfacePilotosService {

    List<Piloto> getAllDrivers();

    Piloto getDriverByName(int id);

}
