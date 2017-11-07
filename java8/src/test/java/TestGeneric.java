import org.junit.Test;

import java.util.ArrayList;

/**
 * @author hhx
 * 2017/11/7 20:34
 */
public class TestGeneric {
    class MyList<T extends Animal>{
    }
    class Animal{}
    class Cat extends Animal{}
    class Dog extends Animal{}
    class SmallCat extends Cat{}
    @Test
    public void testGeneric(){
       ArrayList<? super Cat> list=new ArrayList<>();
       list.add(new SmallCat());

    }

}
