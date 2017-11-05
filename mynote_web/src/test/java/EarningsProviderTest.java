import earnings.EarningsProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.earning.EarningService;

/**
 * Created by Administrator on 2016/7/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class EarningsProviderTest {

    @Autowired
    private EarningsProvider earningsProvider;

    @Test
    public void test1(){
        earningsProvider.savePDF("C:\\Users\\Administrator\\Desktop\\科大国创：2016年年度报告.PDF");
    }

}