package org.mobicents.slee.resource.diameter.rf.events.avp;

import net.java.slee.resource.diameter.rf.events.avp.LcsClientName;
import net.java.slee.resource.diameter.rf.events.avp.LcsFormatIndicator;

import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * LcsClientNameImpl.java
 *
 * <br>Project:  mobicents
 * <br>3:28:17 AM Apr 12, 2009 
 * <br>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class LcsClientNameImpl extends GroupedAvpImpl implements LcsClientName {

  public LcsClientNameImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public LcsClientNameImpl( int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.LcsClientName#getLcsDataCodingScheme()
   */
  public String getLcsDataCodingScheme() {
    return getAvpAsUTF8String(DiameterRfAvpCodes.LCS_DATA_CODING_SCHEME, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.LcsClientName#getLcsFormatIndicator()
   */
  public LcsFormatIndicator getLcsFormatIndicator() {
    return (LcsFormatIndicator) getAvpAsEnumerated(DiameterRfAvpCodes.LCS_FORMAT_INDICATOR, DiameterRfAvpCodes.TGPP_VENDOR_ID, LcsFormatIndicator.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.LcsClientName#getLcsNameString()
   */
  public String getLcsNameString() {
    return getAvpAsUTF8String(DiameterRfAvpCodes.LCS_NAME_STRING, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.LcsClientName#hasLcsDataCodingScheme()
   */
  public boolean hasLcsDataCodingScheme() {
    return hasAvp( DiameterRfAvpCodes.LCS_DATA_CODING_SCHEME, DiameterRfAvpCodes.TGPP_VENDOR_ID );
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.LcsClientName#hasLcsFormatIndicator()
   */
  public boolean hasLcsFormatIndicator() {
    return hasAvp( DiameterRfAvpCodes.LCS_FORMAT_INDICATOR, DiameterRfAvpCodes.TGPP_VENDOR_ID );
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.LcsClientName#hasLcsNameString()
   */
  public boolean hasLcsNameString() {
    return hasAvp( DiameterRfAvpCodes.LCS_NAME_STRING, DiameterRfAvpCodes.TGPP_VENDOR_ID );
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.LcsClientName#setLcsDataCodingScheme(String)
   */
  public void setLcsDataCodingScheme( String lcsDataCodingScheme ) {
    addAvp(DiameterRfAvpCodes.LCS_DATA_CODING_SCHEME, DiameterRfAvpCodes.TGPP_VENDOR_ID, lcsDataCodingScheme);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.LcsClientName#setLcsFormatIndicator(net.java.slee.resource.diameter.rf.events.avp.LcsFormatIndicator)
   */
  public void setLcsFormatIndicator( LcsFormatIndicator lcsFormatIndicator ) {
    addAvp(DiameterRfAvpCodes.LCS_FORMAT_INDICATOR, DiameterRfAvpCodes.TGPP_VENDOR_ID, lcsFormatIndicator.getValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.LcsClientName#setLcsNameString(String)
   */
  public void setLcsNameString( String lcsNameString ) {
    addAvp(DiameterRfAvpCodes.LCS_NAME_STRING, DiameterRfAvpCodes.TGPP_VENDOR_ID, lcsNameString);
  }

}
