package net.java.slee.resource.diameter.rf.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the PS-Furnish-Charging-Information grouped AVP type.<br>
 * <br>
 * From the Diameter Rf Reference Point Protocol Details (3GPP TS 32.299 V7.1.0) specification: 
 * <pre>
 * 7.2.86 PS-Furnish-Charging-Information AVP 
 * The PS-Furnish-Charging-Information AVP (AVP code 865) is of type Grouped. Its purpose is to add online charging
 * session specific information, received via the Ro reference point, onto the Rf reference point in order to 
 * facilitate its inclusion in CDRs.
 * This information element may be received in a CCA message via the Ro reference point. In situations where online and
 * offline charging are active in parallel, the information element is transparently copied into an ACR to be sent on
 * the Rf reference point.
 * 
 * It has the following ABNF grammar: 
 *  PS-Furnish-Charging-Information ::= AVP Header: 865 
 *      { TGPP-Charging-Id }
 *      { PS-Free-Format-Data } 
 *      [ PS-Append-Free-Format-Data ]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface PsFurnishChargingInformation extends GroupedAvp {

  /**
   * Returns the value of the PS-Append-Free-Format-Data AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
   */
  abstract PsAppendFreeFormatData getPsAppendFreeFormatData();

  /**
   * Returns the value of the PS-Free-Format-Data AVP, of type OctetString. A return value of null implies that the AVP has not been set.
   */
  abstract String getPsFreeFormatData();

  /**
   * Returns the value of the TGPP-Charging-Id AVP, of type OctetString. A return value of null implies that the AVP has not been set.
   */
  abstract String getTgppChargingId();

  /**
   * Returns true if the PS-Append-Free-Format-Data AVP is present in the message.
   */
  abstract boolean hasPsAppendFreeFormatData();

  /**
   * Returns true if the PS-Free-Format-Data AVP is present in the message.
   */
  abstract boolean hasPsFreeFormatData();

  /**
   * Returns true if the TGPP-Charging-Id AVP is present in the message.
   */
  abstract boolean hasTgppChargingId();

  /**
   * Sets the value of the PS-Append-Free-Format-Data AVP, of type Enumerated.
   */
  abstract void setPsAppendFreeFormatData(PsAppendFreeFormatData psAppendFreeFormatData);

  /**
   * Sets the value of the PS-Free-Format-Data AVP, of type OctetString.
   */
  abstract void setPsFreeFormatData(String psFreeFormatData);

  /**
   * Sets the value of the TGPP-Charging-Id AVP, of type OctetString.
   */
  abstract void setTgppChargingId(String tgppChargingId);

}
