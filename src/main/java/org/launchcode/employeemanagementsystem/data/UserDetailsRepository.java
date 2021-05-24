package org.launchcode.employeemanagementsystem.data;

import org.launchcode.employeemanagementsystem.models.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails,Integer> {

}
