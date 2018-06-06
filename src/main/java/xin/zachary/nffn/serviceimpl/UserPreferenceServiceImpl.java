package xin.zachary.nffn.serviceimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.nffn.daoimpl.UserPreferenceDAOImpl;
import xin.zachary.nffn.entity.UserPreference;
import xin.zachary.nffn.service.UserPreferenceService;

import javax.xml.ws.Action;
import java.io.*;
import java.util.List;

@Service("userPreferenceService")
public class UserPreferenceServiceImpl extends BaseServiceImpl<UserPreference> implements UserPreferenceService {

    private UserPreference userPreference=new UserPreference();
    @Autowired
    private UserPreferenceDAOImpl userPreferenceDAO;

    @Override
    public boolean cluster() {
        return false;
    }


    //文件地址以后再修改
    @Override
    public boolean changeToWeka() {
        List list = this.queryAll();
        System.out.println("查询到的数据大小"+list.size());
        try {
            OutputStream os = new FileOutputStream("E:/data.txt");
            OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bufr = new BufferedWriter(osw);
            //写weka头的部分
            String line = "@RELATION data";
            bufr.write(line+"\r\n");
            line="@ATTRIBUTE character REAL ";
            bufr.write(line+"\r\n");
            line="@ATTRIBUTE business REAL ";
            bufr.write(line+"\r\n");
            line="@ATTRIBUTE entertainment REAL ";
            bufr.write(line+"\r\n");
            line="@ATTRIBUTE health REAL ";
            bufr.write(line+"\r\n");
            line="@ATTRIBUTE science REAL ";
            bufr.write(line+"\r\n");
            line="@ATTRIBUTE sports REAL ";
            bufr.write(line+"\r\n");
            line="@ATTRIBUTE technology REAL ";
            bufr.write(line+"\r\n");
            bufr.write("@DATA\r\n");

            //写要聚类的主要数据
            for (int i = 0; i < list.size(); i++) {
                userPreference= (UserPreference) list.get(i);
                bufr.write(userPreference.getCharactor()+" "+userPreference.getBusiness()+" "+userPreference.getEntertainment()+
                " "+userPreference.getHealth()+" "+userPreference.getScience()+" "+userPreference.getSports()+" "+userPreference.getTechnology()+
                " \r\n");
                bufr.flush();
            }
            bufr.close();
            osw.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateType(double[] type) {
        List list = this.queryAll();
        for (int i = 0; i < list.size(); i++) {
            userPreference = (UserPreference) list.get(i);
            userPreference.setType((int) type[i]);
            this.update(userPreference);
        }
        return false;
    }

    @Override
    @Transactional
    public List queryTypeByUsername(String username) {
        return userPreferenceDAO.queryTypeByUsername(username);
    }


    public List queryAll(){
        return userPreferenceDAO.queryAll();
    }

}
