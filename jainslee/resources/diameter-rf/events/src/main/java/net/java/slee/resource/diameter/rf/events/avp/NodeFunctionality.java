package net.java.slee.resource.diameter.rf.events.avp;

import java.io.Serializable;
import java.io.StreamCorruptedException;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

/**
 * Java class to represent the NodeFunctionality enumerated type.
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class NodeFunctionality implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _S_CSCF = 0;

  public static final int _P_CSCF = 1;

  public static final int _I_CSCF = 2;

  public static final int _MRFC = 3;

  public static final int _MGCF = 4;

  public static final int _BGCF = 5;

  public static final int _AS = 6;

  public static final NodeFunctionality AS = new NodeFunctionality(_AS);

  public static final NodeFunctionality BGCF = new NodeFunctionality(_BGCF);

  public static final NodeFunctionality I_CSCF = new NodeFunctionality(_I_CSCF);

  public static final NodeFunctionality MGCF = new NodeFunctionality(_MGCF);

  public static final NodeFunctionality MRFC = new NodeFunctionality(_MRFC);

  public static final NodeFunctionality P_CSCF = new NodeFunctionality(_P_CSCF);

  public static final NodeFunctionality S_CSCF = new NodeFunctionality(_S_CSCF);

  private NodeFunctionality(int v) {
    value = v;
  }
  /**
   * Return the value of this instance of this enumerated type.
   */
  public static NodeFunctionality fromInt(int type) {
    switch(type) {
    case _AS: return AS;

    case _BGCF: return BGCF;

    case _I_CSCF: return I_CSCF;

    case _MGCF: return MGCF;

    case _MRFC: return MRFC;

    case _P_CSCF: return P_CSCF;

    case _S_CSCF: return S_CSCF;
    default: throw new IllegalArgumentException("Invalid NodeFunctionality value: " + type);
    }
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    switch(value) {
    case _AS: return "AS";

    case _BGCF: return "BGCF";

    case _I_CSCF: return "I_CSCF";

    case _MGCF: return "MGCF";

    case _MRFC: return "MRFC";

    case _P_CSCF: return "P_CSCF";

    case _S_CSCF: return "S_CSCF";
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
