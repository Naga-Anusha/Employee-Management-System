package org.launchcode.employeemanagementsystem.data;

import org.launchcode.employeemanagementsystem.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
    User findByRole(String role);
}
