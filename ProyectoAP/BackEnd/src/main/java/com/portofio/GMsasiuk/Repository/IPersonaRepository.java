package com.portofio.GMsasiuk.Repository;

import com.portofio.GMsasiuk.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {
    public Optional<Persona>findByNombre(String nombre);
    public boolean existByNombre(String nombre);
    
}