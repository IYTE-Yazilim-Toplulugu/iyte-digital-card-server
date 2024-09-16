package iyteyazilim.projects.digitalcard.service.impl;

import iyteyazilim.projects.digitalcard.entity.Admin;
import iyteyazilim.projects.digitalcard.repository.IAdminRepository;
import iyteyazilim.projects.digitalcard.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private IAdminRepository adminRepository;

    @Override
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdmin(Integer id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public boolean authenticateAdmin(String email, String password) {
        Optional<Admin> admin = adminRepository.findByEmailAndPassword(email, password);
        return admin.isPresent();
    }
}
