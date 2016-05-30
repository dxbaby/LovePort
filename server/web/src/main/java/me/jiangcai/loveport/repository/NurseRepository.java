package me.jiangcai.loveport.repository;

import me.jiangcai.loveport.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author CJ
 */
public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
