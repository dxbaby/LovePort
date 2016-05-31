package me.jiangcai.loveport.service;

import me.jiangcai.lib.bracket.auth.AuthenticateService;
import me.jiangcai.loveport.entity.Charge;
import me.jiangcai.loveport.entity.Login;
import me.jiangcai.loveport.entity.Manager;
import me.jiangcai.loveport.entity.Nurse;
import me.jiangcai.loveport.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Jolene
 */
@Service
public class LoginService implements AuthenticateService<Login> {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Login loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByUsername(username);
        if (login == null)
            throw new UsernameNotFoundException(username);
        return login;
    }

    @Override
    public Login changePassword(Login user, String rawPassword) {
        user.setPassword(passwordEncoder.encode(rawPassword));

        return loginRepository.save(user);
    }

    @Override
    public Login createUser(boolean random, String... roles) {
        Login login;
        switch (roles[0]) {
            case Login.ROLE_MANAGER:
                login = new Manager();
                break;
            case Login.ROLE_CHARGE:
                login = new Charge();
                break;
            case Login.ROLE_NURSE:
                login = new Nurse();
                break;
            default:
                throw new IllegalArgumentException("unknown role:" + roles[0]);
        }

        login.setEnabled(true);
        if (random) {
            login.setUsername(UUID.randomUUID().toString());
        }
        return loginRepository.save(login);
    }
}
