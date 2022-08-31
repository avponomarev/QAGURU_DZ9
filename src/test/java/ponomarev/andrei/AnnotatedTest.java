package ponomarev.andrei;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AnnotatedTest {

    private final int issue = 75;

    private final SelenideElement
            searchLine = $(".header-search-input"),
            selenideAppium = $(linkText("selenide/selenide-appium")),
            issuesTab = $("#issues-tab"),
            checkTextissue = $(withText("#" + issue));

    @Step("Открываем GitHub")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void findRepo(String repo) {
        searchLine.click();
        searchLine.setValue(repo).pressEnter();
    }

    @Step("Переходим в репозиторий {repo}")
    public void goToRepo(String repo) {
        selenideAppium.click();
    }

    @Step("Переходим во вкладку Issue")
    public void goToIssue() {
        issuesTab.click();
    }

    @Step("Проверяем элемент Issue с номером {issue}")
    public void chekingIssue(int issue) {
        checkTextissue.should(Condition.exist);
    }
}

