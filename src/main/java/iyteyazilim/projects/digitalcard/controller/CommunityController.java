package iyteyazilim.projects.digitalcard.controller;

import java.util.List;

import iyteyazilim.projects.digitalcard.entity.Community;
import iyteyazilim.projects.digitalcard.exception.ResourceNotFoundException;
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
import iyteyazilim.projects.digitalcard.entity.Event;
import iyteyazilim.projects.digitalcard.service.impl.CommunityService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/community")
public class CommunityController {

    private CommunityService communityService;

    @PostMapping
    public ResponseEntity<CommunityDto> addCommunity(@RequestBody Community community) {
        CommunityDto addedCommunityDto = communityService.addCommunity(community);
        return new ResponseEntity<>(addedCommunityDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Community>> getCommunities() {
        List<Community> communities = communityService.getCommunities();
        return ResponseEntity.ok(communities);
    }

    @GetMapping("{id}")
    public ResponseEntity<Community> getCommunity(@PathVariable("id") Long id) {
        Community community = communityService.getCommunity(id);
        return ResponseEntity.ok(community);
    }

    @PutMapping("{id}")
    public ResponseEntity<CommunityDto> updateCommunity(@PathVariable("id") Long id,
            @RequestBody Community updatedCommunity) {
        CommunityDto communityDto = communityService.updateCommunity(id, updatedCommunity);
        return ResponseEntity.ok(communityDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCommunity(@PathVariable("id") Long id) {
        try {
        communityService.deleteCommunity(id);
        return ResponseEntity.ok("Community deleted successfully.");
    } catch (ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    }

    @GetMapping("/event/{id}")
    public ResponseEntity<List<Event>> getEventsOfCommunity(@PathVariable("id") Long id) {
        List<Event> events = communityService.getEventsOfCommunity(id);
        return ResponseEntity.ok(events);
    }

}