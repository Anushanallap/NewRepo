package com.java.IndianStateCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;



public class CensusAnalyser {

	
	/*UC1*/
	
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();;
            int namOfEateries = 0;
            while (censusCSVIterator.hasNext()) {
                namOfEateries++;
                IndiaCensusCSV censusData = censusCSVIterator.next();
            }
            return namOfEateries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
}
	
	/*UC2*/
	 public int loadIndianStateCode(String csvFilePath) throws CensusAnalyserException {

	        try {

	            if(csvFilePath.contains(".txt")) {
	                throw new CensusAnalyserException("File must be in CSV Format", CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
	            }

	            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
	            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
	            csvToBeanBuilder.withType(IndiaCensusCSV.class);
	            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
	            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
	            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();

	            int numberOfEntries = 0;
	            while(censusCSVIterator.hasNext()) {
	                numberOfEntries++;
	                IndiaCensusCSV censusData = censusCSVIterator.next();
	            }
	            return numberOfEntries;
	        }
	        catch (IOException e) {
	            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
	        }
	        catch(RuntimeException e) {
	            throw new CensusAnalyserException("CSV File Must Have Comma As a delimiter / Has an Incorrect Header", CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADERCENSUS_FILE_PROBLEM);
	        }
	    }
	
	
}
