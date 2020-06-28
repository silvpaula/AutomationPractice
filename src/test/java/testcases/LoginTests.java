package testcases;

import frameworks.tests.BaseTest;
import frameworks.report.Report;
import org.junit.Test;
import utils.CRUD.User;
import utils.LoginFactory;
import workflows.Workflow;

import java.io.IOException;

public class LoginTests extends BaseTest {
    @Test
    public void validateLoginWithSuccess() throws IOException {
        User user = LoginFactory.createValidLogin();
        Report.startTest("Validate Successful Login");
        Workflow.of(driver).validateLoginWithSuccess(user);
    }
}
