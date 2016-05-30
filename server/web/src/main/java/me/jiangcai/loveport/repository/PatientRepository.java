package me.jiangcai.loveport.repository;

import me.jiangcai.loveport.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author CJ
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
