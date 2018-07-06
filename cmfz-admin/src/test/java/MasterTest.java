import com.baizhi.cmfz.dao.MasterDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MasterTest {
    @Test
    public void masterTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MasterDao md = (MasterDao) applicationContext.getBean("masterDao");

    }
}
