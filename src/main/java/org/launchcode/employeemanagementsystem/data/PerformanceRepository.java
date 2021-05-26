package org.launchcode.employeemanagementsystem.data;

import org.launchcode.employeemanagementsystem.models.Performance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends CrudRepository<Performance,Integer> {
}