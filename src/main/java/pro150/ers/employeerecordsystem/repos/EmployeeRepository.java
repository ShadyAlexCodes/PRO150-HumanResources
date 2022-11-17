package pro150.ers.employeerecordsystem.repos;

import pro150.ers.employeerecordsystem.enties.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    Employee findByEmployeeLName(String employeeName);
}

