package me.jiangcai.loveport.repository;

import me.jiangcai.loveport.TestBase;
import me.jiangcai.loveport.entity.Manager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author CJ
 */
public class LoginRepositoryTest extends TestBase {

    @Autowired
    private LoginRepository loginRepository;

    @Test
    public void deleteAndNew() {
        loginRepository.deleteAll();
        assertThat(loginRepository.count()).isEqualTo(0);

        Manager manager = new Manager();

        manager = loginRepository.save(manager);

        assertThat(loginRepository.count()).isEqualTo(1);

        assertThat(loginRepository.findAll().get(0))
                .isEqualTo(manager);
    }

}