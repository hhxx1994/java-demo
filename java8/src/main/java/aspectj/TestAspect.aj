package aspectj;

/**
 * @author huanghaoxing
 */
public aspect TestAspect {

    void around():call(void Hello.sayHello()){
        System.out.println("开始事务...");
        proceed();
        System.out.println("事务结束...");
    }

}
