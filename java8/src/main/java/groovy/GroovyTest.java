package groovy;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;

public class GroovyTest {

	public static void main(String[] args) throws Exception {
		String path="/Users/huanghaoxing/source/java-demo/java8/src/main/resources/groovy/";
		GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine(path);
		Binding binding=new Binding();
		binding.setVariable("hello","world");
		groovyScriptEngine.run("HelloWorld.groovy",binding);
	}

}
