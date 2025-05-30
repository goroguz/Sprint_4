package com.yandex.scooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    private final WebDriver driver;

    // Секция "Вопросы о важном"
    private final By accordionQuestions = By.xpath("//div[@data-accordion-component='AccordionItemButton']");

    // верхняя кнопка
    private final By topOrderButton = By.cssSelector(".Button_Button__ra12g");

    // нижняя кнопка
    private final By bottomOrderButton = By.cssSelector(".Home_FinishButton__1_cWm");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllQuestions() {
        return driver.findElements(accordionQuestions);
    }

    public String getAnswerTextForQuestion(int index) {
        WebElement question = getAllQuestions().get(index);
        clickQuestion(question);

        String answerId = question.getAttribute("aria-controls");
        WebElement answer = driver.findElement(By.id(answerId));
        return answer.getText().trim();
    }

    public void clickQuestion(WebElement question) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", question);
        question.click();
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        WebElement button = driver.findElement(bottomOrderButton);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }

}
