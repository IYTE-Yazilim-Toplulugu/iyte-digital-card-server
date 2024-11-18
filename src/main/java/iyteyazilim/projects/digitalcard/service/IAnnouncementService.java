package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.Announcement;

import java.util.List;

public interface IAnnouncementService {
    public Announcement addAnnouncement(Announcement announcement);
    public List<Announcement> getAnnouncements();
    public Announcement getAnnouncement(Long id);
    public Announcement updateAnnouncement(Long id, Announcement announcement);
    public void deleteAnnouncement(Long id);
}
