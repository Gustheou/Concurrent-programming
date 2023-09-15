/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 20/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: ControleMenu
* Funcao...........: Mudar a tela
*************************************************************** */
package Controller;
import Util.MudancaDeTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleMenu {
/* ***************************************************************
* Metodo: inicarButton
* Funcao: trocar a tela inicial para a tela secundaria
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void iniciarButton(ActionEvent event) {
    MudancaDeTela.changeScreenTrem(event);
  }//Fim do metodo iniciarButton
}//Fim da classe ControleMenu
