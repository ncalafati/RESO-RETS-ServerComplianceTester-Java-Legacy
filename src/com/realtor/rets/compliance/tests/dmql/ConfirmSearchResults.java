/* $Header$ 
 */
package com.realtor.rets.compliance.tests.dmql;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * DMQL test Evaluator class - Tests DMQL query language Search Transaction
 * response by using user's selections in TestParameters; this class tests a numeric
 * field's value, ensuring it is <= DMQL.System.Decimal.Maximum.Field value from
 * TestParameters.properties 
 * 
 * @author pobrien
 */
public class ConfirmSearchResults extends DMQLResultsSystem {
	
    private static Log log = LogFactory.getLog(ConfirmSearchResults.class);
    
    private final static String FAILURE_NOTES =
        "One or more Search field values had an incorrect numeric value in the response: ";
    
    protected void compareDMQLResults(String transName, String responseBody, 
   		CompactFormatData compactFormatData) {

        if (log.isDebugEnabled()){
            log.debug("* In DMQLSystemNumericResultsMax evaluator class");
            //System.err.println(responseBody);
        }
        

        testResultDesc =
            "Confirms that search result records were returned";
        int count=0;
        try {
          count=  compactFormatData.getDataRowCount();
        } catch (Exception e){

        log.error("ConfirmSearchResults Failed "+e);
            testResultStatus="FAILURE";
            testResultNotes="Could not retrieve a row count from the search response \n\n"+responseBody;

        }
        if (count>0) {
            testResultStatus="SUCCESS";
                        testResultNotes="Search returned "+count+" results. \n\n"+responseBody;


        } else {
            testResultStatus="FAILURE";
            testResultNotes="Search returned no results. \n\n"+responseBody;

        }
    }
}
