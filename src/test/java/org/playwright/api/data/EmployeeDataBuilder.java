package org.playwright.api.data;

public class EmployeeDataBuilder {

    public static EmployeeData getEmployeeData() {
        return EmployeeData.builder()
                .name("Andrei")
                .job("Tester")
                .build();
    }
}
