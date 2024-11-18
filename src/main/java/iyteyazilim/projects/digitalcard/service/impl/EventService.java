package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.dto.UserDto;
import iyteyazilim.projects.digitalcard.entity.Event;
import iyteyazilim.projects.digitalcard.entity.User;
import iyteyazilim.projects.digitalcard.mapper.UserMapper;
import iyteyazilim.projects.digitalcard.exception.ResourceNotFoundException;
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
    public Event addEvent(Event event) {
        Event savedEvent = eventRepository.save(event);
        return savedEvent;
    }

    @Override
    public Event getEvent(Long id) {
        Event event = eventRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Event doesn't exist with given id : " + id));
        return event;
    }

    @Override
    public List<Event> getEvents() {
        List<Event> events = eventRepository.findAll();
        return events;
    }

    @Override
    public Event updateEvent(Long id, Event updatedEvent) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event doesn't exist with given id : " + id));

        Event updatedEventObj = new Event(event, updatedEvent);
        updatedEventObj = eventRepository.save(updatedEventObj);
        return updatedEventObj;

    }

    @Override
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event doesn't exist with given id : " + id));
        eventRepository.delete(event);
    }

    @Override
    public void interestedEvent(Long eventId, User user) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event doesn't exist with given id : " + eventId));
        UserDto userDto = UserMapper.mapToUserDto(user);
        event.getInterestedUsers().add(userDto);
        eventRepository.save(event);
    }

    @Override
    public void notInterestedEvent(Long eventId, User user) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event doesn't exist with given id : " + eventId));
        UserDto userDto = UserMapper.mapToUserDto(user);
        event.getNotInterestedUsers().add(userDto);
        eventRepository.save(event);
    }

    @Override
    public List<UserDto> getUsersInterested(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event doesn't exist with given id : " + eventId));
        return event.getInterestedUsers();
    }

    @Override
    public List<UserDto> getUsersNotInterested(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event doesn't exist with given id : " + eventId));
        return event.getNotInterestedUsers();
    }

}
