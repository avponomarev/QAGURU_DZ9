package ponomarev.andrei;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AnnotatedTest {
    @Step("Открываем GitHub")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void findRepo(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo).pressEnter();
    }

    @Step("Переходим в репозиторий {repo}")
    public void goToRepo(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Переходим во вкладку Issue")
    public void goToIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем элемент Issue с номером {issue}")
    public void chekingIssue(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}

