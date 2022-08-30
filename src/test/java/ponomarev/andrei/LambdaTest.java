package ponomarev.andrei;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest {
    @BeforeAll
    static void settings() {

        Configuration.browserSize = "1920x1080";

    }

    private static final String REPO = "selenide/selenide-appium";
    private static final int ISSUE = 75;

    @Test
    public void issueSearchLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем GitHub", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий" + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPO).pressEnter();
        });


        step("Переходим в репозиторий" + REPO, () -> {
            $(linkText("selenide/selenide-appium")).click();
        });

        step("Переходим во вкладку Issue", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем элемент Issue с номером" + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void issueSearchAnnotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        AnnotatedTest steps = new AnnotatedTest();
        steps.openMainPage();
        steps.findRepo(REPO);
        steps.goToRepo(REPO);
        steps.goToIssue();
        steps.chekingIssue(ISSUE);
    }
}
