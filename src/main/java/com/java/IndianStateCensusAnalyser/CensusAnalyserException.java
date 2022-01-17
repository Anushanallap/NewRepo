package com.java.IndianStateCensusAnalyser;

/*uc1 & uc2*/

public class CensusAnalyserException extends Exception{
	  enum ExceptionType {
	        CENSUS_FILE_PROBLEM, CENSUS_WRONG_DELIMITER_OR_WRONG_HEADERCENSUS_FILE_PROBLEM, CENSUS_INCORRECT_FILE_FORMAT
	        
	   }

	    ExceptionType type;

	    public CensusAnalyserException(String message, ExceptionType type) {
	        super(message);
	        this.type = type;
	    }

	    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
	        super(message, cause);
	        this.type = type;
	    }
	
	    

	    

}
