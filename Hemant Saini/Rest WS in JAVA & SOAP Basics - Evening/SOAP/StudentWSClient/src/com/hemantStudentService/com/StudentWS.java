/**
 * StudentWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hemantStudentService.com;

public interface StudentWS extends java.rmi.Remote {
    public java.lang.String deleteStudent(int rollNo) throws java.rmi.RemoteException;
    public java.lang.String addStudent(com.hemantStudentModel.com.Student student) throws java.rmi.RemoteException;
}
