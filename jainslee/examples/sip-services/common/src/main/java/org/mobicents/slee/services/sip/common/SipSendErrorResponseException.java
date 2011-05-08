/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.services.sip.common;

/**
 * Exception used to tell caller that a SIP error response should be sent out
 * on the current server transaction. The status code for the response sent 
 * should be the same as getStatusCode()
 */
public class SipSendErrorResponseException extends java.lang.Exception implements java.io.Serializable {
    
    private int statusCode;
    
    public SipSendErrorResponseException(String msg, int statusCode, Throwable t) {
        super(msg,t);
        this.statusCode = statusCode;
    }
    
    public SipSendErrorResponseException(String msg, int statusCode) {
        super(msg);
        this.statusCode = statusCode;
    }
    
    public int getStatusCode() { return statusCode; }
    
}
