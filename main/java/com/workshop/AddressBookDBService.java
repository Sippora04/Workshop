package com.workshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {

	private static AddressBookDBService addressBookDBService;

	private AddressBookDBService() {
	}

	static AddressBookDBService getInstance() {
		if (addressBookDBService == null) {
			addressBookDBService = new AddressBookDBService();
		}
		return addressBookDBService;
	}

	public Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_database?useSSL=false";
		String userName = "root";
		String password = "admin123";
		;
		Connection connection;
		System.out.println("connecting to database: " + jdbcURL);
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("connection successful !!!! " + connection);
		return connection;
	}

	public List<Contacts> readData() {
		String sql = "SELECT * FROM address_book;";
		return this.getContactDetailsUsingSqlQuery(sql);
	}

	private List<Contacts> getContactDetailsUsingSqlQuery(String sql) {
		List<Contacts> ContactList = null;
		try (Connection connection = addressBookDBService.getConnection();) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery(sql);
			ContactList = this.getAddressBookData(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ContactList;
	}

	private List<Contacts> getAddressBookData(ResultSet result) {
		List<Contacts> contactList = new ArrayList<>();
		try {
			while (result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String address = result.getString("address");
				String city = result.getString("city");
				String state = result.getString("state");
				String zip = result.getString("zip");
				String phoneNumber = result.getString("phone_no");
				String email = result.getString("email");
				// String addressBookName = result.getString("address_book_name");
				// String addressBookType = result.getString("address_book_type");
				contactList.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactList;
	}
}