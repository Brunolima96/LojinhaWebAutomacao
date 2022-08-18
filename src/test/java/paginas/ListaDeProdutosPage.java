package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {

    private WebDriver navegador;

    public ListaDeProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public CadastrarProdutosPage BotaoNovoProduto(){
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new CadastrarProdutosPage(navegador);
    }
    public String CapturarMensagemApresentada(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
