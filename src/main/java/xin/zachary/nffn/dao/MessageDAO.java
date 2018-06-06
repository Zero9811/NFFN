package xin.zachary.nffn.dao;

import xin.zachary.nffn.entity.Message;

import java.util.List;

public interface MessageDAO extends BaseDAO<Message>{
    List queryChatLog(String sender, String receiver);
}
