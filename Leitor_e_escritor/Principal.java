/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 03/05/2022
* Ultima alteracao.: 07/05/2022
* Nome.............: Principal
* Funcao...........: O programa tem como funcao simular o problema dos leitores e escritores
*************************************************************** */
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application{
  private static Stage stage;
  private static Scene telaPrograma;

/* ***************************************************************
* Metodo: main
* Funcao: lançar o programa
* Parametros: args=essencial para tornar o arquivo como principal
* Retorno: void
*************************************************************** */
  public static void main (String [] args) {
    launch (args);
  }//Fim do metodo main

/* ***************************************************************
* Metodo: start
* Funcao: Iniciar a exibição da tela
* Parametros: cenario=responsavel por permitir o uso da tela
* Retorno: void
*************************************************************** */
  @Override
  public void start (Stage cenario) throws IOException {
    stage = cenario;
    cenario.setTitle("Readers & Writers");
    Parent fxmlPrograma = FXMLLoader.load(getClass().getResource("Programa.fxml"));
    telaPrograma = new Scene (fxmlPrograma);
    ControlePrograma cP = new ControlePrograma();
    cenario.getIcons().add(new Image("icon.png"));
    cenario.setScene(telaPrograma);
    cenario.show();
  }//Fim do metodo start
}//Fim da classe Principal
