package com.minehotel.App.Services;

import com.minehotel.App.Entity.AppUser;
import com.minehotel.App.Entity.Role;

import java.util.List;

public interface UserCrudServices {

    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void assignUserRole(String roleName, String userEmail);
    AppUser getUserByEmail(String email);
    List<AppUser> getUsers();

}
