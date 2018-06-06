package xin.zachary.nffn.service;

import xin.zachary.nffn.entity.Message;

import java.util.List;

public interface MessageService extends BaseService<Message> {
    List queryChatLog(String sender,String receiver);
}
