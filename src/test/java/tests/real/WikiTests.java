package tests.real;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.steps.WikiSteps;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.back;

@DisplayName("Тестирование мобильного приложения Wikipedia на реальном устройстве")
@Tag("real")
public class WikiTests extends TestBase {

    private WikiSteps steps = new WikiSteps();

    @Test
    @DisplayName("Проверка текста начальных страниц")
    @Feature("AboutWikiPage")
    @Owner("m.lavrushina")
    @Severity(SeverityLevel.BLOCKER)
    void aboutWikiPageTest() {
        steps.checkPrimaryText("The Free Encyclopedia …in over 300 languages");
        steps.clickForwardButton();
        steps.checkPrimaryText("New ways to explore");
        steps.clickForwardButton();
        steps.checkPrimaryText("Reading lists with sync");
        steps.clickForwardButton();
        steps.checkPrimaryText("Send anonymous data");
    }

    @Test
    @DisplayName("Тест на поиск 'BrowserStack'")
    @Feature("WikiSearch")
    @Owner("m.lavrushina")
    void searchTest() throws MalformedURLException, InterruptedException {
        back();
        steps.searchWikiClick();
        steps.sendKeys("BrowserStack");
        steps.assertResultsExist();
    }

    @DisplayName("Тест на проверку языка поиска")
    @Feature("WikiSearch")
    @Owner("m.lavrushina")
    @Test
    void checkLanguage() throws MalformedURLException, InterruptedException {
        back();
        steps.searchWikiClick();
        steps.sendKeys("BrowserStack");
        steps.assertLanguageIsEN();
    }
}
