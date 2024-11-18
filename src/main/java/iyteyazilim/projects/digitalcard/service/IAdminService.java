package iyteyazilim.projects.digitalcard.service;

import iyteyazilim.projects.digitalcard.entity.Admin;

import java.util.List;

public interface IAdminService {
    void addAdmin(Admin admin);
    List<Admin> getAdmins();
    Admin getAdmin(Integer id);
    boolean authenticateAdmin(String email, String password);
}
