package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.Message;

import java.util.List;

public interface IMessageService {
    public void addMessage(Message message);
    public List<Message> getMessage();
    public Message getMessage(Integer id);
    public void updateMessage(Integer id, Message message);
    public void deleteMessage(Integer id);
}
