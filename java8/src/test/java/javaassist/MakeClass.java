package javaassist;

import javassist.ClassPool;
import javassist.CtClass;
import org.junit.Test;

/**
 * @author huanghaoxing
 */
public class MakeClass {

    @Test
    public void test_makeClass(){
        ClassPool pool = ClassPool.getDefault();
        CtClass newClass = pool.makeClass("javaassist.NewClass");
       // newClass.addMethod();
    }
}
