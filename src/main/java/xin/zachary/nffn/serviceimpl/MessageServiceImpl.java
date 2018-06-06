package xin.zachary.nffn.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zachary.nffn.daoimpl.MessageDAOImpl;
import xin.zachary.nffn.entity.Message;
import xin.zachary.nffn.service.MessageService;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {

    @Autowired
    private MessageDAOImpl messageDAO;

    //输入发送者和接收者的用户名，查询两人的聊天记录
    @Override
    public List queryChatLog(String sender, String receiver) {
        return messageDAO.queryChatLog(sender,receiver);
    }
}
