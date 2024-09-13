package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.Announcement;
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
    public void addAnnouncement(Announcement announcement) {
        announcementRepository.save(announcement);
    }

    @Override
    public List<Announcement> getAnnouncements() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement getAnnouncement(Integer id) {
        return null;
    }

    @Override
    public void updateAnnouncement(Integer id, Announcement announcement) {

    }

    @Override
    public void deleteAnnouncement(Integer id) {

    }
}
