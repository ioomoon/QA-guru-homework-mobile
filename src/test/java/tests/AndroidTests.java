package tests;


import io.appium.java_client.MobileBy;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import tests.steps.WikiSteps;

public class AndroidTests extends TestBase {

    private WikiSteps steps = new WikiSteps();

    @Test
    void searchTest() throws MalformedURLException, InterruptedException {
        steps.searchWikiClick();
        steps.sendKeysBrowserStack();
        steps.assertResultsExist();
    }

    @Test
    void checkLanguage() throws MalformedURLException, InterruptedException {
        steps.searchWikiClick();
        steps.sendKeysBrowserStack();
        steps.assertLanguageIsEN();
    }
}
