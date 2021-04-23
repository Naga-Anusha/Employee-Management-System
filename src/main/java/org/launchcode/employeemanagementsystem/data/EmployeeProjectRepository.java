package org.launchcode.employeemanagementsystem.data;

import org.launchcode.employeemanagementsystem.models.EmployeeProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProjectRepository extends CrudRepository<EmployeeProject,Integer> {
}
