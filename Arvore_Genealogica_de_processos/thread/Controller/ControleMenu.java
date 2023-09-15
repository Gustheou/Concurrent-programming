package Controller;
import Util.MudancaDeTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleMenu {
/* ***************************************************************
* Metodo: iniciarButton
* Funcao: trocar a tela inicial para a segunda tela
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh um botao
* Retorno: void
*************************************************************** */
  @FXML
  void iniciarButton(ActionEvent event) {
    MudancaDeTela.changeScreenArvoreGenealogica(event);
  }//Fim do metodo iniciarButton
}//Fim da classe ControleMenu

