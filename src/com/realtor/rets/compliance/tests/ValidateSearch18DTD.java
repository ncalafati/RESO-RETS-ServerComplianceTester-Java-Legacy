package com.realtor.rets.compliance.tests;


/**
 * Extends the ValidateDTD and validates against the 1.8 RETS DTD
 * @author pobrien
 */
public class ValidateSearch18DTD extends ValidateDTD {
  /**
   * Creates a new instance of ValidateDTD
   */
  public ValidateSearch18DTD() {
     super();
    setDocTypeLocation("RETS-1.8_DD.dtd");
  }

}
