package org.playwright.api.data;

import lombok.Builder;
import lombok.Getter;

/**
 * @author : andrei
 * @created : 01/30/2024, Tuesday
 **/
@Getter
@Builder
public class EmployeeData {

    private String name;
    private String job;
}
