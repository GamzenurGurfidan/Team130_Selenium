package day04_locators_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        // 2 ) DSLR Camera’yi etrafindaki elementleri kullanarak
        //     3 farkli relative locator ile locate edip tiklayin
        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));


        // 3 ) Acilan urunun DSLR Camera oldugunu test edin.

        // 1. relative lovate işlemi + click + testi ayri ayri yapalım

        WebElement dslrCamera1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(appleKulaklik));
        dslrCamera1.click();

        WebElement urunIsimElemeti = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsimElemeti.getText();

        if (actualUrunIsmi.contains(expectedUrunIsmi)){
            System.out.println("1. relative locator testi PASSED");
        } else {
            System.out.println("1. relative locator testi FAILED");
        }

        Thread.sleep(2000);
        // 2. relative lovate işlemi + click + testi ayri ayri yapalım

        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));

        WebElement dslrCamera2 = driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelefon));
        dslrCamera2.click();

        expectedUrunIsmi = "DSLR Camera";
        urunIsimElemeti = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElemeti.getText();

        if (actualUrunIsmi.contains(expectedUrunIsmi)){
            System.out.println("2. relative locator testi PASSED");
        } else {
            System.out.println("2. relative locator testi FAILED");
        }

        // 3. relative lovate işlemi + click + testi ayri ayri yapalım

        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement batKulaklık= driver.findElement(By.id("pic2_thumb"));

        WebElement dslrCamera3 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(batKulaklık));

        dslrCamera3.click();

        expectedUrunIsmi = "DSLR Camera";
        urunIsimElemeti = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElemeti.getText();

        if (actualUrunIsmi.contains(expectedUrunIsmi)){
            System.out.println("3. relative locator testi PASSED");
        } else {
            System.out.println("3. relative locator testi FAILED");
        }


        Thread.sleep(3000);
        driver.quit();

    }
}
