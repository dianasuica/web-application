package com.example.proiectPractica.Repository;

import com.example.proiectPractica.Classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByUsername(String username);
}
