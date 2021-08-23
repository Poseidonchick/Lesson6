package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends TestBase{
    @Test
    public void issueSearchSelenideTest(){
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $("[data-content=Issues]").click();
        $(withText("#68")).should(Condition.exist);
    }
}
