package com.payment;

public class SdeIntern extends EmpSalary {


	private static final double DeductionPercentage = 5;

	public SdeIntern(int employeeId, String employeeName, long employeeMobileNo, String employeeEmailId,
			double employeeCTC, String preferredNotifyChannel) {
		super(employeeId, employeeName, (long) employeeMobileNo, employeeEmailId, employeeCTC, preferredNotifyChannel);
		
		double deductedAmount = (this.getEmployeeCTC() * DeductionPercentage)/100;	
		this.setEmployeeNetSalary(this.getEmployeeCTC() - deductedAmount);
	}


}
