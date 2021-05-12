package org.launchcode.employeemanagementsystem.data;

import org.launchcode.employeemanagementsystem.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer> {
}
