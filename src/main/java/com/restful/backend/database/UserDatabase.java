package com.restful.backend.database;

/**
 * Decalaración de base de datos de JPA.
 * @author Agustín Dye
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.restful.backend.model.User;

@Repository
public interface UserDatabase extends JpaRepository<User, Long>{

}

