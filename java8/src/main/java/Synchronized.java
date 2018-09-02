import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;



/**
 * @author huanghaoxing
 */
public class Synchronized {
    public static void main(String[] args) throws Exception {

        Set<Long> longs = new HashSet<>();
        for(int i=0;i<3000;i++){
            int index = RandomUtils.nextInt(100000, 1000000);
            longs.add(((long) (index)));
        }
        FileUtils.write(new File("/data/test.txt"), JSON.toJSONString(longs));

    }


}
