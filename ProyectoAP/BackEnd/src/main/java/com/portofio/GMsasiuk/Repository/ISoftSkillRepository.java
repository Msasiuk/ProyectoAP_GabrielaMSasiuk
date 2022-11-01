package com.portofio.GMsasiuk.Repository;

import com.portofio.GMsasiuk.Entity.SoftSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftSkillRepository extends JpaRepository<SoftSkill, Integer> {

    Optional<SoftSkill> findByNombreSf(String nombreSf);

    public boolean existsByNombreSf(String nombreSf);
}
