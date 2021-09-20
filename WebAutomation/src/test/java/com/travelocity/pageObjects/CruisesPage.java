package com.travelocity.pageObjects;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CruisesPage extends BasePage {
	
	
	//locators
	By cruisesDestination = By.id("cruise-destination");
	By buttonDatePicker = By.id("d1-btn");
	By nextBtnDatePicker = By.xpath("//*[@id=\"wizard-cruise-pwa-1\"]/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/button[2]");
	By julDay1 = By.xpath("//*[@id=\"wizard-cruise-pwa-1\"]/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]/button");
	By julDay28 = By.xpath("//*[@id=\"wizard-cruise-pwa-1\"]/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr[5]/td[4]/button");
	By doneDatePicker = By.xpath("//button[@data-stid=\"apply-date-picker\"]");
	By searchCruises = By.xpath("//button[@data-testid=\"submit-button\"]");
	By cruises10to14 = By.xpath("//input[@id=\"length-10-14-ember999\"]");
	By xpathcorrectodescuento = By.xpath("//section/div[@class=\"ember-view\"]//div[contains(.,'Up to 67% off')]");
	By btnContinue = By.xpath("//a[@class=\"expert-advice-button btn btn-secondary btn-utility\"]");
	
	@FindBy(xpath = "//div[@class=\"title-on-ship-image\"]")
	private List<WebElement> listCruisesTitle;
	@FindBy(xpath = "//*[@type='radio' and @name=\"length-10-14\"]")
	private List<WebElement> listRadioBtn10to14;
	@FindBy (xpath = "//div[@class=\"message-flag flex-flag\"]")
	private List<WebElement> listDiscounts;
	@FindBy (xpath = "//section/div[@class=\"ember-view\"]/div[@class=\"ember-view\"]")
	private List<WebElement> listCruises;
	@FindBy (xpath = "//a[@class=\"btn btn-secondary btn-action select-sailing-button\"]")
	private List<WebElement> listBtnContinue;
	
	
	public CruisesPage(WebDriver driver) {
		 super(driver);
	}
	
	
	public boolean VerifyTitle(List<WebElement> titleList, String searchedWord) {
        boolean result = true;
        for (WebElement title : titleList) {
            String occurrences = title.getText();           
            if(!occurrences.contains(searchedWord)) {
            	result = false;
            }          
        }
        return result;
	}
	
	public void clickElementOther(List<WebElement> list, int number, List<WebElement> listCruises, List<WebElement> listBtn) {
		
		WebElement ElementSelected = list.get(number);
		String discount = ElementSelected.getText();
		int count1 = 0;
		
		for(WebElement cruise: listCruises) {					
			String infoCruise = cruise.getText();
			if((infoCruise.contains(discount))) {
				
				WebElement discountCruise = listBtn.get(count1);
				discountCruise.click();
				break;
			}
			count1++;				
		}		
	}
	
	public boolean verifyDiscountPresence() {
        
		boolean result = false;
        for (WebElement cruise : listCruises)
            if (cruise.findElement(By.xpath("//div[@class=\"message-flag flex-flag\"]")).isDisplayed()) {
            	result = true;
            }
        	return result;
    	}
	
	public boolean verifyDiscountNoPresence() {
	        
			boolean result = true;
	        for (WebElement cruise : listCruises)
	            if (cruise.findElement(By.xpath("//div[@class=\"message-flag flex-flag\"]")).isDisplayed()) {
	            	result = false;
	            }
	        	return result;
	    }
		
	public int FindNumberMax(List<WebElement> numberList) {
	    ArrayList<Integer> listNumbers = new ArrayList<>();
	    for (WebElement duration : numberList) {
	        String occurrences = duration.getText();
	        if(occurrences.length() == 13) {
	        	int number = Integer.parseInt(occurrences.substring(6,8));           
	            listNumbers.add(number);
	        }
	        else 
	        {
	        	int number = Integer.parseInt(occurrences.substring(6,7));           
	            listNumbers.add(number);
	        }       
	    }
	    int numberMax = Collections.max(listNumbers);  
	    int posicion = listNumbers.indexOf(numberMax);
	    return posicion;
	}

	public boolean verify_results_Europe() {
		return VerifyTitle(listCruisesTitle, "Europe");
	}
		
	public void verify_elements_beClickable() {
		waitUntilElementClickable2(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[5]/aside/div/div/fieldset[2]/div/div/div/form/div/div[4]/div/label/input")));
		WebElement click10 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[5]/aside/div/div/fieldset[2]/div/div/div/form/div/div[4]/div/label/input"));
		clickWebElement(click10);
		waitUntilElementClickable(btnContinue);	
	}
	
	public boolean verify_presence_cruises() {
		return isPresents( By.xpath("//section/div[@class=\"ember-view\"]/div[@class=\"ember-view\"]"));
	}
	
	public boolean verify_presence_message_cruises() {
		return isPresents(  By.xpath("//div[@class=\"message-flag flex-flag\"]"));
	}
	
	public boolean verify_presence_discount() {
		return verifyDiscountPresence();
	}
	
	public boolean verify_presence_noDiscount() {
		return verifyDiscountNoPresence();
	}
	
	public void click_better_discount_cruise() {
		clickElementOther(listDiscounts, FindNumberMax(listDiscounts),listCruises, listBtnContinue);
	}
	
}
















