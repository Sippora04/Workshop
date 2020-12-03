package com.workshop;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookDataIntoCSVFile {

	private static String csvFilePath = "C:\\Users\\sippo\\eclipse-workspace\\Workshop\\src\\addressBook.csv";

	public void writeDataIntoCSV() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		Writer csvWriter = Files.newBufferedWriter(Paths.get(csvFilePath));
		List<Contacts> listOfContacts = new ArrayList<Contacts>();
		listOfContacts
				.add(new Contacts("Sippora", "Toppo", "Abc", "Ranchi", "Jhk", "123001", "sippora@gmail.com", "9009881019"));
		listOfContacts.add(
				new Contacts("Veena", "Khatari", "Pqr", "Rohtak", "Haryana", "123102", "veena@yahoo.com", "7799009801"));
		ColumnPositionMappingStrategy<Object> mappingStrategy = new ColumnPositionMappingStrategy<Object>();
		mappingStrategy.setType(Contacts.class);
		String[] columns = new String[] { "first_name", "last_name", "address", "city", "state", "zip", "email",
				"phone_no" };
		mappingStrategy.setColumnMapping(columns);
		StatefulBeanToCsvBuilder<Contacts> builder = new StatefulBeanToCsvBuilder<Contacts>(csvWriter);
		StatefulBeanToCsv<Contacts> beanWriter = builder.build();
		beanWriter.write(listOfContacts);
		csvWriter.close();
	}

	public void readDatatFromCSV() throws IOException, CsvException {
		// TODO Auto-generated method stub
		Reader r = Files.newBufferedReader(Paths.get(csvFilePath));
		CSVReader csv_reader = new CSVReader(r);
		String[] record;
		while ((record = csv_reader.readNext()) != null) {
			System.out.println(record[0]+" ");
			System.out.println(record[1]+" ");
			System.out.println(record[2]+" ");
			System.out.println(record[3]+" ");
			System.out.println(record[4]+" ");
			System.out.println(record[5]+" ");
			System.out.println(record[6]+" ");
			System.out.println(record[7]+"\n");
		}
		csv_reader.close();
	}

	public static void main(String[] args) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		AddressBookDataIntoCSVFile addressbook = new AddressBookDataIntoCSVFile();
		try {
			addressbook.writeDataIntoCSV();
			addressbook.readDatatFromCSV();
		} catch (IOException | CsvException e) {
			System.out.println(e);
		}
	}

}
