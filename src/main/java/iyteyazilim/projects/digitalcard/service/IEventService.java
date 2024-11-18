package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.dto.UserDto;
import iyteyazilim.projects.digitalcard.entity.Event;
import iyteyazilim.projects.digitalcard.entity.User;

import java.util.List;

public interface IEventService {
    Event addEvent(Event event);
    List<Event> getEvents();
    Event getEvent(Long id);
    Event updateEvent(Long id, Event event);
    void deleteEvent(Long id);
    void interestedEvent(Long eventId, User user);
    void notInterestedEvent(Long eventId, User user);
    List<UserDto> getUsersInterested(Long eventId);
    List<UserDto> getUsersNotInterested(Long eventId);
}
