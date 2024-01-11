package day04_locators_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_XPath {
    public static void main(String[] args) throws InterruptedException {

        // 1- bir class olusturun
        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        // 4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        // 5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title testi PASSED");
        } else System.out.println( "Title testi FAILED");

        // 6- Furniture linkine tiklayin
        driver.findElement(By.xpath("(//li[@class='has-sub'])[5]")).click();

        // 7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin

        WebElement minDegerKutusu = driver.findElement(By.xpath("//input[@name='min']"));
        WebElement maxDegerKutusu = driver.findElement(By.xpath("//input[@name='max']"));

        minDegerKutusu.clear();
        minDegerKutusu.sendKeys("40");
        maxDegerKutusu.clear();
        maxDegerKutusu.sendKeys("200");

        driver.findElement(By.xpath("//button[@class='price-range-button']")).click();

        // 8- filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunlerListesi =
                driver.findElements(By.xpath("//div[@class='product-box mb-2 pb-1']"));

        int actualBulunanUrunSayisi = bulunanUrunlerListesi.size();

        if (actualBulunanUrunSayisi > 0) {
            System.out.println("Urun testi PASSED");
        } else System.out.println("Urun testi FAILED");

        // 10-Ilk urunu tiklayin
        bulunanUrunlerListesi.get(0).click();

        // 11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement urunFiyati =
                driver.findElement(By.xpath("//span[@id='priceproduct']"));

        int intUrunFiyati = Integer.parseInt(urunFiyati.getText().replaceAll("\\D","").substring(0, 2));

        if (intUrunFiyati >= 40  && intUrunFiyati <= 200){
            System.out.println("PASSED");
        } else System.out.println("FAILED");



        // 12-Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();

    }

}
