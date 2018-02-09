import java.util.Date;

/**
 * Description:
 *
 * @author huang.hao
 * @since 2018-01-19
 */
public class Inventor {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventor(String name, Date birthday, String no) {
        this.name=name;
    }
}
