package com.example.springcrud.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Employee}
     *   <li>{@link Employee#setAge(int)}
     *   <li>{@link Employee#setId(int)}
     *   <li>{@link Employee#setName(String)}
     *   <li>{@link Employee#setStatus(String)}
     *   <li>{@link Employee#getAge()}
     *   <li>{@link Employee#getId()}
     *   <li>{@link Employee#getName()}
     *   <li>{@link Employee#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        Employee actualEmployee = new Employee();
        actualEmployee.setAge(1);
        actualEmployee.setId(1);
        actualEmployee.setName("Name");
        actualEmployee.setStatus("Status");

        // Assert
        assertEquals(1, actualEmployee.getAge());
        assertEquals(1, actualEmployee.getId());
        assertEquals("Name", actualEmployee.getName());
        assertEquals("Status", actualEmployee.getStatus());
    }
}

