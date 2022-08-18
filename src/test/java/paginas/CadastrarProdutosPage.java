package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastrarProdutosPage {

    private WebDriver navegador;

    public CadastrarProdutosPage(WebDriver navegador){
        this.navegador = navegador;

    }

    public CadastrarProdutosPage InformarNomeDoProduto(String produto){
        navegador.findElement(By.id("produtonome")).sendKeys(produto);
        return this;
    }
    public  CadastrarProdutosPage InformarValorDoProduto(String valor){
        navegador.findElement(By.id("produtovalor")).sendKeys(valor);
        return this;
    }
    public CadastrarProdutosPage InformarCorProduto(String cores){
        navegador.findElement(By.id("produtocores")).sendKeys(cores);
        return this;
    }
    public ListaDeProdutosPage SubmeterFormularioComErro(){
        navegador.findElement(By.cssSelector("button[name='action']")).click();
        return new ListaDeProdutosPage(navegador);
    }


    public EditarProdutoPage SubmeterFormularioValido(){
        navegador.findElement(By.cssSelector("button[name='action']")).click();
        return new EditarProdutoPage(navegador);

    }
}
