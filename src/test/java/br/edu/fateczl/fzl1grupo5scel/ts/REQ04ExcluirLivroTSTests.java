package br.edu.fateczl.fzl1grupo5scel.ts;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.fateczl.fzl1grupo5scel.po.LivroPageObject;
import br.edu.fateczl.fzl1grupo5scel.po.LoginPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class REQ04ExcluirLivroTSTests {

    private WebDriver driver;
    private LivroPageObject livroPO;
    private LoginPageObject loginPO;

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
    void CT01_LivroExcluidoComSucesso() {
        loginPO = new LoginPageObject(driver);
        livroPO = new LivroPageObject(driver);
        loginPO.login("jose", "123");
        livroPO.cadastrar("1571", "Carlos Alberto Heuser", "Projeto de Banco de Dados");
        livroPO.excluir();
        assertThrows(NoSuchElementException.class, () -> { livroPO.getResult(); });
    }
}
