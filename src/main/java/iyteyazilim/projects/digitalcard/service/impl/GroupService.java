package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.Group;
import iyteyazilim.projects.digitalcard.repository.IGroupRepository;
import iyteyazilim.projects.digitalcard.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private IGroupRepository groupRepository;

    @Override
    public void addGroup(Group group) {

    }

    @Override
    public List<Group> getGroup() {
        return null;
    }

    @Override
    public Group getGroup(Integer id) {
        return null;
    }

    @Override
    public void updateGroup(Integer id, Group group) {

    }

    @Override
    public void deleteGroup(Integer id) {

    }
}
