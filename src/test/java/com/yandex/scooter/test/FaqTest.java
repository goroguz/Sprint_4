package com.yandex.scooter.test;

import com.yandex.scooter.constants.FaqAnswers;
import com.yandex.scooter.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqTest {

    private final int questionIndex;
    private final String expectedAnswer;

    public FaqTest(int questionIndex, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedAnswer = expectedAnswer;
    }

    private WebDriver driver;
    @Parameterized.Parameters(name = "FAQ вопрос #{0}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
            {0, FaqAnswers.PAYMENT_INFO},
            {1, FaqAnswers.ONE_SCOOTER},
            {2, FaqAnswers.RENT_START},
            {3, FaqAnswers.FROM_TOMORROW},
            {4, FaqAnswers.NO_SUPPORT_CHAT},
            {5, FaqAnswers.FULL_CHARGE},
            {6, FaqAnswers.CANCEL_FREE},
            {7, FaqAnswers.DELIVERY_AREA}
        });
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/A13039316/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testAccordionAnswerText() {
        MainPage mainPage = new MainPage(driver);
        List<WebElement> questions = mainPage.getAllQuestions();
        WebElement question = questions.get(questionIndex);

        mainPage.clickQuestion(question);
        WebElement answer = mainPage.getAnswerElementForQuestion(question);
        String actualText = answer.getText().trim();

        assertEquals("Текст ответа не совпадает для вопроса #" + questionIndex, expectedAnswer, actualText);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}