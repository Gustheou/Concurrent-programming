/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 17/05/2022
* Ultima alteracao.: --/05/2022
* Nome.............: ControleMenu
* Funcao...........: Mudar a tela
*************************************************************** */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleMenu {
/* ***************************************************************
* Metodo: iniciarButton
* Funcao: trocar a tela inicial para a tela secundaria
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void iniciarButton(ActionEvent event) {
    Principal.changeScreenTransito(event);
  }//Fim do metodo iniciarButton
}//Fim da classe ControleMenu
