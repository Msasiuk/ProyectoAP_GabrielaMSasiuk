package com.portofio.GMsasiuk.Repository;

import com.portofio.GMsasiuk.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {
        //Mét. propios además de los que herededa de Jpa Repository
    public Optional<Proyecto> findByNombreP(String nombreP);

    public boolean existsByNombreP(String nombreP);
}
