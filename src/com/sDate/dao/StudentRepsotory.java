package com.sDate.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sDate.model.Student;
/***
 * 继承接口2种方式
 * 1.Repository泛型
 * 2.@RepositoryDefinition注解
 * @RepositoryDefinition(domainClass=Student.class,idClass=Integer.class)
 * @author HTLF0
 *
 */
//@RepositoryDefinition(domainClass=Student.class,idClass=Integer.class)
public interface StudentRepsotory extends CrudRepository<Student, Integer>{
	
	Student getByName(String name);
	
	/*//级联属性
	List<Student> getByAddressIdGreaterThen(Integer id);*/
	
	@Query(value="select count(id) from jpa_student",nativeQuery=true)
	Long getTotalCount();
	
	@Modifying
	@Query("update student s set s.email=:email where id=:id")
	void updateStudentEmail(@Param("id") Integer id ,@Param("name") String email);
	
}
