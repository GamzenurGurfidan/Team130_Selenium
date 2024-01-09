package day02_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testOtomasyonu ana sayfasına gidin
        driver.navigate().to("https://testotomasyonu.com/");

        // phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // arama sonucunda bulunan elementlerin, isimlerini yazdirin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//a[@class='prod-title mb-3 ']"));
/*
        Locate etmek için By.className methodu kullandıgımızda
        HTML elementdeki class attributeunun degerinde
        space varsa
        By.className() calısmayabilir
 */

        // liste WebElementlerden olustugu icin,
        // listeyi direkt yazdirirsak, elementlerin referanslarını yazdirir

        for (WebElement each : bulunanUrunElementleriList) {
            System.out.println(each.getText());
        }

        // arama sonucunda 4 urun bulunabildigini test edin
        int expectedUrunSayisi = 4 ;
        int actualUrunSayisi = bulunanUrunElementleriList.size();

        if (expectedUrunSayisi == actualUrunSayisi){
            System.out.println("Phone arama urun sayi testi PASSED");
        }else {
            System.out.println("Phone arama urun sayi testi FAILED");
        }

        // ilk urun isminde phone gectigini test edin
        String actualIlkUrunIsmi = bulunanUrunElementleriList.get(0).getText();
        String expectedUrunIcerik = "phone";

        if (actualIlkUrunIsmi.contains(expectedUrunIcerik)){
            System.out.println("ilk ürün isim testi PASSED");
        } else {
            System.out.println("ilk ürün isim testi FAILED");
        }

        // sayfayi kapatin


        Thread.sleep(3000);
        driver.quit();
    }
}
