package me.jiangcai.loveport.entity;

import lombok.Getter;
import lombok.Setter;
import me.jiangcai.loveport.DisplayableImage;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
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
public abstract class Login implements UserDetails, DisplayableImage {

    public static final String DEFAULT_IMAGE_PATH = "logged_user.png";

    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_CHARGE = "CHARGE";
    public static final String ROLE_NURSE = "NURSE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 36)
    private String username;
    /**
     * 头像资源Path
     */
    private String imagePath = DEFAULT_IMAGE_PATH;
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
