package edu.rosehulman.covidtracer.postgresql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class UserResultSetExtractor implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		User user = new User();
		user.setPersonID(rs.getInt(1));
		user.setPassword(rs.getString(2));
		user.setSalt(rs.getString(3));
		user.setRole(rs.getString(4));
		user.setId(rs.getInt(5));
		return user;
	}

}
