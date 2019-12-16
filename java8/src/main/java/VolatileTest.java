import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @author huang.hao
 * @since 2018-01-10
 */
public class VolatileTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:application.xml");
        classPathXmlApplicationContext.refresh();
    }


}
