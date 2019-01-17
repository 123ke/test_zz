package com.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sDate.dao.StudentRepsotory;
import com.sDate.dao.StudentService;
import com.sDate.model.Student;

public class SDataTest {
	
	private ApplicationContext ctx=null;
	private StudentRepsotory studentRepsotory=null;
	private StudentService studentService;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		studentRepsotory=ctx.getBean(StudentRepsotory.class);
		studentService=ctx.getBean(StudentService.class);
	}
	
	@Test
	public void testTable(){}

	@Test
	public void testDateSource() throws SQLException {
		DataSource dataSource=ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void testHelloWordsDate(){
		  
		Student student=studentRepsotory.getByName("yangke");
		System.out.println(student);
	}
	@Test
	public void testNativeQuery(){
		Long count=studentRepsotory.getTotalCount();
		System.out.println(count);
	}
	
	/*@Test
	public void testModifying(){
		studentService.updateStudentEmail("1784473397@qq.com", 1);
	}*/
	@Test
	public void testCrudReposiory(){
		List<Student> stuList=new ArrayList<Student>();
		for(int i='a';i<='z';i++){
			Student s=new Student();
			s.setAddressId(i+1);
			s.setBrith(new Date());
			s.setEmail((char)i+""+(char)i+"@qq.com");
			s.setName((char)i+""+(char)i);
			stuList.add(s);
		}
		studentService.saveStudent(stuList);
	}
}
