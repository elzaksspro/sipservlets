package net.java.slee.resource.diameter.rf.events.avp;

import java.io.Serializable;
import java.io.StreamCorruptedException;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

/**
 * Java class to represent the AddressType enumerated type.
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class AddressType implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _ALPHANUMERIC_SHORTCODE = 5;

  public static final int _E_MAIL_ADDRESS = 0;

  public static final int _IPV4_ADDRESS = 2;

  public static final int _IPV6_ADDRESS = 3;

  public static final int _MSISDN = 1;

  public static final int _NUMERIC_SHORTCODE = 4;

  public static final int _OTHER = 6;

  public static final AddressType ALPHANUMERIC_SHORTCODE = new AddressType(_ALPHANUMERIC_SHORTCODE);

  public static final AddressType E_MAIL_ADDRESS = new AddressType(_E_MAIL_ADDRESS);

  public static final AddressType IPV4_ADDRESS = new AddressType(_IPV4_ADDRESS);

  public static final AddressType IPV6_ADDRESS = new AddressType(_IPV6_ADDRESS);

  public static final AddressType MSISDN = new AddressType(_MSISDN);

  public static final AddressType NUMERIC_SHORTCODE = new AddressType(_NUMERIC_SHORTCODE);

  public static final AddressType OTHER = new AddressType(_OTHER);


  private AddressType(int v)
  {
    value = v;
  }

  /**
   * Return the value of this instance of this enumerated type.
   */
  public static AddressType  fromInt(int type) {
    switch(type) {
    case _ALPHANUMERIC_SHORTCODE: return ALPHANUMERIC_SHORTCODE;

    case _E_MAIL_ADDRESS: return E_MAIL_ADDRESS;

    case _IPV4_ADDRESS: return IPV4_ADDRESS;

    case _IPV6_ADDRESS: return IPV6_ADDRESS;

    case _MSISDN: return MSISDN;

    case _NUMERIC_SHORTCODE: return NUMERIC_SHORTCODE;

    case _OTHER: return OTHER;
    default: throw new IllegalArgumentException("Invalid DisconnectCause value: " + type);
    }
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    switch(value) {
    case _ALPHANUMERIC_SHORTCODE: return "ALPHANUMERIC_SHORTCODE";

    case _E_MAIL_ADDRESS: return "E_MAIL_ADDRESS";

    case _IPV4_ADDRESS: return "IPV4_ADDRESS";

    case _IPV6_ADDRESS: return "IPV6_ADDRESS";

    case _MSISDN: return "MSISDN";

    case _NUMERIC_SHORTCODE: return "NUMERIC_SHORTCODE";

    case _OTHER: return "OTHER";
    default: return "<Invalid Value>";
    }
  }

  private Object readResolve() throws StreamCorruptedException {
    try {
      return fromInt(value);
    }
    catch (IllegalArgumentException iae) {
      throw new StreamCorruptedException("Invalid internal state found: " + value);
    }
  }

  private int value = 0;

}
