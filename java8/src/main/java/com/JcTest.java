package com;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult1;

import java.util.HashMap;
import java.util.Map;



/**
 * @author huanghaoxing
 */
@JCStressTest
@Outcome(id = "2",expect =Expect.ACCEPTABLE ,desc ="all ok")
@Outcome(id = "1",expect =Expect.ACCEPTABLE_INTERESTING ,desc ="thread unSafe")
@Outcome(id = "0",expect =Expect.FORBIDDEN ,desc ="forbiden")
@State
public class JcTest {

    private Map<String,String> map=new HashMap<>();

    @Actor
    public void test_actor1(){
        map.put("hhx", "hello");
    }

    @Actor
    public void test_actor2(){
        map.put("hhxx1994","world");
    }

    @Arbiter
    public void test_arbiter(IntResult1 result1){
        result1.r1=map.size();
    }

}
