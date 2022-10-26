package com.portofio.GMsasiuk.Repository;

import com.portofio.GMsasiuk.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    //Mét. propios de la clase
    public Optional<Experiencia> findByNombreE(String nombreE);

    public boolean existsByNombreE(String nombreE);
}