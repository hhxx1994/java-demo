import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.GregorianCalendar;

/**
 * Description:
 *
 * @author huang.hao
 * @since 2018-01-19
 */
public class SpelTest {

    SpelExpressionParser spelExpressionParser;

    @Before
    public void before() {
        spelExpressionParser = new SpelExpressionParser();
    }

    @Test
    public void spelTest() {
        Expression expression = spelExpressionParser.parseExpression("#item");
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        standardEvaluationContext.setVariable("item", "100");
        System.out.println(expression.getValue(standardEvaluationContext));
    }

    @Test
    public void testParser() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

        //  The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name == 'Nikola Tesla'");
        EvaluationContext context = new StandardEvaluationContext(tesla);
        System.out.println(exp.getValue(context, Boolean.class));

        Expression exp2 = parser.parseExpression("name");
        exp2.setValue(context, "hhx");
        String value = exp2.getValue(context, String.class);
        System.out.println(value);

    }

}
