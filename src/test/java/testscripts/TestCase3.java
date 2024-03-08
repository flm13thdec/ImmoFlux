package testscripts;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apollons.base.BaseTest;
import com.apollons.keywords.ApplicationKeywords;
import com.apollons.utils.UtilKit;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.awt.datatransfer.StringSelection;

public class TestCase3 extends BaseTest {

	ApplicationKeywords app;
	@BeforeTest
	public void startBrowser()
	{
		 app = new ApplicationKeywords();

		app.openBrowser();

		app.launchApp();
		
		app.type("login_username_textbox", configProperties.getProperty("username"));

		app.type("login_password_textbox", configProperties.getProperty("password"));

		app.click("login_login_button");

		app.click("offers_link");
		
		
	}
	
	@Test(dataProvider = "getData")
	public void validateLoginTest(ArrayList<HashMap<String, String>> dataMapList ) throws AWTException {

		System.out.println("dataMapList.size()"+dataMapList.size());
		
		for(int i=0;i<dataMapList.size();i++)
		{
			System.out.println("Nume" + dataMapList.get(i).get("Nume"));
			System.out.println("Prenume" + dataMapList.get(i).get("Prenume"));
			System.out.println("telefon" + dataMapList.get(i).get("telefon"));
			System.out.println("Title" + dataMapList.get(i).get("Title"));
			System.out.println("price" + dataMapList.get(i).get("price"));
			System.out.println("cartier" + dataMapList.get(i).get("cartier"));
			System.out.println("strada" + dataMapList.get(i).get("strada"));
			System.out.println("nr" + dataMapList.get(i).get("nr"));
			System.out.println("nr camere" + dataMapList.get(i).get("nr camere"));
			System.out.println("etaj" + dataMapList.get(i).get("etaj"));
			System.out.println("total etaje" + dataMapList.get(i).get("total etaje"));
			System.out.println("nr bai" + dataMapList.get(i).get("nr bai"));
			System.out.println("nr balcoane" + dataMapList.get(i).get("nr balcoane"));
			System.out.println("suprafata U" + dataMapList.get(i).get("suprafata U"));
			System.out.println("suprafata C" + dataMapList.get(i).get("suprafata C"));
			System.out.println("Confort" + dataMapList.get(i).get("Confort"));
			System.out.println("compartimentare" + dataMapList.get(i).get("compartimentare"));
			System.out.println("locuri parcare" + dataMapList.get(i).get("locuri parcare"));
			System.out.println("tip parcare" + dataMapList.get(i).get("tip parcare"));
			System.out.println("an constructie" + dataMapList.get(i).get("an constructie"));

			
			app.mouseHover("addOffer_dropdown");

			app.click("addOffer_link");

			app.selectOptionFromDropdown("propertyType_dropdown", "Apartamente");

			app.selectOptionFromDropdown("saleType_dropdown", "inchiriere");

			app.click("submit_button");

			app.click("proprtier_addIcon");

			app.switchToAnotherWindow();

			app.type("vendorAdd_Nume_textbox", dataMapList.get(i).get("Nume"));

			app.type("vendorAdd_Prenume_textbox", dataMapList.get(i).get("Prenume"));

			app.selectOptionFromDropdown("calitate_dropdown", "Administrator");

			app.type("telefon1_textbox", dataMapList.get(i).get("telefon"));

			app.click("vendorAdd_submit_button1");

			app.click("vendorAdd_AdaugaLaProprietate_button");

			app.switchToHomeWindow();

			app.type("titlu_textarea", dataMapList.get(i).get("Title"));

			app.type("pret_Inchiriere_textbox", dataMapList.get(i).get("price"));

			app.selectOptionFromDropdown("Judet_dropdown", "Bucuresti Ilfov");

			app.wait(3);

			//app.selectOptionFromDropdown("Localitate_dropdown", "Bucuresti  ");
			
			Actions act=new Actions(driver);
			
			act.click(driver.findElement(By.xpath("//select[@name='selRegion_1']")))
			     .pause(1000)
				 .sendKeys(Keys.ARROW_DOWN).pause(1000)
			     .sendKeys(Keys.ENTER).pause(1000)
			     .build().perform();
	

			app.wait(3);

			app.selectOptionFromDropdown("Cartier_dropdown", dataMapList.get(i).get("cartier"));

			app.type("Strada_textbox", dataMapList.get(i).get("strada"));

			app.type("Nr_textbox", dataMapList.get(i).get("nr"));

			app.click("map_link");

			app.switchToAnotherWindow();

			app.click("map_save_button");

			app.switchToHomeWindow();

			app.selectOptionFromDropdown("Nr_Camere_dropdown", dataMapList.get(i).get("nr camere"));

			app.selectOptionFromDropdown("Etaj_dropdown", dataMapList.get(i).get("etaj"));

			app.selectOptionFromDropdown("Total_Etaje_dropdown", dataMapList.get(i).get("total etaje"));

			app.selectOptionFromDropdown("Nr_Bai_dropdown", dataMapList.get(i).get("nr bai"));

			app.selectOptionFromDropdown("Nr_Balcoane_dropdown", dataMapList.get(i).get("nr balcoane"));

			app.type("Suprafata_Utila_textbox", dataMapList.get(i).get("suprafata U"));

			app.type("Suprafata_Construita_textbox", dataMapList.get(i).get("suprafata C"));

			app.selectOptionFromDropdown("Confort_dropdown", dataMapList.get(i).get("Confort"));

			app.selectOptionFromDropdown("Compartimentare_dropdown", dataMapList.get(i).get("compartimentare"));

			app.type("Locuri_Parcare_textbox", dataMapList.get(i).get("locuri parcare"));
			
			app.selectOptionFromDropdown("Parcare_dropdown",dataMapList.get(i).get("tip parcare") );

			app.type("An_Constructie_textbox", dataMapList.get(i).get("an constructie"));

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
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMapList.get(i).get("nr camere"));
			
			driver.findElement(By.xpath("//a[@title='Replace All']")).click();
			
			app.wait(1);
			
			Alert alert=driver.switchTo().alert();
			
			alert.accept();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
		
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("YYYYYY");
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMapList.get(i).get("cartier"));
			
