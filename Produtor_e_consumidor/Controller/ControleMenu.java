/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 29/03/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: ControleMenu
* Funcao...........: Controlar a tela inicial
*************************************************************** */
package Controller;
import Util.MudancaDeTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleMenu {

/* ***************************************************************
* Metodo: prosseguirButton
* Funcao: trocar a tela inicial para a tela secundaria
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void prosseguirButton(ActionEvent event) {
    MudancaDeTela.changeScreenEntrega(event);
  }//Fim do metodo iniciarButton
}//Fim da classe ControleMenu
