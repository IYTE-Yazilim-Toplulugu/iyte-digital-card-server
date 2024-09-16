package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.dto.CommunityLoginDto;
import iyteyazilim.projects.digitalcard.entity.Community;
import iyteyazilim.projects.digitalcard.repository.ICommunityRepository;
import iyteyazilim.projects.digitalcard.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityService implements ICommunityService {
    @Autowired
    private ICommunityRepository communityRepository;

    @Override
    public void addCommunity(Community community) {
        communityRepository.save(community);
    }

    @Override
    public List<Community> getCommunity() {
        return communityRepository.findAll();
    }

    @Override
    public Community getCommunity(Long id) {
        return communityRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCommunity(Long id, Community community) {
        Community existingCommunity = communityRepository.findById(id).orElse(null);
        if (existingCommunity != null) {
            existingCommunity.setName(community.getName());
            existingCommunity.setEmail(community.getEmail());
            communityRepository.save(existingCommunity);
        }
    }

    @Override
    public void deleteCommunity(Long id) {
        communityRepository.deleteById(id);
    }

    @Override
    public boolean isCommunityExist(String email) {
        Optional<Community> community = communityRepository.findByEmail(email);
        return community.isPresent();
    }
    @Override
    public boolean validateWithIyte(CommunityLoginDto communityLoginDto) {
        // İYTE'ye doğrulama isteği göndermek için gerekli kodu buraya ekleyin.
        // Örnek olarak basit bir kontrol:
        return "iyte.edu.tr".equals(communityLoginDto.getEmail().split("@")[1]);
    }

}