			driver.findElement(By.xpath("//a[@title='Replace All']")).click();
			
			app.wait(1);
			
			 alert=driver.switchTo().alert();
			
			alert.accept();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
				
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("ZZZZZZ");
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMapList.get(i).get("suprafata U"));
			
			driver.findElement(By.xpath("//a[@title='Replace All']")).click();
			
			app.wait(1);
			
			 alert=driver.switchTo().alert();
			
			alert.accept();
					
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("AAAAAA");
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMapList.get(i).get("compartimentare"));
			
			driver.findElement(By.xpath("//a[@title='Replace All']")).click();
			
			app.wait(1);
			
			 alert=driver.switchTo().alert();
			
			alert.accept();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("BBBBBB");
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMapList.get(i).get("etaj"));
			
			driver.findElement(By.xpath("//a[@title='Replace All']")).click();
			
			app.wait(1);
			
			 alert=driver.switchTo().alert();
			
			alert.accept();
			
				
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("CCCCCC");
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMapList.get(i).get("total etaje"));
			
			driver.findElement(By.xpath("//a[@title='Replace All']")).click();
			
			app.wait(1);
			
			 alert=driver.switchTo().alert();
			
			alert.accept();
			
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).clear();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[2]")).sendKeys("DDDDDD");
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).clear();
			
			driver.findElement(By.xpath("(//input[@class='cke_dialog_ui_input_text'])[3]")).sendKeys(dataMapList.get(i).get("an constructie"));
			
			driver.findElement(By.xpath("//a[@title='Replace All']")).click();
			
			app.wait(1);
			
			 alert=driver.switchTo().alert();
			
			alert.accept();
			
			app.wait(1);
			
			driver.findElement(By.xpath("//a[@title='Close']")).click();
			
			driver.findElement(By.xpath("(//div[contains(text(),'Destinatie:')]/following-sibling::div/descendant::input[@name='selOptions_1'])[1]")).click();
			
			driver.findElement(By.xpath("(//div[contains(text(),'Destinatie:')]/following-sibling::div/descendant::input[@name='selOptions_1'])[5]")).click();
			
			driver.findElement(By.xpath("(//div[contains(text(),'Destinatie:')]/following-sibling::div/descendant::input[@name='selOptions_1'])[7]")).click();
			
			
			
			
			driver.findElement(By.xpath("(//input[@value='Salveaza'])[2]")).click();
			
			

		}
		
		
		

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][1];

		data[0][0] = UtilKit.getTestData();

		return data;
	}

}
