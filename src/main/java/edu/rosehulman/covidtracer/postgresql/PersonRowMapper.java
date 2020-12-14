package edu.rosehulman.covidtracer.postgresql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Object> {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonResultSetExtractor extractor = new PersonResultSetExtractor();
		return extractor.extractData(rs);
	}

}
