package ec.bce.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.bce.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
