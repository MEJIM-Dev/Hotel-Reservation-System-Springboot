package com.minehotel.App.Repository;

import com.minehotel.App.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {

    Role findByName(String rolename);
}
