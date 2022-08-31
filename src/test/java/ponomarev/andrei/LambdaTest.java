package ponomarev.andrei;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
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

    private final int issue = 75;
    private final String repo = "selenide/selenide-appium";
    private final SelenideElement
            searchLine = $(".header-search-input"),
            selenideAppium = $(linkText("selenide/selenide-appium")),
            issuesTab = $("#issues-tab"),
            checkTextissue = $(withText("#" + issue));

    @Test
    public void issueSearchLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем GitHub", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий" + repo, () -> {
            searchLine.click();
            searchLine.setValue(repo).pressEnter();
        });


        step("Переходим в репозиторий" + repo, () -> {
            selenideAppium.click();
        });

        step("Переходим во вкладку Issue", () -> {
            issuesTab.click();
        });

        step("Проверяем элемент Issue с номером" + issue, () -> {
            checkTextissue.should(Condition.exist);
        });
    }

    @Test
    public void issueSearchAnnotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        AnnotatedTest steps = new AnnotatedTest();
        steps.openMainPage();
        steps.findRepo(repo);
        steps.goToRepo(repo);
        steps.goToIssue();
        steps.chekingIssue(issue);
    }
}
