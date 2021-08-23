package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AnnotatedStepsTest extends TestBase{

    private AnnotatedTestSteps step = new AnnotatedTestSteps();

    @Test
    @DisplayName("Открываем страницу и вводим что-то в поиск")
    public  void annotatedTestStepsTest(){
        step.mainPage();
        step.inputSearch();
        step.clickOnRepository();
        step.clickOnIssue();
        step.assertIssue();
    }
}
