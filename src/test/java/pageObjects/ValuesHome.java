package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValuesHome {

	WebDriver driver;

	public ValuesHome(WebDriver driver) {
		this.driver = driver;
	}

	By Value1_Label = By.id("lbl_val_1");
	By Value2_Label = By.id("lbl_val_2");
	By Value3_Label = By.id("lbl_val_3");
	By Value4_Label = By.id("lbl_val_4");
	By Value5_Label = By.id("lbl_val_5");

	By Value1_Textbox = By.id("txt_val_1");
	By Value2_Textbox = By.id("txt_val_2");
	By Value3_Textbox = By.id("txt_val_3");
	By Value4_Textbox = By.id("txt_val_4");
	By Value5_Textbox = By.id("txt_val_5");

	By TotalBalance_Label = By.id("lbl_ttl_val");
	By TotalBalance_TextBox = By.id("txt_ttl_val");
	
	
	Map<String, String> values = new HashMap<String, String>();

	public int returnLabelCount() {
		String commonLabelIds = "lbl_val_";
		String actualLabelId;
		List<WebElement> labels = new ArrayList<WebElement>();
		int i = 1;
		while (i <= 5) {
			actualLabelId = commonLabelIds + i;
			labels.add(driver.findElement(By.id(actualLabelId)));
			i++;
		}
		return labels.size();
	}

	public int returnValueCount() {
		String commonLabelIds = "txt_val_";
		String actualLabelId;
		List<WebElement> values = new ArrayList<WebElement>();
		int i = 1;
		while (i <= 5) {
			actualLabelId = commonLabelIds + i;
			values.add(driver.findElement(By.id(actualLabelId)));
			i++;
		}
		return values.size();
	}

	public List<WebElement> valueTextboxes() {
		String commonLabelIds = "txt_val_";
		String actualLabelId;
		List<WebElement> values = new ArrayList<WebElement>();
		int i = 1;
		while (i <= 5) {
			actualLabelId = commonLabelIds + i;
			values.add(driver.findElement(By.id(actualLabelId)));
			i++;
		}
		return values;
	}

	public String totalBalance() {
		return driver.findElement(TotalBalance_TextBox).getText();
	}

}
