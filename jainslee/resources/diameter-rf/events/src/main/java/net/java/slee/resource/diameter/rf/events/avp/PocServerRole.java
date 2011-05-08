package net.java.slee.resource.diameter.rf.events.avp;

import java.io.StreamCorruptedException;

/**
 * Java class to represent the PocServerRole enumerated type.
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class PocServerRole implements net.java.slee.resource.diameter.base.events.avp.Enumerated, java.io.Serializable{

  private static final long serialVersionUID = 1L;

  public static final int _CONTROLLING_POC_SERVER = 1;

  public static final int _PARTICIPATING_POC_SERVER = 0;

  public static final PocServerRole CONTROLLING_POC_SERVER = new PocServerRole(_CONTROLLING_POC_SERVER);

  public static final PocServerRole PARTICIPATING_POC_SERVER = new PocServerRole(_PARTICIPATING_POC_SERVER);

  private PocServerRole(int v) {
    value = v;
  }

  /**
   * Return the value of this instance of this enumerated type.
   */
  public static PocServerRole fromInt(int type) {
    switch(type) {
    case _CONTROLLING_POC_SERVER: return CONTROLLING_POC_SERVER;
    case _PARTICIPATING_POC_SERVER: return PARTICIPATING_POC_SERVER;
    default: throw new IllegalArgumentException("Invalid PocServerRole value: " + type);
    }
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    switch(value) {
    case _CONTROLLING_POC_SERVER: return "CONTROLLING_POC_SERVER";
    case _PARTICIPATING_POC_SERVER: return "PARTICIPATING_POC_SERVER";
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
