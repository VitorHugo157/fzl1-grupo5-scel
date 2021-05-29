package br.edu.fateczl.fzl1grupo5scel.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AtualizarLivroPage {

    private WebDriver driver;
    private By isbnBy = By.id("isbn");
    private By autorBy = By.id("autor");
    private By tituloBy = By.id("titulo");
    private By btnAtualizarLivroBy = By.cssSelector(".btn");
    private By btnExcluirLivroBy = By.cssSelector("tr:nth-child(2) .delete");
    private By resultBy = By.cssSelector("tr:nth-child(2) > td:nth-child(4)");

    public AtualizarLivroPage(WebDriver driver) {
        this.driver = driver;
    }

    public void esperar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        esperar();
        return driver.findElement(resultBy).getText();
    }

    public void excluirLivro() {
        driver.findElement(btnExcluirLivroBy).click();
    }
}
