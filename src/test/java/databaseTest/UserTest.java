package databaseTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xin.zachary.nffn.action.UserAction;
import xin.zachary.nffn.daoimpl.UserDAOImpl;
import xin.zachary.nffn.entity.User;
import xin.zachary.nffn.serviceimpl.NewsServiceImpl;
import xin.zachary.nffn.serviceimpl.UserMappingServiceImpl;
import xin.zachary.nffn.serviceimpl.UserPreferenceServiceImpl;
import xin.zachary.nffn.serviceimpl.UserServiceImpl;

import java.io.File;
import java.util.Date;

public class UserTest extends BaseJunit4Test {
    //自动注入
    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private UserMappingServiceImpl userMappingService;

    @Autowired
    private NewsServiceImpl newsService;

    @Autowired
    private UserPreferenceServiceImpl userPereferenceService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserAction userAction;

    @Test
    public void Test(){
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        userDAO= (UserDAOImpl) ctx.getBean("userDAO");
        User user = new User();
        user.setUsername("7");
        user.setPassword("7");
        user.setEmail("12345");
        userDAO.save(user);
        System.out.println("成功了");
    }
    @Test
    public void TestNews(){
        newsService.addNews("E:/sports.json","sports");
        System.out.println("运动导入成功");
        newsService.addNews("E:/business.json","business");
        System.out.println("商业导入成功");
        newsService.addNews("E:/entertainment.json","entertainment");
        System.out.println("娱乐导入成功");
        newsService.addNews("E:/health.json","health");
        System.out.println("健康导入成功");
        newsService.addNews("E:/science.json","science");
        System.out.println("科学导入成功");
        newsService.addNews("E:/technology.json","technology");
        System.out.println("科技导入成功");
    }
    @Test
    public void TestFile(){
        File file =new File("/resources/data.txt");
        if(!file.exists())
            file.mkdir();
        System.out.println(file.getPath());
    }
    @Test
    public void TestWeka(){
        userPereferenceService.changeToWeka();

    }
    //测试匹配数据
    @Test
    public void TestMapping(){
        File file = new File("E:/data.txt");
        double[] type = userMappingService.mapping(file);
        userPereferenceService.updateType(type);
    }
    @Test
    public void addUser(){
        String password2 = "888";
        User user = new User();
        user.setUsername("888");
        user.setPassword("888");
        user.setRegistrationDate(new Date());
        userAction.validateRegister();
    }
}
