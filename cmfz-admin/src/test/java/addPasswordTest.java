import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class addPasswordTest {
    @Test
    public void passwordTest(){
        Md5Hash string = new Md5Hash("123456", "123aderze", 1024);
        System.out.println(string);
    }
}
