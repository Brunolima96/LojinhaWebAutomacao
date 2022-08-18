package modulos.produtos;



import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {

    private WebDriver navegador;
    @BeforeEach
    public void beforeEach(){


        // Abrir um navegado
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Bruno\\Desktop\\driver\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Vou maximizar a tela
        navegador.manage().window().maximize();
        // Navegar para a pagina da lojinhaWeb
        navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }
    @Test
    @DisplayName("Não é permitido registra um produto com valor igual a 0")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){


        // Fazer Login

      String mensagemToast =  new LoginPage(navegador)
        .informarOUsuario("admin")
            .informarASenha("admin")
                .submeterFormularioDeLogin()
                        .BotaoNovoProduto()
                                .InformarNomeDoProduto("Play Station 5")
                                        .InformarValorDoProduto("000")
                                            .InformarCorProduto("Preto,Branco")
                                                .SubmeterFormularioComErro()
                                                        .CapturarMensagemApresentada();




        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);


        }

        @Test
        @DisplayName("Não é permitido registrar um produto com valor igual a 7001")
        public void TestNaoEPermitodRegistraProdutoComValorIgualASeteMilEUm(){

        String mensagemToast = new LoginPage(navegador).
                informarOUsuario("****").
                informarASenha("****").
                submeterFormularioDeLogin().
                BotaoNovoProduto().
                InformarNomeDoProduto("Play Station 5").
                InformarValorDoProduto("700100").
                InformarCorProduto("Preto, Branco").
                SubmeterFormularioComErro().
                CapturarMensagemApresentada();

                navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);

        }
        @Test
        @DisplayName("Posso adicionar produtos que estejam na faixa de valor entre R$ 0,01 E R$ 7.000,00")
        public void TestPossoAdicionarProdutosComValorDeUmCentavoAteSeteMil(){

         String mensagemToast = new LoginPage(navegador).
                 informarOUsuario("admin").
                 informarASenha("admin").
                 submeterFormularioDeLogin().
                 BotaoNovoProduto().
                 InformarNomeDoProduto("Macbook Pro").
                 InformarValorDoProduto("500000").
                 InformarCorProduto("Azul,Preto").
                 SubmeterFormularioValido().
                 CapturarMensagemValida();

         Assertions.assertEquals("Produto adicionado com sucesso",mensagemToast);

        }

    @AfterEach
    public void AfterEach(){
        // Fechar o navegador
        navegador.quit();

    }

}
