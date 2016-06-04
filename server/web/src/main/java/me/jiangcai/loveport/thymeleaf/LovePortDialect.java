package me.jiangcai.loveport.thymeleaf;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.Collections;
import java.util.Set;

/**
 * @author CJ
 */
@Component
public class LovePortDialect extends AbstractDialect implements IProcessorDialect {

    public LovePortDialect() {
        super("LovePort");
    }

//    IExpressionObjectDialect
//    @Override
//    public IExpressionObjectFactory getExpressionObjectFactory() {
//        return new IExpressionObjectFactory() {
//            @Override
//            public Set<String> getAllExpressionObjectNames() {
//                return null;
//            }
//
//            @Override
//            public Object buildObject(IExpressionContext context, String expressionObjectName) {
//                return null;
//            }
//
//            @Override
//            public boolean isCacheable(String expressionObjectName) {
//                return false;
//            }
//        };
//    }

    @Override
    public String getPrefix() {
        return "lp";
    }

    @Override
    public int getDialectProcessorPrecedence() {
        return 0;
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        return Collections.emptySet();
    }
}
