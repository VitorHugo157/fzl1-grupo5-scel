package br.edu.fateczl.fzl1grupo5scel.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LivroPageObject {

    private WebDriver driver;
    private By isbnBy = By.id("isbn");
    private By autorBy = By.id("autor");
    private By tituloBy = By.id("titulo");
    private By btnMenuLivrosBy = By.linkText("Livros");
    private By btnCadastrarLivroBy = By.cssSelector(".btn:nth-child(1)");
    private By btnAtualizarLivroBy = By.cssSelector(".btn");
    private By btnAtualizarBy = By.cssSelector("tr:nth-child(2) .btn-primary");
    private By btnExcluirLivroBy = By.cssSelector("tr:nth-child(2) .delete");
    private By resultBy = By.cssSelector("tr:nth-child(2) > td:nth-child(4)");

    public LivroPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void esperar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public LivroPageObject cadastrar(String isbn, String autor, String titulo) {
        esperar();
        driver.findElement(btnMenuLivrosBy).click();
        esperar();
        driver.findElement(isbnBy).click();
        driver.findElement(isbnBy).sendKeys(isbn);
        driver.findElement(autorBy).click();
        driver.findElement(autorBy).sendKeys(autor);
        driver.findElement(tituloBy).click();
        driver.findElement(tituloBy).sendKeys(titulo);
        driver.findElement(btnCadastrarLivroBy).click();
        return new LivroPageObject(driver);
    }

    public LivroPageObject atualizar(String isbn, String autor, String titulo) {
        esperar();
        driver.findElement(btnAtualizarBy).click();
        if(!isbn.isEmpty()) {
            driver.findElement(isbnBy).click();
            driver.findElement(isbnBy).clear();
            driver.findElement(isbnBy).sendKeys(isbn);
        }
        if(!autor.isEmpty()) {
            driver.findElement(autorBy).click();
            driver.findElement(autorBy).clear();
            driver.findElement(autorBy).sendKeys(autor);
        }
        if(!titulo.isEmpty()) {
            driver.findElement(tituloBy).click();
            driver.findElement(tituloBy).clear();
            driver.findElement(tituloBy).sendKeys(titulo);
        }
        driver.findElement(btnAtualizarLivroBy).click();
        return new LivroPageObject(driver);
    }

    public void excluir() {
        esperar();
        driver.findElement(btnExcluirLivroBy).click();
    }

    public String getResult() {
        esperar();
        return driver.findElement(resultBy).getText();
    }
}
