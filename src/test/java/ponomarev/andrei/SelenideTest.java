package ponomarev.andrei;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
private final String TextInput = "Selenide";
    private final SelenideElement
    searchLine = $(".header-search-input"),
    selenideAppium = $(linkText("selenide/selenide-appium")),
    issuesTab = $("#issues-tab"),
    checkText = $(withText("#75"));


    @BeforeAll
    static void settings() {

        Configuration.browserSize = "1920x1080";

    }

    @Test
    @DisplayName("Проверка Issue в репозитории")
    @Feature("Поиск")
    @Story("Поиск Issue")
    @Owner("PonomarevAndrei")

    public void issueSearchTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());


        open("https://github.com/");
        searchLine.click();
        searchLine.setValue(TextInput).pressEnter();
        selenideAppium.click();
        issuesTab.click();
        checkText.should(Condition.exist);
    }

}