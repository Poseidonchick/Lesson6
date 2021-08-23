package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WithLambdaStepsTest extends TestBase{
    @Test
    public void withLambdaStepsSearchTest(){
        step("Открываем стартовую страницу", (s) ->{
            open("https://github.com");
        });
        step("В поиск вбиваем \"eroshenkoam/allure-example\"", (s) ->{
            $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();
        });
        step("Кликаем на ссылку с текстом \"eroshenkoam/allure-example\"", (s) ->{
        $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("Переходим на вкладку Issues", (s) ->{
        $("[data-content=Issues]").click();
        });
        step("Проверяем наличие ишью == #68", (s) ->{
        $(withText("#68")).should(Condition.exist);
        });
    }
}
