package stepDefinitions;

import java.util.Currency;
import java.util.Locale;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ValuesHome;
import testBase.TestSetup;

public class StepDefs {

	TestSetup ts = new TestSetup();
	ValuesHome vh = new ValuesHome(TestSetup.driver);

	@Given("Opened {string} browser")
	public void opened_browser(String browserName) throws Exception {
		ts.openBrowser(browserName);
	}

	@When("Navigated to {string} URL")
	public void navigated_to_url(String url) {
		try {
			TestSetup.driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Verify the count of Value labels and Value textboxes are equal")
	public void verify_the_count_of_value_labels_and_value_textboxes_are_equal() throws Exception {
		if (vh.returnLabelCount() != vh.returnValueCount())
			throw new Exception("Value labels and Value textboxes count are mismatching");
	}

	@Then("Verify the count is {string} for both labels and textboxes")
	public void verify_the_count_is_for_both_labels_and_textboxes(String count) throws Exception {
		int countInteger = Integer.parseInt(count);
		if (vh.returnLabelCount() != countInteger || vh.returnValueCount() != countInteger)
			throw new Exception("Value labels and Value textboxes count are not equal to: " + count);
	}

	@Then("Verify each of the values on the screen are greater than {string}")
	public void verify_each_of_the_values_on_the_screen_are_greater_than(String zero) throws Exception {
		double baseValue = Double.parseDouble(zero);
		String actualValue;
		for (WebElement e : vh.valueTextboxes()) {
			actualValue = e.getText().replace("$", "").replace(",", "");
			double actualValueInDouble = Double.parseDouble(actualValue);
			if (actualValueInDouble <= baseValue)
				throw new Exception("Value is not greater than 0");
		}
	}

	@Then("Verify the total balance is equal to sum of all values listed on screen")
	public void verify_the_total_balance_is_equal_to_sum_of_all_values_listed_on_screen() throws Exception {
		String totalBalance = vh.totalBalance();
		totalBalance = totalBalance.replace("$", "").replace(",", "");
		double totalBal = Double.parseDouble(totalBalance);

		double sum = 0;
		for (WebElement e : vh.valueTextboxes()) {
			String value = e.getText().replace("$", "").replace(",", "");
			sum = sum + Double.parseDouble(value);
		}

		if (totalBal != sum)
			throw new Exception("Total Balance is not equal to sum of all listed values");
	}

	@Then("Verify the listed values are formatted as currencies")
	public void verify_the_listed_values_are_formatted_as_currencies() throws Exception {
		Currency currency = Currency.getInstance(Locale.US);
		String symbol = currency.getSymbol();
		String actualValue;
		for (WebElement e : vh.valueTextboxes()) {
			actualValue = e.getText();
			if (actualValue.startsWith(symbol) || !actualValue.endsWith(symbol))
				throw new Exception("Value is not in currency format");
		}
	}

	@Then("Verify the sum of values listed is equal to the total balance field")
	public void verify_the_sum_of_values_listed_is_equal_to_the_total_balance_field() throws Exception {
		String totalBalance = vh.totalBalance();
		totalBalance = totalBalance.replace("$", "").replace(",", "");
		double totalBal = Double.parseDouble(totalBalance);

		double sum = 0;
		for (WebElement e : vh.valueTextboxes()) {
			String value = e.getText().replace("$", "").replace(",", "");
			sum = sum + Double.parseDouble(value);
		}

		if (totalBal != sum)
			throw new Exception("Total Balance is not equal to sum of all listed values");
	}
}
