package com.travelocity.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.travelocity.pageObjects.HomePage;

public class TC_Exercise_004 extends Base {

	HomePage objHome;
	
	@Test
	public void goToFlightHotel() {
	
	objHome = new HomePage(driver);
	driver.manage().window().maximize();
	driver.get(baseURL);
	objHome.searchFlightHotelExercise4();
	Assert.assertTrue(objHome.verificar_Error_Title_existence(),"No hay texto Principal sobre errores");
	Assert.assertTrue(objHome.verificar_Error_Calendar_One_existence(),"No hay texto de error Calendario 1");
	Assert.assertTrue(objHome.verificar_Error_Calendar_Two_existence(),"No hay texto de error Calendario 2");
	tearDown();
	}	
}
