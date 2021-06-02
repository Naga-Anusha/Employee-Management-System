package org.launchcode.employeemanagementsystem.data;

import org.launchcode.employeemanagementsystem.models.Assignments;
import org.launchcode.employeemanagementsystem.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentsRepository extends CrudRepository<Assignments,Integer> {
    Assignments findByUserId(int userId);
}
