package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public LoginPage informarOUsuario(String usuario){
        navegador.findElement(By.id("usuario")).sendKeys(usuario);
        return this;
    }

    public  LoginPage informarASenha(String senha){
        navegador.findElement(By.id("senha")).sendKeys("admin");
        return  this;
    }

    public ListaDeProdutosPage submeterFormularioDeLogin(){
        navegador.findElement(By.name("action")).click();

        return new ListaDeProdutosPage(navegador);


    }
}
