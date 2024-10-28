package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.dto.CommunityLoginDto;
import iyteyazilim.projects.digitalcard.entity.Community;

import java.util.List;

public interface ICommunityService {
    void addCommunity(Community community);
    List<Community> getCommunity();
    Community getCommunity(Long id);
    void updateCommunity(Long id, Community community);
    void deleteCommunity(Long id);

    boolean isCommunityExist(String email); // Topluluk giriş doğrulaması
    boolean validateWithIyte(CommunityLoginDto communityLoginDto);
}
