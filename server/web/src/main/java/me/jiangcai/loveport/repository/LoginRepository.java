package me.jiangcai.loveport.repository;

import me.jiangcai.loveport.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author CJ
 */
public interface LoginRepository extends JpaRepository<Login, Long> {
}
