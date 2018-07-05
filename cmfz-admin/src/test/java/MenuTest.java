import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MenuTest {
    @Test
    public void Menutest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuDao md = (MenuDao) applicationContext.getBean("menuDao");
        List<Menu> menus = md.findListMenus();
        for (Menu menu : menus) {
            System.out.println(menu);
            for (Menu menu1 : menu.getChildMenus()) {
                System.out.println("hello");
                System.out.println(menu1);
            }
        }
    }
}
