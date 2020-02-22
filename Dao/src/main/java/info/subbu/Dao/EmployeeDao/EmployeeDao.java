package info.subbu.Dao.EmployeeDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import info.subbu.Dao.Entity.Employee;

@Repository
public class EmployeeDao extends JdbcTemplate {
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public EmployeeDao(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

// for single query
	public Integer single() {
		String sql = "select count(*) from stu";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

//list of employees print
	public List<Employee> getaAllEmployees() {
		String sql = "select * from stu";
		return jdbcTemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setSid(rs.getInt("sid"));
				emp.setSname(rs.getString("sname"));
				emp.setSmaks(rs.getDouble("smarks"));
				return emp;
			}
		});

	}

}
