package com.minehotel.App.Services;

import com.minehotel.App.Entity.AppUser;
import com.minehotel.App.Entity.Role;
import com.minehotel.App.Repository.RoleRepo;
import com.minehotel.App.Repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImplementation implements UserCrudServices{

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    public UserServiceImplementation(UserRepo userRepo,RoleRepo roleRepo){
        this.roleRepo = roleRepo;
        this.userRepo= userRepo;
    }

    @Override
    public AppUser saveUser(AppUser user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void assignUserRole(String roleName, String userEmail) {
        AppUser user = userRepo.findByEmail(userEmail);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public AppUser getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<AppUser> getUsers(String email) {
        return userRepo.findAll();
    }
}
