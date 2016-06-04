package me.jiangcai.loveport.entity;

import lombok.Getter;
import lombok.Setter;
import org.luffy.libs.libseext.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import java.util.Collection;

/**
 * 护士长
 *
 * @author CJ
 */
@Entity
@Setter
@Getter
public class Manager extends Login {
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return CollectionUtils.mutliSet(
                new SimpleGrantedAuthority("ROOT")
                , new SimpleGrantedAuthority(ROLE_MANAGER)
                , new SimpleGrantedAuthority(ROLE_CHARGE)
        );
    }
}
