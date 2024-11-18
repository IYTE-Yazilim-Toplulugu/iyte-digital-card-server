package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.Announcement;
import iyteyazilim.projects.digitalcard.exception.ResourceNotFoundException;
import iyteyazilim.projects.digitalcard.repository.IAnnouncementRepository;
import iyteyazilim.projects.digitalcard.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService implements IAnnouncementService {
    @Autowired
    private IAnnouncementRepository announcementRepository;

    @Override
    public Announcement addAnnouncement(Announcement announcement) {
        Announcement addedAnnouncement = announcementRepository.save(announcement);
        return addedAnnouncement;
    }

    @Override
    public List<Announcement> getAnnouncements() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement getAnnouncement(Long id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement doesn't exist with given id : " + id));
        return announcement;
    }

    @Override
    public Announcement updateAnnouncement(Long id, Announcement updatedAnnouncement) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement doesn't exist with given id : " + id));
        Announcement updatedannouncementObj = new Announcement(announcement, updatedAnnouncement);
        updatedannouncementObj = announcementRepository.save(updatedannouncementObj);
        return updatedannouncementObj;
    }

    @Override
    public void deleteAnnouncement(Long id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement doesn't exist with given id : " + id));
        announcementRepository.delete(announcement);

    }
}
