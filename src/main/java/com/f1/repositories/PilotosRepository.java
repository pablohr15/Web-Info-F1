package com.f1.repositories;


import com.f1.models.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotosRepository extends JpaRepository<Piloto, Integer> {
}
