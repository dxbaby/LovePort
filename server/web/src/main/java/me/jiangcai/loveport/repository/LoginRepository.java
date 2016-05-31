package me.jiangcai.loveport.repository;

import me.jiangcai.loveport.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author CJ
 */
public interface LoginRepository extends JpaRepository<Login, Long> {

    /**
     * @param name 用户名
     * @return 用户 或者 null
     */
    Login findByUsername(String name);

}
