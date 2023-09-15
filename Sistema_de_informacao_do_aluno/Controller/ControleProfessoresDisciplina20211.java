package Controller;
import Util.MudancaDeTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleProfessoresDisciplina20211 {

/* ***************************************************************
* Metodo: voltarButton
* Funcao: Retornar para o menu do semestre 2021.1
* Parametros: event = Botao que ao pressionado, desencadeara a funcao
* Retorno: void
*************************************************************** */ 
  @FXML
  void voltarButton(ActionEvent event) {
    MudancaDeTela.changeScreenSemestre20211();
  }
}
