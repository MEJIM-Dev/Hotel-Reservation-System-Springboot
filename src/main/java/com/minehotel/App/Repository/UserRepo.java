package com.minehotel.App.Repository;

import com.minehotel.App.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByEmail(String email);
}
