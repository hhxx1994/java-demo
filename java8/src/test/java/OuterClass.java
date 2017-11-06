/**
 * @author hhx
 * 2017/11/5 23:44
 */
public class OuterClass {

    public void access(){
        TestInnerClass.InnerClass innerClass = new TestInnerClass().new InnerClass();
        innerClass.accessInnerClass();
    }
}
