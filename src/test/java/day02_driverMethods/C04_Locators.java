package day02_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Locators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        driver.get("https://www.testotomasyonu.com");

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        // arama kutusuna phone yazıp aratalım
        aramaKutusu.sendKeys("phone");

        // aratma yapabilmek için entera basın
        aramaKutusu.submit();

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        System.out.println(aramaSonucElementi);
        // [[ChromeDriver: chrome on windows (4e130669fefdb1b5bb58cb7548c42c92)] -> class name: product-count-text]

        // aramaSonuzElementinin data türü webElement
        // WebElementler sout ile direct yazdırılamaz
        // getText() ile webElement uzerindeki yazi alinabilir

        System.out.println(aramaSonucElementi.getText());

        String sonucYazisi = aramaSonucElementi.getText();

        sonucYazisi = sonucYazisi.replaceAll("\\D","");

        System.out.println(sonucYazisi);

        int sonucSayisi = Integer.parseInt(sonucYazisi);

        if (sonucSayisi > 0){
            System.out.println("Arama testi PASSED");
        } else {
            System.out.println("Arama testi FAILED ");
        }


        Thread.sleep(3000);
        driver.quit();

    }
}
