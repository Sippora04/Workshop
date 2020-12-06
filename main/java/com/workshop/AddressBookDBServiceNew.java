package com.workshop;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class AddressBookDBServiceNew {

	private static AddressBookDBServiceNew addressBookDBServiceNew;

	private AddressBookDBServiceNew() {
	}

	static AddressBookDBServiceNew getInstance() {
		if (addressBookDBServiceNew == null) {
			addressBookDBServiceNew = new AddressBookDBServiceNew();
		}
		return addressBookDBServiceNew;
	}

	public Contacts addContact(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email, String addressBookName, String addressBookType, LocalDate date) {
		Connection connection = null;
		Contacts personInfo = null;
		try {
			connection = AddressBookDBService.getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Statement statement = connection.createStatement()) {
			String sql = String.format(
					"INSERT INTO address_book (address_book_name,address_book_type) VALUES('%s','%s')", addressBookName,
					addressBookType);
			int rowAffected = statement.executeUpdate(sql);
			if (rowAffected == 0)
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println(e + "Cannot insert into address_book");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		try (Statement statement = connection.createStatement()) {
			String sql = String.format("INSERT INTO address_book (first_name,last_name,address,city,state,zip,"
					+ "phone_no,email,address_book_name,date_added) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
					firstName, lastName, address, city, state, zip, phoneNumber, email, addressBookName, date);
			int rowAffected = statement.executeUpdate(sql);
			if (rowAffected == 0)
				throw new SQLException();
			if (rowAffected == 1)
				personInfo = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email,
						addressBookName, addressBookType, date);
		} catch (SQLException e) {
			System.out.println(e + "cannot insert into contact details");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return personInfo;
	}
}
