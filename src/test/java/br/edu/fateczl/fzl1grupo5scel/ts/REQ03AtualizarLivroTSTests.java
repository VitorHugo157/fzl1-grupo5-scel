package br.edu.fateczl.fzl1grupo5scel.ts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class REQ03AtualizarLivroTSTests {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ts-scel.herokuapp.com");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void esperar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void CT01_LivroAlteradoComSucesso() {
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("jose");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button")).click();
        esperar();
        driver.findElement(By.linkText("Livros")).click();
        esperar();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("1571");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Carlos Alberto Heuser");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Projeto de Banco de Dados");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        esperar();
        driver.findElement(By.cssSelector("tr:nth-child(2) .btn-primary")).click();
        esperar();
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).clear();
        driver.findElement(By.id("autor")).sendKeys("Carlos A. Heuser");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).clear();
        driver.findElement(By.id("titulo")).sendKeys("Banco de Dados");
        esperar();
        driver.findElement(By.cssSelector(".btn")).click();
        esperar();
        assertEquals("Carlos A. Heuser", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(4)")).getText());
        driver.findElement(By.cssSelector("tr:nth-child(2) .delete")).click();
    }
}
