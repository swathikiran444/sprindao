package info.subbu.Dao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.subbu.Dao.EmployeeDao.EmployeeDao;
import info.subbu.Dao.Entity.Employee;
import info.subbu.Dao.util.MocUtil;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(MocUtil.class);
		EmployeeDao dao = container.getBean(EmployeeDao.class);

		Integer integer = dao.single();
		System.out.println(integer);

		List<Employee> list = dao.getaAllEmployees();
		list.forEach(e -> {
			System.out.println(e.getSname());
			System.out.println(e.getSid());
			System.out.println(e.getSmaks());
		});

//		Integer integer = dao.queryForObject("select count(*) from stu", Integer.class);
//		System.out.println(integer);
	}
}
