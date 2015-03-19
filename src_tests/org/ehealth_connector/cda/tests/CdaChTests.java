/********************************************************************************
*
* The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
* Year of publication: 2015
*
********************************************************************************/
package org.ehealth_connector.cda.tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.ehealth_connector.cda.ch.CdaChVacd;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Telecoms;
import org.junit.Before;
import org.junit.Test;

public class CdaChTests extends TestUtils {
  TestUtils t;
  CdaChVacd c;
  
  public CdaChTests () {
    super();
  }

@Before
public void init() {
  t = new TestUtils();

  //Dates
  startDateString = "28.02.2015";
  endDateString = "28.02.2018";

  startDate = DateUtil.date("28.02.2015");
  endDate = DateUtil.date("28.02.2018");

  //Test String with German, French and Italic special characters
  ts1 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
  ts2 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
  ts3 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
  ts4 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
  ts5 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
  numS1 = "1231425352";
  numS2 = "987653";
  number = 121241241.212323;
  telS1 = "+41.32.234.66.77";
  telS2 = "+44.32.234.66.99";

  //Convenience API Types
  code1 = createCode1();
  code2 = createCode2();
  loincCode = new Code("2.16.840.1.113883.6.1", numS1);
  problemCode = new Code("2.16.840.1.113883.6.139", numS2);
  value1 = createValue1();
  value2 = createValue2();
  gtinCode = createGtinCode();  
  id1 = createIdentificator1();
  id2 = createIdentificator2();
  telecoms1 = createTelecoms1();
  name1 = createName1();
  name2 = createName2();
  author1 = createAuthor1();
  author2 = createAuthor2();
  organization1 = createOrganization1();
  address1 = createAddress1();
  
  c = new CdaChVacd();
}
   
  @Test
  public void testLegalAuthenticator() {
    c.setLegalAuthenticator(author1);
    assertTrue(isEqual(author1.getName(), c.getLegalAuthenticator().getName()));
  }
  
  @Test
  public void testTelecoms() {
    Telecoms t = new Telecoms();
    t.addEMail("axel.helmer.job@gmail.com", AddressUse.BUSINESS);
    HashMap<String, AddressUse> h = t.getEMails();
    assertTrue(t.getEMails().containsKey("mailto:axel.helmer.job@gmail.com"));
    assertTrue(t.getEMails().containsValue(AddressUse.BUSINESS));
    t.addEMail("test@test.de", AddressUse.PRIVATE);
    assertTrue(t.getEMails().containsKey("mailto:test@test.de"));
    assertTrue(t.getEMails().containsValue(AddressUse.PRIVATE));
    t.addFax(numS1, AddressUse.BUSINESS);
    t.addFax(numS2, AddressUse.MOBILE);
    assertTrue(t.getFaxes().containsKey("fax:"+numS1));
    assertTrue(t.getFaxes().containsValue(AddressUse.BUSINESS));
    t.addPhone(numS1, AddressUse.BUSINESS);
    t.addPhone(telS1, AddressUse.MOBILE);
    assertTrue(t.getPhones().containsKey("tel:"+telS1));
    assertTrue(t.getPhones().containsValue(AddressUse.MOBILE));
    t.addWebsite("http://"+ts2, AddressUse.BUSINESS);
    t.addWebsite("https://"+numS2, AddressUse.MOBILE);
    assertTrue(t.getWebsites().containsKey("http://"+ts2));
    assertTrue(t.getWebsites().containsValue(AddressUse.MOBILE));
  }
  
  @Test
  public void testAuthor() {
    Author a = new Author();
    a.addAddress(address1);
    a.addAddress(address1);
    a.addId(id1);
    a.addId(id2);
    a.addName(name1);
    a.addName(name2);
    a.setGln(numS1);
    a.setGln(numS2);
  }
}
