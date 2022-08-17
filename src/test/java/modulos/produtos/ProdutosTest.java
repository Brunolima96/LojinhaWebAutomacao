package modulos.produtos;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {

    @Test
    @DisplayName("Não é permitido registra um produto com valor igual a 0")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){
        // Abrir um navegado
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Bruno\\Desktop\\driver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        // Vou maximizar a tela
        navegador.manage().window().maximize();
        // Navegar para a pagina da lojinhaWeb
        navegador.get("http://165.227.93.41/lojinha-web/v2/");

        // Fazer Login
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys("admin");


        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys("admin");


        navegador.findElement(By.name("action")).click();


        // Vou para a tela de registro de produto
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        // Vou preencher dados do produto eo valor sera igual a 0

        navegador.findElement(By.id("produtonome")).sendKeys("PlayStation 5");
        navegador.findElement(By.id("produtovalor")).sendKeys("000");
        // Vou submter o formulario
        navegador.findElement(By.cssSelector("button[name='action']")).click();

        // Definir um tempo de espera para apresenta a mensagem
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // e validar que a mensagem de erro foi apresentada
       String mensagem = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagem);

        // Fechar o navegador
        navegador.quit();
    }

}
