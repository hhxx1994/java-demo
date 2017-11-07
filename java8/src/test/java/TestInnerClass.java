/**
 * @author hhx
 * @date 2017/11/5 16:34
 * @description
 */
public class TestInnerClass {
    class InnerClass{
        private String name;
        public void accessInnerClass(){

        }
    }

    public void testInnerClass(){
        InnerClass innerClass = new InnerClass();
        innerClass.name="hhxx";

    }
}
