package cli;

import com.google.common.collect.Lists;
import com.taobao.middleware.cli.CLI;
import com.taobao.middleware.cli.CLIs;
import com.taobao.middleware.cli.CommandLine;
import com.taobao.middleware.cli.annotations.*;
import org.junit.Test;

import java.util.List;

/**
 * @author huanghaoxing
 */
public class CLITest {

    @Test
    public void test_cli(){
        CLI cli = CLIs.create(CLIAnnotation.class);
        StringBuilder stringBuilder = new StringBuilder();
        cli.usage(stringBuilder);
        System.out.println(stringBuilder);

        List<String> arguments = Lists.newArrayList();
        arguments.add("-n");
        arguments.add("hello");
        arguments.add("-a");
        arguments.add("10");

        CommandLine commandLine = cli.parse(arguments,false);
        CLIAnnotation object = new CLIAnnotation();
        CLIConfigurator.inject(commandLine, object);
        System.out.println(object);

    }


}
