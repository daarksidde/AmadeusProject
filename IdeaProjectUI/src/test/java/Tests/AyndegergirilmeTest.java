package Tests;

import org.openqa.selenium.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AyndegergirilmeTest {
  private WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://flights-app.pages.dev/");
    driver.manage().window().maximize();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void AyniDegerTest() throws InterruptedException {
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("#headlessui-combobox-button-\\3AR1a9lla\\3A > .h-5")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".text-indigo-200")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector("#headlessui-combobox-button-\\3AR1ahlla\\3A > .h-5")).click();
    Thread.sleep(500);
    try {
      WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Istanbul']"));

      if (element.isEnabled()) {
        System.out.println("Sitede bug var, aynı değerler seçilebiliyor.");

        throw new RuntimeException("Sitede bug var, aynı değerler seçilebiliyor.");
      } else {
        System.out.println("Elemente tıklanamıyor.");
      }
    } catch (org.openqa.selenium.NoSuchElementException e) {
      System.out.println("Element bulunamadı: " + e.getMessage());
    }

  }

  @Test
  public void UcusLondra() throws InterruptedException {
    Thread.sleep(1500);
    driver.findElement(By.cssSelector("#headlessui-combobox-button-\\3AR1a9lla\\3A > .h-5")).click();
    driver.findElement(By.cssSelector("#headlessui-combobox-option-\\3Ar0\\3A > .flex")).click();
    driver.findElement(By.cssSelector("#headlessui-combobox-button-\\3AR1ahlla\\3A > .h-5")).click();
    driver.findElement(By.xpath("//li[@id=\'headlessui-combobox-option-:rj:\']/div/span")).click();
    driver.findElement(By.cssSelector(".min-h-screen")).click();
    String expectedMessage = "Bu iki şehir arasında uçuş bulunmuyor. Başka iki şehir seçmeyi deneyebilirsiniz.";
    WebElement messageElement = driver.findElement(By.cssSelector(".mt-24"));
    String actualMessage = messageElement.getText();
    assertEquals(expectedMessage, actualMessage);
    System.out.println("Seçilen iki şehir arasında uçuş bulunmuyor! ");
  }

  @Test
  public void UcusLosAngeles() throws InterruptedException {
    Thread.sleep(500);
    driver.findElement(By.cssSelector("#headlessui-combobox-button-\\3AR1a9lla\\3A > .h-5")).click();
    driver.findElement(By.cssSelector("#headlessui-combobox-option-\\3Ar0\\3A > .flex")).click();
    Thread.sleep(500);

    driver.findElement(By.cssSelector("#headlessui-combobox-button-\\3AR1ahlla\\3A > .h-5")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/div/ul/li[7]/div/span[2]")).click();

    Assert.assertThat(driver.findElement(By.cssSelector(".mb-10")).getText(), is("Found 2 items"));
    System.out.println("Istanbul-Los Angeles seferinde 2 Uçuş Bulundu");



  }
}
