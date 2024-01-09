package com.myprojects.botilleria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myprojects.botilleria.models.UserLogin;


public interface IUserRepository extends JpaRepository<UserLogin,Long>{

	UserLogin findByUser(String user);
}

