package com.java.IndianStateCensusAnalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resource/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INDIA_STATE_CODE_INCORRECT_FILE_FORMAT = "./src/main/IndiaCensus.csv";
    private static final String INDIA_STATE_CODES_WITH_WRONG_DELIMITER = "./src/main/IndianStateCodesWrongDelimiter.csv";
    private static final String INDIA_STATE_CODES_WITH_INCORRECT_HEADER = "./src/main/IndianStateCodesIncorrectHeader.csv";

    @Test
    public void given_Indian_CensusCSVFile_ShouldReturnsCorrectRecord() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(5,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void given_Indian_CensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }

}
    @Test
    public void givenIndianStateCodeCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(INDIA_CENSUS_CSV_FILE_PATH);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCSVFile_WhenCustomDelimiter_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(INDIA_CENSUS_CSV_FILE_PATH);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADERCENSUS_FILE_PROBLEM, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaStateCodeCSVFile_WhenIncorrectHeader_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(INDIA_STATE_CODES_WITH_INCORRECT_HEADER);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADERCENSUS_FILE_PROBLEM, e.type);
            e.printStackTrace();
        }
    }
}
