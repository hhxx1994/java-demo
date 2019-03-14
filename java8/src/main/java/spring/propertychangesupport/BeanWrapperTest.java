package spring.propertychangesupport;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.List;

/**
 * @author huanghaoxing
 */
public class BeanWrapperTest {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        BeanWrapper beanWrapper = new BeanWrapperImpl(list);
       // beanWrapper.setPropertyValue();


    }
}
