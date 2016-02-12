package kr.domaindriven.dailybook.record;

import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerry on 2016-02-07.
 */
public class RecordDirect extends AbstractDialect implements IExpressionEnhancingDialect {

    private static final String ExpressionName = "recordsUtil";

    public RecordDirect() {
        super();
    }

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
        Map<String, Object> expressionObjects = new HashMap<String, Object>();
        expressionObjects.put(ExpressionName, new RecordsUtil());
        return expressionObjects;
    }

    @Override
    public String getPrefix() {
        // No attribute or tag processors, so we don't need a prefix at all and
        // we can return whichever value.
        return "RecordDirect";
    }
}
