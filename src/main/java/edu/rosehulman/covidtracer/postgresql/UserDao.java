package edu.rosehulman.covidtracer.postgresql;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}


	public void create(Integer personId, String password, String salt, String role) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO public.\"User\"(\r\n" + 
        		"	\"PersonID\", \"Password\", \"Salt\", \"Role\")\r\n" + 
        		"	VALUES (?, ?, ?, ?);",
                new Object[] { personId, password, salt, role });
	}

	public List<Object> select(String id) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(
                        "SELECT \"PersonID\", \"Password\", \"Salt\", \"Role\", \"ID\"\r\n" + 
                        "	FROM public.\"User\" WHERE \"ID\" = ?;",
                        new Object[] { id },
                        new PersonRowMapper());
	}


	public List<Object> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT \"PersonID\", \"Password\", \"Salt\", \"Role\", \"ID\"\r\n" + 
        		"	FROM public.\"User\";",
                new PersonRowMapper());
	}


	public void deleteAll() {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM public.\"User\"");
	}


	public void delete(String id) {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM public.\"User\" WHERE \"ID\" = ?;",
                new Object[] { id });
	}
}
