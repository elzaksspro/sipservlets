package net.java.slee.resource.diameter.rf.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the LCS-Information grouped AVP type.<br>
 * <br>
 * From the Diameter Rf Reference Point Protocol Details (3GPP TS 32.299 V7.1.0) specification:
 * <pre>
 * 7.2.48 LCS-Information AVP 
 * The LCS-Information AVP (AVP code 878) is of type Grouped. Its purpose is to allow the transmission of additional 
 * LCS service specific information elements.
 * 
 * It has the following ABNF grammar:
 *  LCS-Information ::= AVP Header: 878 
 *      [ LCS-Client-ID ] 
 *      [ Location-Type ] 
 *      [ Location-Estimate ] 
 *      [ Positioning-Data ] #exclude
 *      [ IMSI ] #exclude 
 *      [ MSISDN ] #exclude
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface LcsInformation extends GroupedAvp {

  /**
   * Returns the value of the LCS-Client-ID AVP, of type Grouped. A return value of null implies that the AVP has not been set.
   */
  abstract LcsClientId getLcsClientId();

  /**
   * Returns the value of the Location-Estimate AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
   */
  abstract String getLocationEstimate();

  /**
   * Returns the value of the Location-Type AVP, of type Grouped. A return value of null implies that the AVP has not been set.
   */
  abstract LocationType getLocationType();

  /**
   * Returns true if the LCS-Client-ID AVP is present in the message.
   */
  abstract boolean hasLcsClientId();

  /**
   * Returns true if the Location-Estimate AVP is present in the message.
   */
  abstract boolean hasLocationEstimate();

  /**
   * Returns true if the Location-Type AVP is present in the message.
   */
  abstract boolean hasLocationType();

  /**
   * Sets the value of the LCS-Client-ID AVP, of type Grouped.
   */
  abstract void setLcsClientId(LcsClientId lcsClientId);

  /**
   * Sets the value of the Location-Estimate AVP, of type UTF8String.
   */
  abstract void setLocationEstimate(String locationEstimate);

  /**
   * Sets the value of the Location-Type AVP, of type Grouped.
   */
  abstract void setLocationType(LocationType locationType);

}
