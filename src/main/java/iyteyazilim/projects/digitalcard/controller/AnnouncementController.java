package iyteyazilim.projects.digitalcard.controller;

import iyteyazilim.projects.digitalcard.entity.Announcement;
import iyteyazilim.projects.digitalcard.service.impl.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/addAnnouncement")
    public String addAnnouncement(@RequestBody Announcement announcement) {
        announcementService.addAnnouncement(announcement);
        return "Success";
    }

    @GetMapping("/getAnnouncements")
    public List<Announcement> getAnnouncements() {
        return announcementService.getAnnouncements();
    }
}
