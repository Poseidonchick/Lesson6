package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AnnotatedTestSteps {



    @Step ("Открываем страницу")
    public void mainPage (String URL){
        open(URL);
    }

    @Step ("Вводим что-то в поиск")
    public void inputSearch(String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step ("Кликаем на ссылку")
    public void clickOnRepository(String repository){
        $(By.linkText(repository)).click();
    }

    @Step ("Кликаем на Issue")
    public void clickOnIssue(){
        $("[data-content=Issues]").click();
    }

    @Step ("Проверяем ишью")
    public void assertIssue(String issueNumber){
        $(withText(issueNumber)).should(Condition.exist);
    }
}
