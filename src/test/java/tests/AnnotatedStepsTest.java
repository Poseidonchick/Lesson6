package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AnnotatedStepsTest extends TestBase{
    private static String BASE_URL = "https://github.com";
    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static String ISSUE_NUMBER = "#68";

    private AnnotatedTestSteps step = new AnnotatedTestSteps();

    @Test
    @Story("Проверка наличия Issue")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com")
    @Owner("MukhortovSV")
    @DisplayName("Тест на проверку создания Issue")
    public  void annotatedTestStepsTest(){
        step.mainPage(BASE_URL);
        step.inputSearch(REPOSITORY);
        step.clickOnRepository(REPOSITORY);
        step.clickOnIssue();
        step.assertIssue(ISSUE_NUMBER);
    }
}
