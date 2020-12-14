package edu.rosehulman.covidtracer.postgresql;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDao {
	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}


	public void create(Integer personId, String studentId, String greekAffiliation, String[] athletics) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO public.\"Student\"(\r\n" + 
        		"	\"PersonID\", \"StudentID\", \"GreekAffiliation\", \"Athletics\")\r\n" + 
        		"	VALUES (?, ?, ?, ?);",
                new Object[] { personId, studentId, greekAffiliation, athletics });
	}

	public List<Object> select(String id) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(
                        "SELECT \"PersonID\", \"StudentID\", \"GreekAffiliation\", \"Athletics\", \"ID\"\r\n" + 
                        "	FROM public.\"Student\" WHERE \"ID\" = ?;",
                        new Object[] { id },
                        new PersonRowMapper());
	}


	public List<Object> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT \"PersonID\", \"StudentID\", \"GreekAffiliation\", \"Athletics\", \"ID\"\r\n" + 
        		"	FROM public.\"Student\";",
                new PersonRowMapper());
	}


	public void deleteAll() {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM public.\"Student\"");
	}


	public void delete(String id) {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM public.\"Student\" WHERE \"ID\" = ?;",
                new Object[] { id });
	}
}
