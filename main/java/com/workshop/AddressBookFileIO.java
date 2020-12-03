package com.workshop;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileIO {
	public static String ADDRESS_BOOK = "C:\\Users\\sippo\\eclipse-workspace\\Workshop\\src\\addressbook-file.txt";

	public void writeDataFileIO(ArrayList<Contacts> person) throws IOException {
		StringBuffer empBuffer = new StringBuffer();
		person.forEach(personInBook -> {
			String personDataString = personInBook.toString().concat("\n");
			empBuffer.append(personDataString);
		});
		try {
			Files.write(Paths.get(ADDRESS_BOOK), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object readData() {
		List<Contacts> person = new ArrayList<>();
		try {
			Files.lines(new File(ADDRESS_BOOK).toPath()).map(line -> line.trim())
					.forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return person;
	}
}