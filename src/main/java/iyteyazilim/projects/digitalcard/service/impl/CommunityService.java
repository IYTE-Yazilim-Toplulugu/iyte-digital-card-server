package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.Comment;
import iyteyazilim.projects.digitalcard.entity.Community;
import iyteyazilim.projects.digitalcard.repository.ICommunityRepository;
import iyteyazilim.projects.digitalcard.service.ICommentService;
import iyteyazilim.projects.digitalcard.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService implements ICommunityService {
    @Autowired
    private ICommunityRepository communityRepository;


    @Override
    public void addCommunity(Community community) {

    }

    @Override
    public List<Community> getCommunity() {
        return null;
    }

    @Override
    public Community getCommunity(Integer id) {
        return null;
    }

    @Override
    public void updateCommunity(Integer id, Community community) {

    }

    @Override
    public void deleteCommunity(Integer id) {

    }


}
