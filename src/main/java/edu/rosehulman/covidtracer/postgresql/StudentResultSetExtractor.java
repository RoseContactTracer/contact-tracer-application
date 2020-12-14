package edu.rosehulman.covidtracer.postgresql;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentResultSetExtractor implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Student student = new Student();
		student.setPersonID(rs.getInt(1));
		student.setStudentID(rs.getString(2));
		student.setGreekAffiliation(rs.getString(3));
		Array a = rs.getArray("Athletics");
		student.setAthletics((String[])a.getArray());
		student.setId(rs.getInt(5));
		return student;
	}

}
