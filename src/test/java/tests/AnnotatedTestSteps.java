package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AnnotatedTestSteps {

    @Step ("Открываем страницу")
    public void mainPage (){
        open("https://github.com");
    }

    @Step ("Вводим что-то в поиск")
    public void inputSearch(){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
    }

    @Step ("Кликаем на ссылку")
    public void clickOnRepository(){
        $(By.linkText("eroshenkoam/allure-example")).click();
    }

    @Step ("Кликаем на ишью")
    public void clickOnIssue(){
        $("[data-content=Issues]").click();
    }

    @Step ("Проверяем ишью")
    public void assertIssue(){
        $(withText("#68")).should(Condition.exist);
    }
}
