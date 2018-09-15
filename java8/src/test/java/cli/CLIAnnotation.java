package cli;

import com.taobao.middleware.cli.annotations.Description;
import com.taobao.middleware.cli.annotations.Name;
import com.taobao.middleware.cli.annotations.Option;
import com.taobao.middleware.cli.annotations.Summary;

@Name("hhx")
@Summary("some short summary.")
@Description("test cli annotation")
 public class CLIAnnotation{

        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        @Option(shortName = "n",longName = "name",required = true)
        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }


        @Option(shortName = "a",longName = "age")
        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "CLIAnnotation{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }