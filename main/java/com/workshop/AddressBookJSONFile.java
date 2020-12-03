package com.workshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class AddressBookJSONFile {

	private static String jsonFile = "C:\\Users\\sippo\\eclipse-workspace\\Workshop\\src\\addressBook.json";

	private void writeDataIntoJSON() throws IOException {
		// TODO Auto-generated method stub
		Writer writer = Files.newBufferedWriter(Paths.get(jsonFile));
		List<Contacts> listOfContacts = new ArrayList<>();
		listOfContacts.add(
				new Contacts("Sippora", "Toppo", "Abc", "Ranchi", "Jhk", "123001", "9009881019", "sippora@gmail.com"));
		listOfContacts.add(new Contacts("Veena", "Khatari", "Pqr", "Rohtak", "Haryana", "123102", "7799009801",
				"veena@yahoo.com"));
		Gson gson = new Gson();
		String json = gson.toJson(listOfContacts);
		writer.write(json);
		writer.close();
	}

	private void readDataFromJSON() throws IOException, ParseException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(jsonFile));
		Gson gson = new Gson();
		Contacts[] contactInfoArray = gson.fromJson(br, Contacts[].class);
		for (Contacts c : contactInfoArray) {
			System.out.println(c);
		}
	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		AddressBookJSONFile addressBook = new AddressBookJSONFile();
		try {
			addressBook.writeDataIntoJSON();
			addressBook.readDataFromJSON();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
