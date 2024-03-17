/*
package com.carwale.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(text(),'NEW CARS')]")
    public WebElement newCars;

    @FindBy(xpath = "//div[contains(text(),'Find New Cars')]")
    public WebElement findNewCars;

    @FindBy(css = "input[placeholder='Type to select car name']")
    public WebElement selectNewcars;

    @FindBy(css = "span[data-unique-key='used']")
    public WebElement usedcars;

    public void findNewCar() {
        new Actions(driver).moveToElement(newCars).build().perform();
        findNewCars.click();
    }

    public void searchNewCar(String carName) {
        selectNewcars.sendKeys(carName);
    }

    public void searchUsedCar(String carName) {
        usedcars.click();
    }
}
*?


 */