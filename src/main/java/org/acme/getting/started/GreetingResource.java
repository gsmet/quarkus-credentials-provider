package org.acme.getting.started;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.agroal.api.AgroalDataSource;

@Path("/hello")
public class GreetingResource {

	@Inject
	AgroalDataSource myDataSource;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		try (Connection connection = myDataSource.getConnection()) {
			Statement statement = connection.createStatement();
			try (ResultSet resultSet = statement.executeQuery("SELECT 1")) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "hello";
	}
}