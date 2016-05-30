package me.jiangcai.loveport.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 系统字符串
 *
 * @author CJ
 */
@Entity
@Setter
@Getter
public class SystemString {

    @Id
    @Column(length = 30)
    private String id;
    private String value;

}
