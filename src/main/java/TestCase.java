import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class TestCase extends DriverFactory {

    static WebDriver driver = DriverFactory.driver();

    public static void main(String args[]) {

        driver.findElement(By.xpath("//div[@class='a4bIc']")).click();
        System.out.println("clicked on google search");

//        WebDriverWait wait= new WebDriverWait(driver,20);
//        WebElement elemet= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a4bIc']")));
//        System.out.println("Wait for 20 sec");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("ebay");
        System.out.println("entered ebay");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys(Keys.ENTER);
        System.out.println("clicked on search");
        driver.findElement(By.xpath("//h3[contains(text(),\"eBay: Electronics, Cars\")]")).click();
        System.out.println("clicked on ebay website");
        driver.findElement(By.xpath("//div[@class='gh-search-input__wrap']")).click();
        driver.findElement(By.xpath("//div[@class='gh-search-input__wrap']")).sendKeys("books");
        driver.findElement(By.xpath("//div[@class='gh-search-input__wrap']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[contains(text(),'1611 King James Bible 1st Edition')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Forgotten Home Apothecary II')]")).click();

        String parent = driver.getWindowHandle();
        driver.findElement(By.partialLinkText("Continue")).click();
        Set<String> s = driver.getWindowHandles();
        // Now iterate using Iterator
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                driver.findElement(By.xpath("//*[@id='atcBtn_btn_1']")).click();
            }

        }

       String Text= driver.findElement(By.xpath("//span[contains(text(),'Items')]")).getText();
        if ("Items (1)".equals(Text)) {
            System.out.println("Added cart number is correct");
        } else {
            System.out.println("Added cart number is incorrect");
        }
    }
}
