package com.java.IndianStateCensusAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {
	 @CsvBindByName(column = "Srno", required = true)
	    public String Srno;

	    @CsvBindByName(column = "State", required = true)
	    public int State;

	    @CsvBindByName(column = "TIN", required = true)
	    public int TIN;

	    @CsvBindByName(column = "Statecode", required = true)
	    public int Statecode;

	    @Override
	    public String toString() {
	        return "IndiaCensusCSV{" +
	                "Srno='" + Srno + '\'' +
	                ", State='" + State + '\'' +
	                ", TIN='" + TIN + '\'' +
	                ", Statecode='" + Statecode + '\'' +
	                '}';
	    }

}


