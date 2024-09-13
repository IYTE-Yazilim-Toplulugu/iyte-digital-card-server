package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.Group;

import java.util.List;

public interface IGroupService {
    public void addGroup(Group group);
    public List<Group> getGroup();
    public Group getGroup(Integer id);
    public void updateGroup(Integer id, Group group);
    public void deleteGroup(Integer id);
}
