package Controller;
import Util.MudancaDeTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleHorario20202 {
	
/* ***************************************************************
* Metodo: voltarButton
* Funcao: Retornar para o menu do semestre 2020.2
* Parametros: event = Ao pressionar o botao, desencadeara a funcao
* Retorno: void
*************************************************************** */
  @FXML
  void voltarButton(ActionEvent event) {
    MudancaDeTela.changeScreenSemestre20202();
  }
}
