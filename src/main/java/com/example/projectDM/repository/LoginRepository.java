package com.example.projectDM.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.example.projectDM.entity.Login;

public interface LoginRepository extends CrudRepository<Login, Integer>{
	Optional<Login> findByEmail(String email);
}
