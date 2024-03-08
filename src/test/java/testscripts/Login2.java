package testscripts;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apollons.base.BaseTest;
import com.apollons.keywords.ApplicationKeywords;
import com.apollons.utils.UtilKit;

public class Login2 extends BaseTest {

	@Test(dataProvider = "getData")
	public void validateLoginTest(ArrayList<HashMap<String, String>> dataMapList) throws AWTException {
		
		System.out.println("dataMapList.size()"+dataMapList.size());
		
		for(int i=0;i<dataMapList.size();i++)
		{
			ApplicationKeywords app = new ApplicationKeywords();

			
			String link=dataMapList.get(i).get("LINK");
			
			System.out.println(link);
			
			String privateMemo="LINK: COL AF\r\n"
					+ "Nume PROP: Col A\r\n"
					+ "Comision: COL S + “%”\r\n"
					+ "Ultimul Pret: COL U\r\n"
					+ "Mod plata: COL AA\r\n"
					+ "ANAF: COL V\r\n"
					+ "Parcare: COL N + “-“ + COL W\r\n"
					+ "Disponibilitate: COL Z\r\n"
					+ "Adresa/Bloc: COL X\r\n"
					+ "Incalzire: COL R\r\n"
					+ "Zona: COL C\r\n"
					+ "An constructie: COL M\r\n"
					+ "Etaj: COL L + “/” + COL Q\r\n"
					+ "Suprafata utila + balcon: COL O\r\n"
					+ "Interval Vizionari: COL AB\r\n"
					+ "Preferinte Clienti: COL AC\r\n"
					+ "Animale de companie: COL Y\r\n"
					+ "OBS 1: COL AD if is empty don’t write nothing\r\n"
					+ "OBS 2: COL AE if is empty don’t write nothing\r\n";
			
		
			
		}
		
		
	
	}
	
	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][1];

		data[0][0] = UtilKit.getTestData();

		return data;
	}
	
	
	
	
}