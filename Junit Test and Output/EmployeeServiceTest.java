package com.example.springcrud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.springcrud.entity.Employee;
import com.example.springcrud.repository.EmployeeRepository;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeService.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeService#save(Employee)}
     */
    @Test
    void testSave() {
        // Arrange
        Employee employee = new Employee();
        employee.setAge(1);
        employee.setId(1);
        employee.setName("Name");
        employee.setStatus("Status");
        when(employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setAge(1);
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setStatus("Status");

        // Act and Assert
        assertSame(employee, employeeService.save(employee1));
        verify(employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeService#getEmployee(int)}
     */
    @Test
    void testGetEmployee() {
        // Arrange
        Employee employee = new Employee();
        employee.setAge(1);
        employee.setId(1);
        employee.setName("Name");
        employee.setStatus("Status");
        Optional<Employee> ofResult = Optional.of(employee);
        when(employeeRepository.findById((Integer) any())).thenReturn(ofResult);

        // Act and Assert
        assertSame(employee, employeeService.getEmployee(1));
        verify(employeeRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link EmployeeService#getEmployee(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEmployee2() {
       
        when(employeeRepository.findById((Integer) any())).thenReturn(Optional.empty());

        // Act
        employeeService.getEmployee(1);
    }

    /**
     * Method under test: {@link EmployeeService#update(Employee)}
     */
    @Test
    void testUpdate() {
        // Arrange
        Employee employee = new Employee();
        employee.setAge(1);
        employee.setId(1);
        employee.setName("Name");
        employee.setStatus("Status");
        Optional<Employee> ofResult = Optional.of(employee);

        Employee employee1 = new Employee();
        employee1.setAge(1);
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setStatus("Status");
        when(employeeRepository.save((Employee) any())).thenReturn(employee1);
        when(employeeRepository.findById((Integer) any())).thenReturn(ofResult);

        Employee employee2 = new Employee();
        employee2.setAge(1);
        employee2.setId(1);
        employee2.setName("Name");
        employee2.setStatus("Status");

        // Act and Assert
        assertSame(employee1, employeeService.update(employee2));
        verify(employeeRepository).save((Employee) any());
        verify(employeeRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link EmployeeService#update(Employee)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate2() {
       
        // Arrange
        Employee employee = new Employee();
        employee.setAge(1);
        employee.setId(1);
        employee.setName("Name");
        employee.setStatus("Status");
        when(employeeRepository.save((Employee) any())).thenReturn(employee);
        when(employeeRepository.findById((Integer) any())).thenReturn(Optional.empty());

        Employee employee1 = new Employee();
        employee1.setAge(1);
        employee1.setId(1);
        employee1.setName("Name");
        employee1.setStatus("Status");

        // Act
        employeeService.update(employee1);
    }

    /**
     * Method under test: {@link EmployeeService#delete(int)}
     */
    @Test
    void testDelete() {
        // Arrange
        doNothing().when(employeeRepository).deleteById((Integer) any());

        // Act and Assert
        assertEquals("deleted", employeeService.delete(1).getStatus());
        verify(employeeRepository).deleteById((Integer) any());
    }

   
    @Test
    void testConstructor() {
       
        // Arrange and Act
        (new EmployeeService()).setEmployeeRepository(mock(EmployeeRepository.class));
    }
}

