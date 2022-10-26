package com.portofio.GMsasiuk.Repository;

import com.portofio.GMsasiuk.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    Optional<Skill> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
