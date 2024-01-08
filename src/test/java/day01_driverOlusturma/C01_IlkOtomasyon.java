package day01_driverOlusturma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {
    public static void main(String[] args) {

        /*
            1 - web otomasyonu olusturmak için olusturdugumuz her classda
                bir WebDriver objesi olusturmak zorundayız

                bu objeyi Java conseptlerini kullanarak
                farkli sekillerde olusturabilir veya inherit edebiliriz
                AMMA WebDriver objesi OLMADAN test otomasyonu OLMAZ

            2 - Selenium son versiyonlarinda kendi WebDriver'ini olusturdu
                Boylece System.setproperty() kullanmasanız da
                Selenium kendi WebDriver'i ile otomasyonu gerceklertirir.

                Sirketlerde kendi satin aldiklari WebDriveri kullanma olasiligi olacagindan
                biz de bu satiri yazacagiz

            3 - WebDriver driver = new ChromeDriver();
                satirini yazdigimizda, bir WebDrivee objesi olusturulur
                bu obje sayesinde WebDriver methodlarini kullanabiliriz.

         */

        // System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // driver.get("https://www.testotomasyonu.com");

    }
}
