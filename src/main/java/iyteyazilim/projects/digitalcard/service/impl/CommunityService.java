package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.dto.CommunityDto;
import iyteyazilim.projects.digitalcard.entity.Community;
import iyteyazilim.projects.digitalcard.entity.Event;
import iyteyazilim.projects.digitalcard.exception.ResourceNotFoundException;
import iyteyazilim.projects.digitalcard.repository.ICommunityRepository;
import iyteyazilim.projects.digitalcard.service.ICommunityService;
import iyteyazilim.projects.digitalcard.mapper.CommunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService implements ICommunityService {
    @Autowired
    private ICommunityRepository communityRepository;

    @Override
    public CommunityDto addCommunity(Community community) {
        Community savedCommunity = communityRepository.save(community);
        return CommunityMapper.mapToCommmunityDto(savedCommunity);
    }

    @Override
    public Community getCommunity(Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Community doesn't exist with given id : " + id));
        return community;
    }

    @Override
    public List<Community> getCommunities() {
        List<Community> communities = communityRepository.findAll();
        return communities;
    }

    @Override
    public CommunityDto updateCommunity(Long id, Community updatedCommunity) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Community doesn't exist with given id : " + id));

        Community updatedCommunityObj = new Community(community, updatedCommunity);
        updatedCommunityObj = communityRepository.save(updatedCommunityObj);
        return CommunityMapper.mapToCommmunityDto(updatedCommunityObj);
    }

    @Override
    public void deleteCommunity(Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Community doesn't exist with given id : " + id));
        communityRepository.delete(community);
    }

    @Override
    public List<Event> getEventsOfCommunity(Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Community doesn't exist with given id : " + id));
        return community.getEvents();
    }

}