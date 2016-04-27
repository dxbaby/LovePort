package me.jiangcai.loveport.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * 可登录角色
 *
 * @author CJ
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
public abstract class Login implements UserDetails {

    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_CHARGE = "CHARGE";
    public static final String ROLE_NURSE = "NURSE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean enabled;

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }
}
