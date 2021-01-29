package com.payment;

public class SeniorSoftwareEngineer extends EmpSalary{
	

		private static final double DeductionPercentage = 7;
		
		public SeniorSoftwareEngineer(int employeeId, String employeeName, long employeeMobileNo, String employeeEmailId,
				double employeeCTC, String preferredNotifyChannel) {
			super(employeeId, employeeName, employeeMobileNo, employeeEmailId, employeeCTC, preferredNotifyChannel);
			
			double deductedAmount = (this.getEmployeeCTC() * DeductionPercentage)/100;	
			this.setEmployeeNetSalary(this.getEmployeeCTC() - deductedAmount);
		}

}
