import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class pictureTest {
    @Test
    public void PictureTest(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PictureService ps = (PictureService) app.getBean("pictureServiceImpl");
        Picture pic = new Picture();
        pic.setPictureId("8");
        pic.setPicturePath("2.jpg");
        pic.setPictureDescription("好看");
        pic.setPictureStatus("不展示");

        System.out.println(ps.addPicture(pic));
    }
}
