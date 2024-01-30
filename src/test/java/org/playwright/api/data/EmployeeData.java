package org.playwright.api.data;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeData {

    private String name;
    private String job;
}
