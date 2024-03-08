package testscripts;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apollons.base.BaseTest;
import com.apollons.keywords.ApplicationKeywords;
import com.apollons.utils.UtilKit;
import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.datatransfer.StringSelection;

public class TestCase1 extends BaseTest {

	@Test(dataProvider = "getData")
	public void validateLoginTest(HashMap<String, String> dataMap) throws AWTException {

		System.out.println("Nume" + dataMap.get("Nume"));
		System.out.println("Prenume" + dataMap.get("Prenume"));
		System.out.println("telefon" + dataMap.get("telefon"));
		System.out.println("Title" + dataMap.get("Title"));
		System.out.println("price" + dataMap.get("price"));
		System.out.println("cartier" + dataMap.get("cartier"));
		System.out.println("strada" + dataMap.get("strada"));
		System.out.println("nr" + dataMap.get("nr"));
		System.out.println("nr camere" + dataMap.get("nr camere"));
		System.out.println("etaj" + dataMap.get("etaj"));
		System.out.println("total etaje" + dataMap.get("total etaje"));
		System.out.println("nr bai" + dataMap.get("nr bai"));
		System.out.println("nr balcoane" + dataMap.get("nr balcoane"));
		System.out.println("suprafata U" + dataMap.get("suprafata U"));
		System.out.println("suprafata C" + dataMap.get("suprafata C"));
		System.out.println("Confort" + dataMap.get("Confort"));
		System.out.println("compartimentare" + dataMap.get("compartimentare"));
		System.out.println("locuri parcare" + dataMap.get("locuri parcare"));
		System.out.println("tip parcare" + dataMap.get("tip parcare"));
		System.out.println("an constructie" + dataMap.get("an constructie"));

		ApplicationKeywords app = new ApplicationKeywords();

		app.openBrowser();

		app.launchApp();

		app.type("login_username_textbox", configProperties.getProperty("username"));

		app.type("login_password_textbox", configProperties.getProperty("password"));

		app.click("login_login_button");

		app.click("offers_link");

		app.mouseHover("addOffer_dropdown");

		app.click("addOffer_link");

		app.selectOptionFromDropdown("propertyType_dropdown", "Apartamente");

		app.selectOptionFromDropdown("saleType_dropdown", "inchiriere");

		app.click("submit_button");

		app.click("proprtier_addIcon");

		app.switchToAnotherWindow();

		app.type("vendorAdd_Nume_textbox", dataMap.get("Nume"));

		app.type("vendorAdd_Prenume_textbox", dataMap.get("Prenume"));

		app.selectOptionFromDropdown("calitate_dropdown", "Administrator");

		app.type("telefon1_textbox", dataMap.get("telefon"));

		app.click("vendorAdd_submit_button1");

		app.click("vendorAdd_AdaugaLaProprietate_button");

		app.switchToHomeWindow();

		app.type("titlu_textarea", dataMap.get("Title"));

		app.type("pret_Inchiriere_textbox", dataMap.get("price"));

		app.selectOptionFromDropdown("Judet_dropdown", "Bucuresti Ilfov");

		app.wait(3);

		app.selectOptionFromDropdown("Localitate_dropdown", "Bucuresti  ");

		app.wait(3);

		app.selectOptionFromDropdown("Cartier_dropdown", dataMap.get("cartier"));

		app.type("Strada_textbox", dataMap.get("strada"));

		app.type("Nr_textbox", dataMap.get("nr"));

		app.click("map_link");

		app.switchToAnotherWindow();

		app.click("map_save_button");

		app.switchToHomeWindow();

		app.selectOptionFromDropdown("Nr_Camere_dropdown", dataMap.get("nr camere"));

		app.selectOptionFromDropdown("Etaj_dropdown", dataMap.get("etaj"));

		app.selectOptionFromDropdown("Total_Etaje_dropdown", dataMap.get("total etaje"));

		app.selectOptionFromDropdown("Nr_Bai_dropdown", dataMap.get("nr bai"));

		app.selectOptionFromDropdown("Nr_Balcoane_dropdown", dataMap.get("nr balcoane"));

		app.type("Suprafata_Utila_textbox", dataMap.get("suprafata U"));

		app.type("Suprafata_Construita_textbox", dataMap.get("suprafata C"));

		app.selectOptionFromDropdown("Confort_dropdown", dataMap.get("Confort"));

		app.selectOptionFromDropdown("Compartimentare_dropdown", dataMap.get("compartimentare"));

		app.type("Locuri_Parcare_textbox", dataMap.get("locuri parcare"));

		app.type("An_Constructie_textbox", dataMap.get("an constructie"));

		app.openDescriptionWindow();

		Robot robot = new Robot();

		// Press CTRL+A
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);

		// Release CTRL+A
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);

		// Press CTRL+C
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);

		// Release CTRL+C
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		app.close();

		app.switchToHomeWindow();

		app.switchToFrame();

		Actions action = new Actions(driver);

		action.click(driver.findElement(By.xpath("//html[@dir]"))).build().perform();

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[@title='Replace']")).click();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("WWWWWW");
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMap.get("nr camere"));
		
		driver.findElement(By.xpath("//a[@title='Replace All']")).click();
		
		app.wait(1);
		
		Alert alert=driver.switchTo().alert();
		
		alert.accept();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
	
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("YYYYYY");
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMap.get("cartier"));
		
		driver.findElement(By.xpath("//a[@title='Replace All']")).click();
		
		app.wait(1);
		
		 alert=driver.switchTo().alert();
		
		alert.accept();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
			
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("ZZZZZZ");
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMap.get("suprafata U"));
		
		driver.findElement(By.xpath("//a[@title='Replace All']")).click();
		
		app.wait(1);
		
		 alert=driver.switchTo().alert();
		
		alert.accept();
				
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("AAAAAA");
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMap.get("compartimentare"));
		
		driver.findElement(By.xpath("//a[@title='Replace All']")).click();
		
		app.wait(1);
		
		 alert=driver.switchTo().alert();
		
		alert.accept();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("BBBBBB");
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMap.get("etaj"));
		
		driver.findElement(By.xpath("//a[@title='Replace All']")).click();
		
		app.wait(1);
		
		 alert=driver.switchTo().alert();
		
		alert.accept();
		
			
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("CCCCCC");
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMap.get("total etaje"));
		
		driver.findElement(By.xpath("//a[@title='Replace All']")).click();
		
		app.wait(1);
		
		 alert=driver.switchTo().alert();
		
		alert.accept();
		
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("DDDDDD");
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMap.get("an constructie"));
		
		driver.findElement(By.xpath("//a[@title='Replace All']")).click();
		
		app.wait(1);
		
		 alert=driver.switchTo().alert();
		
		alert.accept();
		
		app.wait(1);
		
		driver.findElement(By.xpath("//a[@title='Close']")).click();
		
		driver.findElement(By.xpath("(//input[@value='Salveaza'])[2]")).click();
		
		

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][1];

		data[0][0] = UtilKit.getTestData2("TC-101");

		return data;
	}

}
