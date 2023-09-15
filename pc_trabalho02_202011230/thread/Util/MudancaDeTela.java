/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 07/03/2022
* Ultima alteracao.: 12/03/2022
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
    new ControleArvoreGenealogica();
    new ControleMenu();
    cenario.setTitle("Arvore genealogica");
    Parent fxmlMenu = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/telaInicial.fxml"));
    telaMenu = new Scene (fxmlMenu);
    Parent fxmlArvoreGenealogica = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/telaSecundaria.fxml"));
    telaPrograma = new Scene (fxmlArvoreGenealogica);

    cenario.setScene(telaMenu);
    cenario.show();
    
    cenario.setOnCloseRequest(e -> {
      Platform.exit();
      System.exit(0);
    });
  }//Fim do metodo start

/* ***************************************************************
* Metodo: changeScreenArvoreGenealogica
* Funcao: trocar a tela presente para a tela menu
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh ao apertar um botao
* Retorno: void
*************************************************************** */
  public static void changeScreenArvoreGenealogica (ActionEvent event) {
      stage.setScene(telaPrograma);
  }//Fim do metodo changeScreenArvoreGenealogica
}//Fim da classe Principal
