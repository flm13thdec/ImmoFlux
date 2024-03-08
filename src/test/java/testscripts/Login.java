package testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apollons.base.BaseTest;
import com.apollons.keywords.ApplicationKeywords;
import com.apollons.utils.UtilKit;

public class Login extends BaseTest {

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
		
			
	}
	
	@Test(dataProvider = "getData")
	public void validateLoginTest(ArrayList<HashMap<String, String>> dataMapList) throws AWTException {
		
		System.out.println("dataMapList.size()"+dataMapList.size());
		
		for(int i=0;i<dataMapList.size();i++)
		{
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
			
			app.click("SaveForm_Button");
			
			// Caracteristici Module 
			
			app.click("Caracteristici_Link");
			
			app.click("Compartimentare_dropdown_downarrow");
			
			app.selectOptionFromListDropdown( dataMapList.get(i).get("compartimentare"));
			
			app.click("Destinatie_dropdown_downarrow");
			
			app.selectOptionFromListDropdown("Rezidentiala");
			
			app.click("Confort_dropdown_downarrow");
			
			app.selectOptionFromListDropdown("1");
			
			app.type("Camere_textbox", dataMapList.get(i).get("Nr Camere"));
			
			app.type("Dormitoare_textbox", dataMapList.get(i).get("Nr Dormitoare"));
			
			app.type("Bucatarii_textbox", "1");
			
			app.type("Bai_textbox", dataMapList.get(i).get("nr bai"));
			
			app.type("Balcoane_textbox", dataMapList.get(i).get("nr balc"));
			
			app.click("Etaj_dropdown_downarrow");
			
			app.selectOptionFromListDropdown("Etaj "+dataMapList.get(i).get("etaj"));
			
			app.click("Orientare_dropdown_downarrow");
			
			app.selectOptionFromListDropdown("Mixta");
			
			app.type("constructie_textbox", dataMapList.get(i).get("AN CONSTR"));
			
			app.type("Parcari_textbox", dataMapList.get(i).get("Parcari"));
			
			app.type("Suprafata_utila_textbox", dataMapList.get(i).get("S.U"));
			
			app.type("Suprafata_construita_textbox", dataMapList.get(i).get("S.C"));
			
			app.click("Stadiu_constructie_dropdown_downarrow");
			
			app.selectOptionFromListDropdown("Finalizata");
			
			app.click("Tip_dropdown_downarrow");
			
			app.selectOptionFromListDropdown("Bloc");
			
			app.click("Structura_dropdown_downarrow");
			
			app.selectOptionFromListDropdown("Beton");
			
			app.type("building_levels_textbox", dataMapList.get(i).get("total etaje"));
			
			app.click("Clasa_energetica_dropdown_downarrow");
			
			app.selectOptionFromListDropdown("A");
			
			app.click("SaveForm_Tick_Button");
			
			// Utilitati Module 
			
			app.click("Curent_electric_Checkbox");
			
			app.click("Apa_Checkbox");
			
			app.click("Canalizare_Checkbox");
			
			app.click("Gaz_Checkbox");
			
			String columnR=dataMapList.get(i).get("HEAT");
			
			if(columnR.equalsIgnoreCase("Termoficare"))
			{
				app.click("Termoficare_Checkbox");
				app.click("Calorifere_Checkbox");
			}
			else 	if(columnR.equalsIgnoreCase("CT"))
			{
				app.click("Centrala_proprie_Checkbox");
				app.click("Calorifere_Checkbox");
			}
			else 	if(columnR.equalsIgnoreCase("CT + P"))
			{
				app.click("Centrala_proprie_Checkbox");
				app.click("Incalzire_pardoseala_Checkbox");
			}
			else 	if(columnR.equalsIgnoreCase("CI"))
			{
				app.click("Centrala_imobil_Checkbox");
				app.click("Calorifere_Checkbox");
			}
			else if(columnR.equalsIgnoreCase("CI + convect"))
			{
				app.click("Centrala_imobil_Checkbox");
				app.click("Convectoare_Checkbox");
				app.click("Incalzire_pardoseala_Checkbox");
				app.click("Calorifere_Checkbox");
			}
				
			app.click("Aer_conditionat_Checkbox");
			
			app.click("Ultrafinisat_Radiobutton");
			
			app.click("Exterior_Checkbox");
			
			app.click("Vopsea_lavabila_Checkbox");
			
			app.click("Faianta_Checkbox");
			
			app.click("Parchet_Checkbox");
			
			app.click("Gresie_Checkbox");
			
			app.click("Ferestre_PVC_Checkbox");
			
			app.click("Usa_intrare_Metal_Checkbox");
			
			app.click("Usa_interior_Lemn_Checkbox");
			
			app.click("Usi_interior_Lemn_Checkbox");
			
			app.click("Lux_Radiobutton");
			
			if(Integer.parseInt(dataMapList.get(i).get("nr bai"))>=2)
			{
				app.click("Wc_serviciu_Checkbox");
			}
			
			app.click("Complet_Radiobutton");
			
			app.click("Mobilata_Checkbox");
			
			app.click("Utilata_Checkbox");
			
			app.click("Apometre_Checkbox");
			
			app.click("Contor_gaz_Checkbox");
			
			app.click("Contor_curent_electric_Checkbox");
			
			app.click("Contorizare_separata_Checkbox");
			
			app.click("Interfon_Checkbox");
			
			app.click("Lift_Checkbox");
			
			app.click("Asfaltate_Checkbox");
			
			app.click("Betonate_Checkbox");
			
			app.click("Iluminat_stradal_Checkbox");
			
			app.click("Mijloace_de_transport_in_comun_Checkbox");
			
			app.click("SaveForm_Button");
			
			
			//Pret Module 
			
			app.type("Pret_textbox", dataMapList.get(i).get("Price"));
			
			app.type("Comision_proprietar_textbox", dataMapList.get(i).get("%"));
			
			app.click("SaveForm_Button");
			
			app.type("Titlu_textbox", dataMapList.get(i).get("TITLU"));
			
			String coulmnF=null;
			
			if(dataMapList.get(i).get("compartimentare").equalsIgnoreCase("Semidecomandat"))
			{
				coulmnF ="semidecomandată";
			}
			else if(dataMapList.get(i).get("compartimentare").equalsIgnoreCase("Decomandat"))
			{
				coulmnF ="decomandată";
			} 
			
			 String descriere_text2="";
			
			 if(dataMapList.get(i).get("tip parcare").equalsIgnoreCase("Fara"))
			 {
				 descriere_text2="*Posibilitate de parcare în zonă sau contracost. \r\n"
				 		+ "*Centrala termică cu încălzire în calorifere XXXXXX pardoseală adaugă un plus de confort.\r\n"
				 		+ "*Contractul poate fi inregistrat la Administrația Financiară.\r\n"
				 		+ "*Modalitatea de plată la semnarea contractului : 1 lună avans + 1 lună garanție + 50% comision \r\n"
				 		+ "catre agenție.\r\n"
				 		+ "*Oportunitatea de MUTARE IMEDIATĂ reprezintă un avantaj suplimentar, astfel încât să incepeți \r\n"
				 		+ "sa va bucurați de acest spațiu cât mai curând posibil. \r\n"
				 		+ "Pentru mai multe detalii despre oferta prezentata sau alte oferte similare, va stam la dispozitie \r\n"
				 		+ "la numarul de telefon din anunt sau pe Whatsapp de L-D in intervalul orar 08:00-21:00.Suna \r\n"
				 		+ "Acum si rezerva o vizionare";
			 }else  if(dataMapList.get(i).get("tip parcare").equalsIgnoreCase("parcare subterana"))
			 {
				 descriere_text2= "*Se asigură un loc de parcare subteran.\r\n"
				 		+ "*Centrala termică cu încălzire în calorifere XXXXXX pardoseală adaugă un plus de confort.\r\n"
				 		+ "*Contractul poate fi inregistrat la Administrația Financiară.\r\n"
				 		+ "*Modalitatea de plată la semnarea contractului : 1 lună avans + 1 lună garanție + 50% comision \r\n"
				 		+ "catre agenție.\r\n"
				 		+ "*Oportunitatea de MUTARE IMEDIATĂ reprezintă un avantaj suplimentar, astfel încât să incepeți \r\n"
				 		+ "sa va bucurați de acest spațiu cât mai curând posibil. \r\n"
				 		+ "Pentru mai multe detalii despre oferta prezentata sau alte oferte similare, va stam la dispozitie \r\n"
				 		+ "la numarul de telefon din anunt sau pe Whatsapp de L-D in intervalul orar 08:00-21:00.Suna \r\n"
				 		+ "Acum si rezerva o vizionare";
			 }else  if(dataMapList.get(i).get("tip parcare").equalsIgnoreCase("parcare supraterana"))
			 {
				 descriere_text2= "*Se asigură un loc de parcare suprateran.\r\n"
				 		+ "*Centrala termică cu încălzire în calorifere XXXXXX pardoseală adaugă un plus de confort.\r\n"
				 		+ "*Contractul poate fi inregistrat la Administrația Financiară.\r\n"
				 		+ "*Modalitatea de plată la semnarea contractului : 1 lună avans + 1 lună garanție + 50% comision \r\n"
				 		+ "catre agenție.\r\n"
				 		+ "*Oportunitatea de MUTARE IMEDIATĂ reprezintă un avantaj suplimentar, astfel încât să incepeți \r\n"
				 		+ "sa va bucurați de acest spațiu cât mai curând posibil. \r\n"
				 		+ "Pentru mai multe detalii despre oferta prezentata sau alte oferte similare, va stam la dispozitie \r\n"
				 		+ "la numarul de telefon din anunt sau pe Whatsapp de L-D in intervalul orar 08:00-21:00.Suna \r\n"
				 		+ "Acum si rezerva o vizionare";
				 
			 }else  if(dataMapList.get(i).get("HEAT").equalsIgnoreCase("Termoficare"))
			 {
				 descriere_text2="*Posibilitate de parcare în zonă sau contracost. \r\n"
				 		+ "*Se asigură un loc de parcare subteran.\r\n"
				 		+ "*Se asigură un loc de parcare suprateran.\r\n"
				 		+ "*Contractul poate fi inregistrat la Administrația Financiară.\r\n"
				 		+ "*Modalitatea de plată la semnarea contractului : 1 lună avans + 1 lună garanție + 50% comision \r\n"
				 		+ "catre agenție.\r\n"
				 		+ "*Oportunitatea de MUTARE IMEDIATĂ reprezintă un avantaj suplimentar, astfel încât să incepeți \r\n"
				 		+ "sa va bucurați de acest spațiu cât mai curând posibil. \r\n"
				 		+ "Pentru mai multe detalii despre oferta prezentata sau alte oferte similare, va stam la dispozitie \r\n"
				 		+ "la numarul de telefon din anunt sau pe Whatsapp de L-D in intervalul orar 08:00-21:00.Suna \r\n"
				 		+ "Acum si rezerva o vizionare!";
			 }else  if(dataMapList.get(i).get("HEAT").equalsIgnoreCase("CT"))
			 {
				 descriere_text2="*Posibilitate de parcare în zonă sau contracost. \r\n"
				 		+ "*Se asigură un loc de parcare subteran.\r\n"
				 		+ "*Se asigură un loc de parcare suprateran.\r\n"
				 		+"*Centrala termică cu încălzire în calorifere adaugă un plus de confort.\r\n"
				 		+ "*Contractul poate fi inregistrat la Administrația Financiară.\r\n"
				 		+ "*Modalitatea de plată la semnarea contractului : 1 lună avans + 1 lună garanție + 50% comision \r\n"
				 		+ "catre agenție.\r\n"
				 		+ "*Oportunitatea de MUTARE IMEDIATĂ reprezintă un avantaj suplimentar, astfel încât să incepeți \r\n"
				 		+ "sa va bucurați de acest spațiu cât mai curând posibil. \r\n"
				 		+ "Pentru mai multe detalii despre oferta prezentata sau alte oferte similare, va stam la dispozitie \r\n"
				 		+ "la numarul de telefon din anunt sau pe Whatsapp de L-D in intervalul orar 08:00-21:00.Suna \r\n"
				 		+ "Acum si rezerva o vizionare!";
			 }else  if(dataMapList.get(i).get("HEAT").equalsIgnoreCase("CT + P"))
			 {
				 descriere_text2="*Posibilitate de parcare în zonă sau contracost. \r\n"
				 		+ "*Se asigură un loc de parcare subteran.\r\n"
				 		+ "*Se asigură un loc de parcare suprateran.\r\n"
				 		+"*Centrala termică cu încălzire în pardoseală adaugă un plus de confort.\r\n"
				 		+ "*Contractul poate fi inregistrat la Administrația Financiară.\r\n"
				 		+ "*Modalitatea de plată la semnarea contractului : 1 lună avans + 1 lună garanție + 50% comision \r\n"
				 		+ "catre agenție.\r\n"
				 		+ "*Oportunitatea de MUTARE IMEDIATĂ reprezintă un avantaj suplimentar, astfel încât să incepeți \r\n"
				 		+ "sa va bucurați de acest spațiu cât mai curând posibil. \r\n"
				 		+ "Pentru mai multe detalii despre oferta prezentata sau alte oferte similare, va stam la dispozitie \r\n"
				 		+ "la numarul de telefon din anunt sau pe Whatsapp de L-D in intervalul orar 08:00-21:00.Suna \r\n"
				 		+ "Acum si rezerva o vizionare!";
			 }
			 else  if(dataMapList.get(i).get("HEAT").equalsIgnoreCase("CI"))
			 {
				 descriere_text2="*Posibilitate de parcare în zonă sau contracost. \r\n"
				 		+ "*Se asigură un loc de parcare subteran.\r\n"
				 		+ "*Se asigură un loc de parcare suprateran.\r\n"
				 		+"*Centrala imobil cu încălzire în calorifere adaugă un plus de confort.\r\n"
				 		+ "*Contractul poate fi inregistrat la Administrația Financiară.\r\n"
				 		+ "*Modalitatea de plată la semnarea contractului : 1 lună avans + 1 lună garanție + 50% comision \r\n"
				 		+ "catre agenție.\r\n"
				 		+ "*Oportunitatea de MUTARE IMEDIATĂ reprezintă un avantaj suplimentar, astfel încât să incepeți \r\n"
				 		+ "sa va bucurați de acest spațiu cât mai curând posibil. \r\n"
				 		+ "Pentru mai multe detalii despre oferta prezentata sau alte oferte similare, va stam la dispozitie \r\n"
				 		+ "la numarul de telefon din anunt sau pe Whatsapp de L-D in intervalul orar 08:00-21:00.Suna \r\n"
				 		+ "Acum si rezerva o vizionare!";
			 }
			 else  if(dataMapList.get(i).get("HEAT").equalsIgnoreCase("CI + convect"))
			 {
				 descriere_text2="*Posibilitate de parcare în zonă sau contracost. \r\n"
				 		+ "*Se asigură un loc de parcare subteran.\r\n"
				 		+ "*Se asigură un loc de parcare suprateran.\r\n"
				 		+"*Centrala imobil cu încălzire în pardoseală si calorifere + convectoare adaugă un plus de confort.\r\n"
				 		+ "*Contractul poate fi inregistrat la Administrația Financiară.\r\n"
				 		+ "*Modalitatea de plată la semnarea contractului : 1 lună avans + 1 lună garanție + 50% comision \r\n"
				 		+ "catre agenție.\r\n"
				 		+ "*Oportunitatea de MUTARE IMEDIATĂ reprezintă un avantaj suplimentar, astfel încât să incepeți \r\n"
				 		+ "sa va bucurați de acest spațiu cât mai curând posibil. \r\n"
				 		+ "Pentru mai multe detalii despre oferta prezentata sau alte oferte similare, va stam la dispozitie \r\n"
				 		+ "la numarul de telefon din anunt sau pe Whatsapp de L-D in intervalul orar 08:00-21:00.Suna \r\n"
				 		+ "Acum si rezerva o vizionare!";
			 }
			 
			 //
			String descriere_text1="Se oferă spre închiriere un apartament de "+dataMapList.get(i).get("Nr Camere")+" camere in zona "+dataMapList.get(i).get("ZONA")+".\r\n"
					+ "Dispune de un spațiu generos de "+dataMapList.get(i).get("S.U")+" mp, iar compartimentarea "+ coulmnF+" asigură o distribuție "
					+ "optimă a spațiului, oferind un confort de grad 1. Situat la etajul "+dataMapList.get(i).get("etaj") +" din "+dataMapList.get(i).get("total etaje")+" într-un bloc \r\n"
					+ "finalizat în anul "+dataMapList.get(i).get("AN CONSTR")+", apartamentul este MOBILAT si UTILAT COMPLET, pregătit să \r\n"
					+ "îndeplinească toate cerințele și așteptările dumneavoastră. \r\n"
					+ "Design-ul actual și finisajele de înaltă calitate fac din aceasta locuinţă o ALEGERE PERFECTĂ atât \r\n"
					+ "pentru o singură pesoană, cât si pentru un cuplu care aspira spre o viață liniștită și confortabilă \r\n"
					+ "într-un mediu urban";
			String descriere_text = descriere_text1 +"\n"+descriere_text2;
			
			app.type("Descriere_textarea", descriere_text);
			
			app.clear("Disponibilitate_textbox");
			
			app.type("Disponibilitate_textbox", dataMapList.get(i).get("DISP"));
			
			app.click("SaveForm_Button");
			
			app.click("Upload_Icon");
			
			System.out.println(System.getProperty("user.dir")+"\\photos");
			
			String photosFolder=System.getProperty("user.dir")+"\\photos";
			
			StringSelection stringSelection = new StringSelection(photosFolder);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	        Robot robot = null;
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	        robot.delay(2500);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(1500);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	        robot.delay(3000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        
	        robot.delay(1000);
	        
	       	        
	       
	        
	     // Press CTRL+A
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);

			// Release CTRL+A
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_A);
	        
			robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
			
			
		}
		
		
	
	}
	
	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][1];

		data[0][0] = UtilKit.getTestData();

		return data;
	}
	
	
	
	
}