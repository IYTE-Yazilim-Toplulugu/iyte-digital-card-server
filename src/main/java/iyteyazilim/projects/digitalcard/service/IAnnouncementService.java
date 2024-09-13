package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.Announcement;

import java.util.List;

public interface IAnnouncementService {
    public void addAnnouncement(Announcement announcement);
    public List<Announcement> getAnnouncements();
    public Announcement getAnnouncement(Integer id);
    public void updateAnnouncement(Integer id, Announcement announcement);
    public void deleteAnnouncement(Integer id);
}
