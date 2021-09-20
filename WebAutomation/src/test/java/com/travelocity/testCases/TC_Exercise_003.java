package com.travelocity.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.travelocity.pageObjects.HomePage;

public class TC_Exercise_003 extends Base {
	
	HomePage objHome;
	
	
	
	@Test
	public void goToHotelsPage() {
		
		objHome = new HomePage(driver);
		driver.manage().window().maximize();
		driver.get(baseURL);
		objHome.realizar_click_btn_Hotels();
		objHome.realizar_ingreso_GoingTo();
		objHome.realizar_click_btn_SearchHotels();
		Assert.assertTrue(objHome.verificar_existencia_title_discount(),"No se encontraron el titulo de Discount");
		Assert.assertTrue(objHome.verificar_existencia_SignUp_free(),"No se encontraron el boton Sign Up, it's free");
		tearDown();
	}
	
	
}
