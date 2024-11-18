package iyteyazilim.projects.digitalcard.controller;
import iyteyazilim.projects.digitalcard.entity.Announcement;
import iyteyazilim.projects.digitalcard.service.impl.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/addAnnouncement")
    public ResponseEntity<Announcement> addAnnouncement(@RequestBody Announcement announcement) {
        Announcement addedAnnouncement = announcementService.addAnnouncement(announcement);
        return new ResponseEntity<>(addedAnnouncement, HttpStatus.CREATED);
    }

    @GetMapping("/getAnnouncements")
    public ResponseEntity<List<Announcement>> getAnnouncements() {
        List<Announcement> announcements = announcementService.getAnnouncements();
        return ResponseEntity.ok(announcements);
    }

    @GetMapping("/getAnnouncement/{announcementId}")
    public ResponseEntity<Announcement> getAnnouncement(@PathVariable("announcementId") Long announcementId) {
        Announcement announcement = announcementService.getAnnouncement(announcementId);
        return ResponseEntity.ok(announcement);
    }

    @PutMapping("/updateAnnouncement/{announcementId}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable("announcementId") Long announcementId,
                                                           @RequestBody Announcement updatedAnnouncement) {
        Announcement announcement = announcementService.updateAnnouncement(announcementId, updatedAnnouncement);
        return ResponseEntity.ok(announcement);
    }

    @DeleteMapping("/deleteAnnouncement/{announcementId}")
    public ResponseEntity<String> deleteAnnouncement(@PathVariable("announcementId") Long announcementId) {
            announcementService.deleteAnnouncement(announcementId);
            return ResponseEntity.ok("Announcement deleted successfully.");
        }

    }
