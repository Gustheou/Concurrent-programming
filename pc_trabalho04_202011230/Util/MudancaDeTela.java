/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 29/03/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: MudancaDeTela
* Funcao...........: Navegar entre as telas
*************************************************************** */
package Util;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Controller.*;


public class MudancaDeTela {
  private static Stage stage;
  private static Scene telaMenu;
  private static Scene telaPrograma;


/* ***************************************************************
* Metodo: init
* Funcao: Iniciar a exibição de telas
* Parametros: cenario=responsavel por permitir o uso de telas
* Retorno: void
*************************************************************** */
  public static void init (Stage cenario) throws IOException {
    stage = cenario;
    new ControleGeral();
    new ControleMenu();
    cenario.setTitle("Bomberman in action");
    Parent fxmlTelaInicial = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/TelaInicial.fxml"));
    telaMenu = new Scene (fxmlTelaInicial);
    Parent fxmlEntrega = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/TelaSecundaria.fxml"));
    telaPrograma = new Scene (fxmlEntrega);

    cenario.getIcons().add(new Image("/View/Images/Icon.png"));
    cenario.setScene(telaMenu);
    cenario.show();
    cenario.setOnCloseRequest(e -> {
      Platform.exit();
      System.exit(0);
    });
  }//Fim do metodo start

/* ***************************************************************
* Metodo: changeScreenTrem
* Funcao: trocar a tela inicial para a tela secundaria
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  public static void changeScreenEntrega(ActionEvent event) {
    stage.setScene(telaPrograma);
  }// Fim do metodo changeScreenTrem
}// Fim da classe Principal
