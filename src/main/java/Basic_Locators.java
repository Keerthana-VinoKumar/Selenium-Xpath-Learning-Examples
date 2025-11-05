import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_Locators {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.saucedemo.com/");
		//Scenario-1 -> Find username and password and add value 
		driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Using ID
		driver.findElement(By.name("password")).sendKeys("secret_sauce"); //Using name
		
		//Scenario-2 -> Click Submit Button
		driver.findElement(By.className("submit-button")).click(); //Using ClassName
		Thread.sleep(5000);
		
		//Scenario-3 -> Click Add to cart for a product
		driver.findElement(By.cssSelector("a.shopping_cart_link")).click(); //Using CSS Selector
		
		//Scenario-4 -> Back to product page
		driver.findElement(By.id("continue-shopping")).click(); // Using CSS Selector class name
		
		//Scenario-5 -> Click Add to cart for a product on product page
		driver.findElement(By.cssSelector("div.inventory_item_name")).click(); //Using CSS Selector class name
		
		//Scenario-6 -> Click Particular product on product page
		//xpath with ancestor - find the item with name and use grandparents tag so that it relates and find the button we have only one button.
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_container']//button")).click(); //text()Function
		
		//Scenario-7 -> Back to product page 
		driver.findElement(By.id("react-burger-menu-btn")).click(); //Using ID
		driver.findElement(By.id("back-to-products")).click(); //Using ID
		Thread.sleep(1000);
		
		//Scenario-8 -> Logout from the page
		//driver.findElement(By.xpath("//a[text()='Logout']")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item_name")); //cssSelector
		for(WebElement product : products )
		{
			System.out.println("Product names are:" + product.getText());
		}
		
		//Scenario-9 -> Find number of products have Add to Cart button
		//xpath Functions 
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[last()]")).click(); //Text() Function
		List<WebElement> cart =driver.findElements(By.xpath("//button[contains(text() , 'Add to cart')]")); //Contains Function
		System.out.println("Number of Add to cart button:" +cart.size());
		
		//Scenario-10 -> Find number of products have remove button
		List<WebElement> remove =driver.findElements(By.xpath("//button[not(contains(text() , 'Add to cart'))]")); //Not Function
		System.out.println("Number of remove button:" +remove.size());
		
		//Scenario-11 -> Find product by product name
		String productname = driver.findElement(By.xpath("//div[normalize-space(text()) = 'Sauce Labs Backpack']")).getText();//Trims leading/trailing whitespace and collapses multiple spaces.
		System.out.println("Product name: " +productname);
		
		
		//Scenario-12 -> Find Last product on the page
		//xpath Axis - Navigating DOM Relationships with xpath function
		String LastProduct = driver.findElement(By.xpath("//div[@class='inventory_item'][last()]/descendant::div[@class='inventory_item_description']/child::div[@class='inventory_item_label']/child::a[@href='#']/child::div[@class='inventory_item_name ']")).getText();//Last Function
		System.out.println("Last Product: " +LastProduct);
		
		//Scenario-13 -> Find first product on the page
		String FirstProduct = driver.findElement(By.xpath("(//div[@class='inventory_item'])[position()=1]/descendant::div[@class='inventory_item_description']/child::div[@class='inventory_item_label']/child::a[@href='#']/child::div[@class='inventory_item_name ']")).getText();//Position function
		System.out.println("First Product: " +FirstProduct);
		
		//Scenario-14 -> Find the price of particular Product
		//xpath Axis - Navigating DOM Relationships 
		String price = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/child::div[@class='inventory_item_price']")).getText();
		System.out.println("Price : " +price);
		
		//Scenario-15 -> Find the description of particular Product
		String description = driver.findElement(By.xpath("(//div[@class='inventory_item'])[position()=1]/descendant::div[@class='inventory_item_description']/child::div[@class='inventory_item_label']/child::a[@href='#']/following-sibling::div[@class='inventory_item_desc']")).getText(); //following-sibling
		System.out.println("Description : " +description);
		driver.quit();
	
	}

}
