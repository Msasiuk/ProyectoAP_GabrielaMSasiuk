package com.portofio.GMsasiuk.Repository;

import com.portofio.GMsasiuk.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer> {
    //Mét. propios además de los que herededa de Jpa Repository
    public Optional<Educacion> findByNombreE(String nombreE);

    public boolean existsByNombreE(String nombreE);
}
