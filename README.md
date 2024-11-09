## Tools Required:
1.Selenium WebDriver
2.JUnit
3.Maven (for dependency management)
4.ChromeDriver or GeckoDriver (for running tests on Chrome or Firefox)

## Explanation:
@BeforeAll: This annotation is used for setup, where we initialize the WebDriver. In this case, we're using WebDriverManager to automatically manage the ChromeDriver executable.

testLoginPageTitle(): This test ensures that the title of the login page is correct.

testLoginFormElements(): This test verifies that the username field, password field, and login button are visible on the page.

testSuccessfulLogin(): This test automates the process of logging in with valid credentials and checks if the dashboard page is displayed after a successful login.

testUnsuccessfulLogin(): This test checks the behavior when invalid credentials are entered. It waits for the error message to appear and checks if it's displayed.

@AfterAll: This annotation ensures that after all tests have completed, the browser is closed to free up resources.

''' To Run:
mvn test
'''
