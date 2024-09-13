package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.Community;

import java.util.List;

public interface ICommunityService {
    public void addCommunity(Community community);
    public List<Community> getCommunity();
    public Community getCommunity(Integer id);
    public void updateCommunity(Integer id, Community community);
    public void deleteCommunity(Integer id);
}
