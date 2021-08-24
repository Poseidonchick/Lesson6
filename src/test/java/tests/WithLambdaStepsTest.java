package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WithLambdaStepsTest extends TestBase{
    private static String BASE_URL = "https://github.com";
    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static String ISSUE_NUMBER = "#68";

    @Test
    public void withLambdaStepsSearchTest(){
        step("Открываем стартовую страницу", (s) ->{
            s.parameter("URL", BASE_URL);
            open(BASE_URL);
        });
        step("В поиск вбиваем \"eroshenkoam/allure-example\"", (s) ->{
            $(".header-search-input").click();
            s.parameter("REPOSITORY", REPOSITORY);
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем на ссылку с текстом" + REPOSITORY, (s) ->{
            s.parameter("REPOSITORY", REPOSITORY);
        $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим на вкладку Issues", (s) ->{
        $("[data-content=Issues]").click();
        });
        step("Проверяем наличие ISSUE == " + ISSUE_NUMBER, (s) ->{
            s.parameter("ISSUE", ISSUE_NUMBER);
        $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}
