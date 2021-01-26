package com.hemantStudentService.com;

public class StudentWSProxy implements com.hemantStudentService.com.StudentWS {
  private String _endpoint = null;
  private com.hemantStudentService.com.StudentWS studentWS = null;
  
  public StudentWSProxy() {
    _initStudentWSProxy();
  }
  
  public StudentWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initStudentWSProxy();
  }
  
  private void _initStudentWSProxy() {
    try {
      studentWS = (new com.hemantStudentService.com.StudentWSServiceLocator()).getStudentWS();
      if (studentWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)studentWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)studentWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (studentWS != null)
      ((javax.xml.rpc.Stub)studentWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.hemantStudentService.com.StudentWS getStudentWS() {
    if (studentWS == null)
      _initStudentWSProxy();
    return studentWS;
  }
  
  public java.lang.String deleteStudent(int rollNo) throws java.rmi.RemoteException{
    if (studentWS == null)
      _initStudentWSProxy();
    return studentWS.deleteStudent(rollNo);
  }
  
  public java.lang.String addStudent(com.hemantStudentModel.com.Student student) throws java.rmi.RemoteException{
    if (studentWS == null)
      _initStudentWSProxy();
    return studentWS.addStudent(student);
  }
  
  
}