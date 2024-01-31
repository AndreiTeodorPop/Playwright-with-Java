package org.playwright.api.tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.json.JSONObject;
import org.playwright.api.data.EmployeeData;
import org.playwright.api.helper.Hooks;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.playwright.api.data.EmployeeDataBuilder.getEmployeeData;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author : andrei
 * @created : 01/30/2024, Tuesday
 **/
public class ApiTest extends Hooks {

    @Test(priority=1)
    public void testGetAPI() {
        System.out.println("==============================GET======================================");
        final APIResponse response = this.manager.getRequest("/api/users/7");
        assertThat(response).isOK();
        System.out.println("Response status expected to be within [200..299] range, was " + response.status());

        final JSONObject jsonObject = new JSONObject(response.text());
        final JSONObject dataObject = jsonObject.getJSONObject("data");

        assertEquals(dataObject.get("email")
                .toString(), "michael.lawson@reqres.in");
        assertEquals(dataObject.get("first_name")
                .toString(), "Michael");
        assertEquals(dataObject.get("last_name")
                .toString(), "Lawson");
        System.out.println(dataObject);
        System.out.println("=======================================================================");
    }

    @Test(priority=2)
    public void testPostAPI() {
        System.out.println("==============================POST=====================================");
        final EmployeeData employeeData = getEmployeeData();
        final APIResponse response = this.manager.postRequest("/api/users", RequestOptions.create()
                .setData(employeeData));
        assertThat(response).isOK();
        System.out.println("Response status expected to be within [200..299] range, was " + response.status());


        final JSONObject jsonObject = new JSONObject(response.text());
        assertNotNull(jsonObject.get("id"));
        assertEquals(jsonObject.get("name"), employeeData.getName());
        assertEquals(jsonObject.get("job"), employeeData.getJob());
        System.out.println(jsonObject);
        System.out.println("=======================================================================");
    }

    @Test(priority=3)
    public void testPutAPI() {
        System.out.println("==============================PUT======================================");
        final EmployeeData employeeData = getEmployeeData();
        final APIResponse response = this.manager.putRequest("/api/users/2", RequestOptions.create()
                .setData(employeeData));
        assertThat(response).isOK();
        System.out.println("Response status expected to be within [200..299] range, was " + response.status());

        final JSONObject jsonObject = new JSONObject(response.text());
        assertNotNull(jsonObject.get("updatedAt"));
        assertEquals(jsonObject.get("name"), employeeData.getName());
        assertEquals(jsonObject.get("job"), employeeData.getJob());
        System.out.println(jsonObject);
        System.out.println("=======================================================================");
    }

    @Test(priority=4)
    public void testPatchAPI() {
        System.out.println("=============================PATCH=====================================");
        final EmployeeData employeeData = getEmployeeData();
        final APIResponse response = this.manager.patchRequest("/api/users/2", RequestOptions.create()
                .setData(employeeData));
        assertThat(response).isOK();
        System.out.println("Response status expected to be within [200..299] range, was " + response.status());

        final JSONObject jsonObject = new JSONObject(response.text());
        assertNotNull(jsonObject.get("updatedAt"));
        assertEquals(jsonObject.get("name"), employeeData.getName());
        assertEquals(jsonObject.get("job"), employeeData.getJob());
        System.out.println(jsonObject);
        System.out.println("=======================================================================");
    }

    @Test(priority=5)
    public void testDeleteAPI() {
        System.out.println("=============================DELETE=====================================");
        final EmployeeData employeeData = getEmployeeData();
        final APIResponse response = this.manager.deleteRequest("/api/users/2", RequestOptions.create()
                .setData(employeeData));
        assertThat(response).isOK();
        System.out.println("Response status expected to be within [200..299] range, was " + response.status());
        System.out.println("=======================================================================");
    }

}