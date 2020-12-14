package edu.rosehulman.covidtracer.postgresql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class PersonResultSetExtractor implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Person person = new Person();
		person.setId(rs.getInt(1));
		person.setFirstName(rs.getString(2));
		person.setMiddleName(rs.getString(3));
		person.setLastName(rs.getString(4));
		person.setEmail(rs.getString(5));
		person.setPhone(rs.getString(6));
		person.setResidence(rs.getString(7));
		return person;
	}

}
