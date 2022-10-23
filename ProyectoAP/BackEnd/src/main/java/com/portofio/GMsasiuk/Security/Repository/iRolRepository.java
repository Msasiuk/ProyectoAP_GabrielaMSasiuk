package com.portofio.GMsasiuk.Security.Repository;

import com.portofio.GMsasiuk.Security.Entity.Rol;
import com.portofio.GMsasiuk.Security.Enum.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}