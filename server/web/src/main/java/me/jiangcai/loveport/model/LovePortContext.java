package me.jiangcai.loveport.model;

import lombok.Data;
import me.jiangcai.loveport.entity.Nurse;

/**
 * 操作上下文
 *
 * @author CJ
 */
@Data
public class LovePortContext {

    private Nurse nurse;
    private Iterable<Nurse> nurses;

}
