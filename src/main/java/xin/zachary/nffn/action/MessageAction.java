package xin.zachary.nffn.action;

import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport {

    //传入一个想发送的用户名和内容，生成一条留言，自己的用户名在session中找
    public String addMessage(){
        return null;
    }

    //传入一个自己的用户名，得到该用户的作为发送者得到的信息
    public String showSendMessge(){
        return null;
    }

    //传入一个自己的用户名，得到该用户作为接受者得到的信息
    public String showReceiveMessage(){
        return null;
    }
}
