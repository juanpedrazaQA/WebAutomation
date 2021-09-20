package com.travelocity.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
	
	/**
     * Constructor.
     *
     * @param rDriver : WebDriver
     */
    public BasePage(WebDriver rdriver) {
        PageFactory.initElements(rdriver, this);
        wait = new WebDriverWait(rdriver, 30);
        driver = rdriver;
    }
    
    /** Methods **/
    
    /*** Waits ***/
    public boolean waitElementVisibility(WebElement element) {
    	wait.until(ExpectedConditions.visibilityOf(element));
    	return true;
    }
    
    public void waitUntilElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public boolean waitUntilElementClickable2(WebElement element) {
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    	return true;
    }
    
    public void waitvisibilityToAllElements(By locator) {			
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
    public void waitvisibilityToAllElementsWeb(List<WebElement> list) {			
	    wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}
    
    public void waitAllElementsPresenceOfByCSS(String locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }
	
	public void waitElementPresenceOfByCSS(String locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
    
    /** Fin Waits ***/
    
    
    /**
     * Click on clickable element.
     *
     * @param locator : {@link locator : selector of the element that needs to be retrieved}
     */
    public void click(By locator) {
    	waitUntilElementClickable(locator);
        driver.findElement(locator).click();

    }
    
    /**
     * Click on clickable WebElement element.
     *
     * @param element : {@link WebElement}
     */
    public void clickWebElement(WebElement element) {
        waitElementVisibility(element);
        element.click();
    }
    
    /**
     * Click on clickable element of list WebElement.
     *
     * @param list : {@link List(WebElement)}
     * @param number : {@link int (position of the element to click)}
     */
    public void clickElement(List<WebElement> list, int number) {
		
		WebElement ElementSelected = list.get(number - 1);
		ElementSelected.click();		
    }

    /**
     * Find the item you are looking for.
     *
     * @param locator : {@link locator : selector of the element that needs to be retrieved}
     * 
     */
    public WebElement findElement(By locator) {
        return driver.findElement(locator);

    }
    
    /**
     * Find all the matching elements.
     *
     * @param locator : {@link locator : selector of the elements that needs to be retrieved}
     * @return Returns: {@link  a List of WebElement}
     */
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);

    }
    
    /**
     * Send text to the corresponding element.
     * 
     * @param inputText: {@link inputText : text to send , must be a String}
     * @param locator : {@link locator : selector of the elements that needs to be retrieved}
     */
    public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
    }
    
    /**
     * Get the text of the element.
     * 
     * @param element : {@link WebElement}
     */
    public String getTextE(WebElement element) {
        return element.getText();
        
    }
    
    /**
     * Check if an element is present.
     * 
     * @param locator : {@link locator : selector of the elements that needs to be retrieved}
     * @return Returns: {@link  boolean}
     */
    public boolean findElementPresence(By locator) {
		if (!driver.findElement(locator).isDisplayed()) return false;
        return true;
	}
    
    /**
     * Expect an element to be clickable.
     * 
     * @param locator : {@link locator : selector of the elements that needs to be retrieved}
     * @return Returns: {@link  boolean}
     */
    public boolean waitUntilElementClickable2(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return true;
    }
    /**
     * Expect an element to be clickable.
     * 
     * @param element : {@link WebElement}
     * @return Returns: {@link  boolean}
     */
    public boolean findElementPresenceWeb(WebElement element) {
		if (!element.isDisplayed()) return false;
        return true;
	}
    /**
     * check if an element is present
     * 
     * @param locator : {@link locator : selector of the element that needs to be retrieved}
     * @return Returns: {@link  boolean}
     */
	public  boolean isPresent(By locator){
	    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
		}
		
	/**
     * 	check if elements are present
     * 
     * @param locator : {@link locator : selector of the elements that needs to be retrieved}
     * @return Returns: {@link  boolean}
     */
	public boolean isPresents(By locator){
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return true;
		}
	/**
     * 	Check if an element is present handling the exception
     * 
     * @param locator : {@link locator : selector of the elements that needs to be retrieved}
     * @return Returns: {@link  boolean}
     */
	public boolean isDisplayedOnPage(By locator){
	    try{
	        return findElementPresence(locator);
	    } catch (NoSuchElementException nsee){
	        return false;
	    }
	}
	/**
     * 	Check if an element is present handling the exception
     * 
     * @param element : {@link WebElement}
     * @return Returns: {@link  boolean}
     */
	public boolean isDisplayedOnPage2(WebElement element){
	    try{
	        return findElementPresenceWeb(element);
	    } catch (NoSuchElementException nsee){
	        return false;
	    }
	}
	/**
     * 	Check if an element is present handling the exception
     *  Use of wait Until Element Clickable
     * @param element : {@link WebElement}
     * @return Returns: {@link  boolean}
     */
	public boolean isDisplayedOnPage3(By locator){
	    try{
	         waitUntilElementClickable(locator);
	         return true;
	    } catch (NoSuchElementException nsee){
	        return false;
	    }
	}
	
    
}
