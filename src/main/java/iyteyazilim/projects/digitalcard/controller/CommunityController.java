package iyteyazilim.projects.digitalcard.controller;

import java.util.List;

import iyteyazilim.projects.digitalcard.entity.Community;
import iyteyazilim.projects.digitalcard.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iyteyazilim.projects.digitalcard.dto.CommunityDto;
import iyteyazilim.projects.digitalcard.dto.UserDto;
import iyteyazilim.projects.digitalcard.entity.Event;
import iyteyazilim.projects.digitalcard.entity.User;
import iyteyazilim.projects.digitalcard.service.impl.CommunityService;
import iyteyazilim.projects.digitalcard.service.impl.EventService;

@RestController
@RequestMapping("/api/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;
    @Autowired
    private EventService eventService;

    @PostMapping("/createCommunity")
    public ResponseEntity<CommunityDto> addCommunity(@RequestBody Community community) {
        CommunityDto addedCommunityDto = communityService.addCommunity(community);
        return new ResponseEntity<>(addedCommunityDto, HttpStatus.CREATED);
    }

    @GetMapping("/getCommunities")
    public ResponseEntity<List<Community>> getCommunities() {
        List<Community> communities = communityService.getCommunities();
        return ResponseEntity.ok(communities);
    }

    @GetMapping("/getCommunity/{communityId}")
    public ResponseEntity<Community> getCommunity(@PathVariable("communityId") Long communityId) {
        Community community = communityService.getCommunity(communityId);
        return ResponseEntity.ok(community);
    }

    @PutMapping("updateCommunity/{communityId}")
    public ResponseEntity<CommunityDto> updateCommunity(@PathVariable("communityId") Long communityId,
            @RequestBody Community updatedCommunity) {
        CommunityDto communityDto = communityService.updateCommunity(communityId, updatedCommunity);
        return ResponseEntity.ok(communityDto);
    }

    @DeleteMapping("deleteCommunity/{communityId}")
    public ResponseEntity<String> deleteCommunity(@PathVariable("communityId") Long communityId) {
        try {
        communityService.deleteCommunity(communityId);
        return ResponseEntity.ok("Community deleted successfully.");
    } catch (ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
    @GetMapping("/getEvents/{communityId}")
    public ResponseEntity<List<Event>> getEventsOfCommunity(@PathVariable("communityId") Long communityId) {
        List<Event> events = communityService.getEventsOfCommunity(communityId);
        return ResponseEntity.ok(events);
    }

    @PostMapping("/event/createEvent")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event addedEvent = eventService.addEvent(event);
        return new ResponseEntity<>(addedEvent, HttpStatus.CREATED);
    }

    @GetMapping("/event/getEvents")
    public ResponseEntity<List<Event>> getEvents() {
        List<Event> events = eventService.getEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/event/getEvent/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable("eventId") Long eventId) {
        Event event = eventService.getEvent(eventId);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/event/updateEvent/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable("eventId") Long eventId, @RequestBody Event updatedEvent) {
        Event event = eventService.updateEvent(eventId, updatedEvent);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/event/interestedEvent/{event_id}")
    public ResponseEntity<Void> interestedEvent(@PathVariable("event_id") Long eventId, @RequestBody User user) {
        eventService.interestedEvent(eventId, user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/event/notInterestedEvent/{event_id}")
    public ResponseEntity<Void> notInterestedEvent(@PathVariable("event_id") Long eventId, @RequestBody User user) {
        eventService.notInterestedEvent(eventId, user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/event/getUsersInterested/{event_id}")
    public ResponseEntity<List<UserDto>> getUsersInterested(@PathVariable("event_id") Long eventId) {
        List<UserDto> users = eventService.getUsersInterested(eventId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/event/getUsersNotInterested/{event_id}")
    public ResponseEntity<List<UserDto>> getUsersNotInterested(@PathVariable("event_id") Long eventId) {
        List<UserDto> users = eventService.getUsersNotInterested(eventId);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/event/deleteEvent/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable("eventId") Long eventId) {
        try {
            eventService.deleteEvent(eventId);
            return ResponseEntity.ok("Event deleted successfully.");
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    
}