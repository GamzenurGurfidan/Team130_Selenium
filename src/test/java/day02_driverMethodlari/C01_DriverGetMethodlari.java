package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        // acilan sayfanin TİTLE'ında otomasyon gectiğini test edin

        String expectedTitleIcerik = "otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title 'otomasyon' içermiyor, title testi FAILED");
            System.out.println("Actual Title: " + actualTitle);
        }

        // acilan sayfanın URL 'inin otomasyon içerdigini test edin

        String expectedURLIcerik = "otomasyon";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURLIcerik)){
            System.out.println("URL testi PASSED");
        }else {
            System.out.println("URL otomasyon icermiyor, URL testi FAILED");
        }


        System.out.println(driver.getWindowHandle());
        // 1544995D5E0CC1FE23AB8E1544E45924
        System.out.println(driver.getWindowHandles());
        // [1544995D5E0CC1FE23AB8E1544E45924]

/*

        driver.getWindowHandle() : driverin gittigi sayfanın WindowHandle degerini verir

        driver.getWindowHandles() : driver olusturduktan sonra, test boyunca actigi tum
                                    sayfaların WindowsHandle degerlerini bir SET olarak verir.

 */


        System.out.println("\n----------- Sayfa Kaynagi-----------");
        System.out.println(driver.getPageSource());
        // tum sayfa kaynagını döndurur,
        // sayfa kaynagı ile ilgili bir test istenirse,
        // kaydedilip kullanılabilir




        Thread.sleep(3000); // javadan gelir kodlari yazilan milisaniye kadar bekletir

        driver.close();



    }
}
