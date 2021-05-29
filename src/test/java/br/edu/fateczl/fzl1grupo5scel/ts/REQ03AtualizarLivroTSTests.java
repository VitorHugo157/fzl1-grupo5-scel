package br.edu.fateczl.fzl1grupo5scel.ts;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.fateczl.fzl1grupo5scel.po.LivroPageObject;
import br.edu.fateczl.fzl1grupo5scel.po.LoginPageObject;
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

    @Test
    void CT01_LivroAlteradoComSucesso() {
        loginPO = new LoginPageObject(driver);
        livroPO = new LivroPageObject(driver);
        loginPO.login("jose", "123");
        livroPO.cadastrar("1571", "Carlos Alberto Heuser", "Projeto de Banco de Dados");
        livroPO.atualizar("", "Carlos A. Heuser", "Banco de Dados");
        assertEquals("Carlos A. Heuser", livroPO.getResult());
        livroPO.excluir();
    }
}
