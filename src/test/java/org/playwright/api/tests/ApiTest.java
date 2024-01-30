package org.playwright.api.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.json.JSONObject;
import org.playwright.api.helper.Hooks;
import org.playwright.api.data.EmployeeData;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.playwright.api.data.EmployeeDataBuilder.getEmployeeData;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class ApiTest extends Hooks {

    @Test
    public void testGetAPI() {
        final APIResponse response = this.manager.getRequest("/api/users/7");
        System.out.println(response.status());
        assertEquals(response.status(), 200);

        final JSONObject jsonObject = new JSONObject(response.text());
        final JSONObject dataObject = jsonObject.getJSONObject("data");

        assertEquals(dataObject.get("email")
                .toString(), "michael.lawson@reqres.in");
        assertEquals(dataObject.get("first_name")
                .toString(), "Michael");
        assertEquals(dataObject.get("last_name")
                .toString(), "Lawson");
        System.out.println(dataObject);
    }

    @Test
    public void testPostAPI() {
        final EmployeeData employeeData = getEmployeeData();
        final APIResponse response = this.manager.postRequest("/api/users", RequestOptions.create()
                .setData(employeeData));
        assertEquals(response.status(), 201);

        final JSONObject jsonObject = new JSONObject(response.text());
        assertNotNull(jsonObject.get("id"));
        assertEquals(jsonObject.get("name"), employeeData.getName());
        assertEquals(jsonObject.get("job"), employeeData.getJob());
        System.out.println(jsonObject);
    }

    @Test
    public void testPutAPI() {
        final EmployeeData employeeData = getEmployeeData();
        final APIResponse response = this.manager.putRequest("/api/users/2", RequestOptions.create()
                .setData(employeeData));
        assertEquals(response.status(), 200);

        final JSONObject jsonObject = new JSONObject(response.text());
        assertNotNull(jsonObject.get("updatedAt"));
        assertEquals(jsonObject.get("name"), employeeData.getName());
        assertEquals(jsonObject.get("job"), employeeData.getJob());
        System.out.println(jsonObject);
    }

    @Test
    public void testPatchAPI() {
        final EmployeeData employeeData = getEmployeeData();
        final APIResponse response = this.manager.patchRequest("/api/users/2", RequestOptions.create()
                .setData(employeeData));
        assertEquals(response.status(), 200);

        final JSONObject jsonObject = new JSONObject(response.text());
        assertNotNull(jsonObject.get("updatedAt"));
        assertEquals(jsonObject.get("name"), employeeData.getName());
        assertEquals(jsonObject.get("job"), employeeData.getJob());
        System.out.println(jsonObject);
    }

    @Test
    public void testDeleteAPI() {
        final EmployeeData employeeData = getEmployeeData();
        final APIResponse response = this.manager.deleteRequest("/api/users/2", RequestOptions.create()
                .setData(employeeData));
        assertEquals(response.status(), 204);
    }

}