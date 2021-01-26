/**
 * StudentWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hemantStudentService.com;

public interface StudentWSService extends javax.xml.rpc.Service {
    public java.lang.String getStudentWSAddress();

    public com.hemantStudentService.com.StudentWS getStudentWS() throws javax.xml.rpc.ServiceException;

    public com.hemantStudentService.com.StudentWS getStudentWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
