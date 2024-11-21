package com.sazid.UserManagement_springBoot.repo;

import com.sazid.UserManagement_springBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
