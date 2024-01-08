package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.drive","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.testotomasyonu.com");
        // get(istenen URL) ile aynı islemi yapar

        // youtube anasayfaya gidin
        driver.navigate().to("https://www.youtube.com");

        // titlein "Youtube" içerdigini test edin
        String expectedTitleIcerik = "YouTube";
        String acturlTitle = driver.getTitle();

        if (acturlTitle.contains(expectedTitleIcerik)){
            System.out.println("Yotube title test PASSED");
        } else {
            System.out.println("Youtube title testi FAILED");
        }

        // tekrar test otomasyonu anasayfasına dönun
        driver.navigate().back();

        // sayfa kaynagının "Test Otomasyonu icerdgini test edin
        String expectedSayfaIcerik = "Test Otomasyonu";
        String acturlSayfaKaynagi = driver.getPageSource();

        if (acturlSayfaKaynagi.contains(expectedSayfaIcerik)){
            System.out.println("Test otomasyonu sayfa kaynagı testi PASSED");
        } else {
            System.out.println("Test otomasyonu sayfa kaynagi testi FAILED");
        }

        // bir daha youtube anasayfaya gidin
        driver.navigate().forward();

        // URL'in https://www.youtube.com/ oldugunu test edin
        String expectedURL = "https://www.youtube.com";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("URL Testi PASSED");
        } else {
            System.out.println("URL Testi FAILED");
        }


        Thread.sleep(2000);
        driver.close();

    }
}
