/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 13/04/2022
* Ultima alteracao.: 22/04/2022
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
    new ControleGeral();
    new ControleMenu();
    stage = cenario;
    cenario.setTitle("Food wars");
    Parent fxmlTelaInicial = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/TelaInicial.fxml"));
    telaMenu = new Scene (fxmlTelaInicial);
    Parent fxmlEntrega = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/TelaPrograma.fxml"));
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
* Metodo: changeScreenJantar
* Funcao: trocar a tela inicial para a tela secundaria
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  public static void changeScreenJantar(ActionEvent event) {
    stage.setScene(telaPrograma);
  }// Fim do metodo changeScreenTrem
}// Fim da classe Principal