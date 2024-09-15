package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.dto.CommunityDto;
import iyteyazilim.projects.digitalcard.entity.Community;
import iyteyazilim.projects.digitalcard.entity.Event;

import java.util.List;

public interface ICommunityService {
    public CommunityDto addCommunity(Community community);
    public List<Community> getCommunities();
    public Community getCommunity(Long id);
    public CommunityDto updateCommunity(Long id, Community community);
    public void deleteCommunity(Long id);
    public List<Event> getEventsOfCommunity(Long id);
}
