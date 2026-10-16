package com.wicky.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wicky.model.Usuario;

// The UserRepository interface extends the JpaRepository interface provided by Spring Data JPA.
// It is responsible for providing CRUD operations and database access methods for the Usuario entity.

public interface UserRepository extends JpaRepository<Usuario, Long> {
}
