package com.java.IndianStateCensusAnalyser;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class CensusAnalyserReadFile {
	public static void readDataLinebyLine() {
		try {
			
		
		FileReader filereader = new FileReader("c:\\users\\dell\\eclipse-workspace\\CensusAnalyser\\src/test/java\txtfile.csv" );
		CSVReader csvReader = new CSVReader(filereader);
		String[] nextRecord;
		{

		while ((nextRecord = csvReader.readNext()) != null) {
			for (String cell : nextRecord) {
				System.out.print(cell + "\t");
			}
			System.out.println("IndianStateCensusData.csv");
		}
		}
		
		} catch (Exception e) {
		e.printStackTrace();
	}	}


		public static void main(String [] args) {
			
			CensusAnalyserReadFile obj  = new CensusAnalyserReadFile();
			obj.readDataLinebyLine();

		
	}	

}
