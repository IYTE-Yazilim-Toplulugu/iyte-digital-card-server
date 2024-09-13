package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.Event;

import java.util.List;

public interface IEventService {
    public void addEvent(Event event);
    public List<Event> getEvent();
    public Event getEvent(Integer id);
    public void updateEvent(Integer id, Event event);
    public void deleteEvent(Integer id);
}
