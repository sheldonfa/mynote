import com.facade.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/7/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class dubboTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindUserByUserVo(){
        String user = userService.findUserById(1);
        System.out.println(user);
    }
}