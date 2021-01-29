/**
 * StudentWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hemantStudentService.com;

public class StudentWSServiceLocator extends org.apache.axis.client.Service implements com.hemantStudentService.com.StudentWSService {

    public StudentWSServiceLocator() {
    }


    public StudentWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StudentWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StudentWS
    private java.lang.String StudentWS_address = "http://localhost:8080/StudentWebService/services/StudentWS";

    public java.lang.String getStudentWSAddress() {
        return StudentWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StudentWSWSDDServiceName = "StudentWS";

    public java.lang.String getStudentWSWSDDServiceName() {
        return StudentWSWSDDServiceName;
    }

    public void setStudentWSWSDDServiceName(java.lang.String name) {
        StudentWSWSDDServiceName = name;
    }

    public com.hemantStudentService.com.StudentWS getStudentWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StudentWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStudentWS(endpoint);
    }

    public com.hemantStudentService.com.StudentWS getStudentWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.hemantStudentService.com.StudentWSSoapBindingStub _stub = new com.hemantStudentService.com.StudentWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getStudentWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStudentWSEndpointAddress(java.lang.String address) {
        StudentWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.hemantStudentService.com.StudentWS.class.isAssignableFrom(serviceEndpointInterface)) {
                com.hemantStudentService.com.StudentWSSoapBindingStub _stub = new com.hemantStudentService.com.StudentWSSoapBindingStub(new java.net.URL(StudentWS_address), this);
                _stub.setPortName(getStudentWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StudentWS".equals(inputPortName)) {
            return getStudentWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://com.hemantStudentService.com", "StudentWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://com.hemantStudentService.com", "StudentWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StudentWS".equals(portName)) {
            setStudentWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
