package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.Message;
import iyteyazilim.projects.digitalcard.repository.IMessageRepository;
import iyteyazilim.projects.digitalcard.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {
    @Autowired
    private IMessageRepository messageRepository;

    @Override
    public void addMessage(Message message) {

    }

    @Override
    public List<Message> getMessage() {
        return null;
    }

    @Override
    public Message getMessage(Integer id) {
        return null;
    }

    @Override
    public void updateMessage(Integer id, Message message) {

    }

    @Override
    public void deleteMessage(Integer id) {

    }
}
