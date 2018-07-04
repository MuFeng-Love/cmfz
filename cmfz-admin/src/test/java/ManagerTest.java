import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.impl.ManagerServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManagerTest {
    @Test
    public void loginTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ManagerService ms = (ManagerService) applicationContext.getBean("managerServiceImpl");
        ManagerDao managerDao = (ManagerDao) applicationContext.getBean("managerDao");
        //Manager man = ms.queryManagerByName("王晨");
        Manager man = managerDao.selectManagerByName("王晨");
        System.out.println(man);
    }
}
