import net.sf.cglib.proxy.*;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author hhx
 * @date 2017/11/5 11:26
 * @description
 */
public class TestCglib {

    class Proxy implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("start");
            proxy.invokeSuper(obj, args);
            System.out.println("end");
            return null;
        }
    }

    public void getName() {
        System.out.println("getName");
    }

    @Test
    public void testCglib() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestCglib.class);
        enhancer.setCallback(new Proxy());
        TestCglib testCglib = (TestCglib) enhancer.create();
        testCglib.getName();

    }



    class Proxy1 implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("proxy1");
            proxy.invokeSuper(obj, args);
            System.out.println(obj.getClass());
            return obj;
        }

    }

    class Proxy2 implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("proxy2");
            proxy.invokeSuper(obj, args);
            System.out.println(obj.getClass());
            return obj;
        }
    }
    class DaoFilter implements CallbackFilter{

        @Override
        public int accept(Method method) {
           if("select".equals(method.getName())){
               return 1;
           }
           return 0;
        }
    }
    @Test
    public void testCglibFilter(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{new Proxy1(),new Proxy2()});
        enhancer.setCallbackFilter(new DaoFilter());
        Dao dao= (Dao) enhancer.create();
        dao.select();
        dao.update();
    }
}
