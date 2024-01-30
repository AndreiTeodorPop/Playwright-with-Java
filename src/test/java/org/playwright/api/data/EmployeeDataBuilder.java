package org.playwright.api.data;

/**
 * @author : andrei
 * @created : 01/30/2024, Tuesday
 **/
public class EmployeeDataBuilder {

    public static EmployeeData getEmployeeData() {
        return EmployeeData.builder()
                .name("Andrei")
                .job("Tester")
                .build();
    }
}
