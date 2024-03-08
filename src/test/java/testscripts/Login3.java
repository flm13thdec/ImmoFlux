package testscripts;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apollons.base.BaseTest;
import com.apollons.keywords.ApplicationKeywords;
import com.apollons.utils.UtilKit;

public class Login3 extends BaseTest {

	@Test(dataProvider = "getData")
	public void validateLoginTest(ArrayList<HashMap<String, String>> dataMapList) throws AWTException {
		
		System.out.println("dataMapList.size()"+dataMapList.size());
		
		for(int i=0;i<dataMapList.size();i++)
		{
			ApplicationKeywords app = new ApplicationKeywords();

			app.openBrowser();

			app.launchApp();
			
			app.type("login_username_textbox", configProperties.getProperty("username"));

			app.type("login_password_textbox", configProperties.getProperty("password"));

			app.click("login_login_button");
			
			app.click("adauga_Link");
			
			app.click("proprietate_link");
			
			//app.selectOptionFromDropdownUsingValue("stadiu_dropdown","2_1");
			
			app.click("stadiu_downarrow");
			
			app.click("inAsteptar_link");
			
			app.click("Tranzactie_downarrow");
			
			//app.click("Tranzactie_downarrow");
			
			app.click("Inchiriere_option");
			
			app.click("Proprietar_plus_button");
			
			app.type("Prenume_textbox", "Prenume Text");
			
			app.type("Nume_textbox", "Name_text");
			
			//app.type("Email_textbox", "email_text");
			
			app.type("Telefon_textbox", dataMapList.get(i).get("nr TEL"));
			
			app.click("Save_Button");
			
			//app.click("Oras_Div");
			
			//app.wait(5);
			
			app.click("Oras_Div");
			
			app.wait(5);
			
			app.typeAndEnter("Oras_textbox", "Bucuresti");
			
			app.wait(5);
			
			app.click("Zona_textbox");
			
			app.wait(5);
			
			app.typeAndEnter("Zona_textbox", "Lujerului");
			
			app.type("Strada_textbox", dataMapList.get(i).get("Str."));
			
			app.type("Numar_textbox", dataMapList.get(i).get("nr"));
			
			String colAD = "";
			if(!(dataMapList.get(i).get("OBS 1").equals("NA")| dataMapList.get(i).get("OBS 1").equals(null)))
			{
				colAD=dataMapList.get(i).get("OBS 1");
			}
			else
				colAD="";
			
			String colAE = "";
			if(!(dataMapList.get(i).get("OBS 2").equals("NA")| dataMapList.get(i).get("OBS 2").equals(null)))
			{
				colAE=dataMapList.get(i).get("OBS 2");
			}
			else
				colAE="";
			
			
			String privateMemo="LINK: "+dataMapList.get(i).get("LINK")+"\r\n"
					+ "Nume PROP: "+dataMapList.get(i).get("Nume")+"\r\n"
					+ "Comision: "+dataMapList.get(i).get("%") + "%\r\n"
					+ "Ultimul Pret: "+dataMapList.get(i).get("last Price")+"\r\n"
					+ "Mod plata: "+dataMapList.get(i).get("MOD Plata")+"\r\n"
					+ "ANAF: "+dataMapList.get(i).get("ANAF")+"\r\n"
					+ "Parcare: "+dataMapList.get(i).get("Parcari") +"-"+dataMapList.get(i).get("tip parcare")+"\r\n"
					+ "Disponibilitate: "+dataMapList.get(i).get("DISP")+"\r\n"
					+ "Adresa/Bloc: "+dataMapList.get(i).get("COMPLEX")+"\r\n"
					+ "Incalzire: "+dataMapList.get(i).get("HEAT")+"\r\n"
					+ "Zona: "+dataMapList.get(i).get("ZONA")+"\r\n"
					+ "An constructie: "+dataMapList.get(i).get("AN CONSTR")+"\r\n"
					+ "Etaj: "+dataMapList.get(i).get("etaj") +"/"+dataMapList.get(i).get("total etaje") +"\r\n"
					+ "Suprafata utila + balcon: "+dataMapList.get(i).get("S.U")+"\r\n"
					+ "Interval Vizionari: "+dataMapList.get(i).get("Interval VIZIONARI")+"\r\n"
					+ "Preferinte Clienti: "+dataMapList.get(i).get("Preferinte Clienti")+"\r\n"
					+ "Animale de companie: "+dataMapList.get(i).get("Pet Friendly")+"\r\n"
					+ "OBS 1: "+colAD+"\r\n"
					+ "OBS 2: "+colAE+"\r\n";
			
			
			app.type("Memo_Private_textarea", privateMemo);
			
			
		}
		
		
	
	}
	
	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][1];

		data[0][0] = UtilKit.getTestData();

		return data;
	}
	
	
	
	
}