package com.org.HomeLoan.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import com.org.HomeLoan.dto.LoanRepayment;

public class CSVHelper {
	
	public static ByteArrayInputStream repaymentToCSV(List<LoanRepayment> repayments) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	    	for (LoanRepayment repayment : repayments) {
	    		List<String> data = Arrays.asList(
	    				String.valueOf(repayment.getRepaymentId()),
	    				String.valueOf(repayment.getPrincipalAmount()),
	    				String.valueOf(repayment.getInterest()),
	    				String.valueOf(repayment.getOutstanding())
	            );
	    		csvPrinter.printRecord(data);
	      }
	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	}
	
}
