package com.khan.app.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khan.app.entity.EmployeeEntity;
@Repository
public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Integer>{

	
	@Modifying
    @Query(value = "INSERT INTO emp_tbl (id, name, dept, salary) VALUES (:id, :name, :dept, :sal)", nativeQuery = true)
	public void saveEml(Integer id,String name, Integer dept, Double sal);
	
	@Modifying
	@Query(value = "UPDATE emp_tbl SET name = :name, dept = :dept, salary = :sal WHERE id = :id", nativeQuery = true)
	void updateEmp(Integer id, String name, Integer dept, Double sal);

	@Modifying
	@Query(value = "DELETE FROM emp_tbl WHERE id = :id", nativeQuery = true)
	void deleteEmpById(Integer id);

}
