package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ByClassName {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testOtomasyonu ana sayfasına gidin

        // phone için arama yapın

        // arama sonucunda bulunan elementlerin, isimlerini yazdirin

        // arama sonucunda 4 urun bulunabildigini test edin

        // ilk urun isminde phone gectigini test edin

        // sayfayi kapatin



    }
}
