package edu.rosehulman.covidtracer.postgresql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Object> {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentResultSetExtractor extractor = new StudentResultSetExtractor();
		return extractor.extractData(rs);
	}

}
