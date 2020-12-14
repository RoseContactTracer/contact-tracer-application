package edu.rosehulman.covidtracer.postgresql;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDao {
	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}


	public void create(String firstName, String middleName, String lastName, String email, String phone, String residence) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO public.\"Person\"(\r\n" + 
        		"	\"First Name\", \"Middle Name\", \"Last Name\", \"Email\", \"Phone\", \"Residence\")\r\n" + 
        		"	VALUES (?, ?, ?, ?, ?, ?, ?);",
                new Object[] { firstName, middleName, lastName, email,  phone, residence});
	}

	public List<Object> select(String id) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query(
                        "SELECT \"ID\", \"First Name\", \"Middle Name\", \"Last Name\", \"Email\", \"Phone\", \"Residence\"\r\n" + 
                        "	FROM public.\"Person\" WHERE \"ID\" = ?;",
                        new Object[] { id },
                        new PersonRowMapper());
	}


	public List<Object> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT \"ID\", \"First Name\", \"Middle Name\", \"Last Name\", \"Email\", \"Phone\", \"Residence\"\r\n" + 
        		"	FROM public.\"Person\";",
                new PersonRowMapper());
	}


	public void deleteAll() {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM public.\"Person\";");
	}


	public void delete(String id) {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM public.\"Person\" WHERE \"ID\" = ?;",
                new Object[] { id });
	}

}
