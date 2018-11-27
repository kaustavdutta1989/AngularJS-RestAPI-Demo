angular.module("crudApp").controller("GeneralController",GeneralController);

GeneralController.inject=['$scope', 'Employee'];

function GeneralController($scope, Employee) {
	$scope.heading = "Employees";
	$scope.buttonText = "Submit";
	$scope.employees = Employee.query();
	$scope.employee = {};
	
	$scope.saveEmployee=function() {
		
		if($scope.employee.id !== undefined) {
			Employee.update($scope, employee, function(){
				$scope.employees = Employee.query();
				$scope.employee = {};
				$scope.buttonText = "Submit";
			});
		}
		else {
			Employee.save($scope, employee, function(){
				$scope.employees = Employee.query();
				$scope.employee = {};
			});
		}
	}
	
	$scope.updateEmployee=function(employee) {
		$scope.buttonText = "Update";
		$scope.employee = {};
	}
	
	$scope.deleteEmployee=function(employee) {
		employee.$delete({id:employee.id}, function(){
			$scope.employees=Employee.query();
		})
	}
}