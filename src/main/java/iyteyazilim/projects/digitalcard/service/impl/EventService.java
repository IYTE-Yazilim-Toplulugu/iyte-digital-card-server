package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.Event;
import iyteyazilim.projects.digitalcard.repository.IEventRepository;
import iyteyazilim.projects.digitalcard.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService {
    @Autowired
    private IEventRepository eventRepository;

    @Override
    public void addEvent(Event event) {

    }

    @Override
    public List<Event> getEvent() {
        return null;
    }

    @Override
    public Event getEvent(Integer id) {
        return null;
    }

    @Override
    public void updateEvent(Integer id, Event event) {

    }

    @Override
    public void deleteEvent(Integer id) {

    }
}
