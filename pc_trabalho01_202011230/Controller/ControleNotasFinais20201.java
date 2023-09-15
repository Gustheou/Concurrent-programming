package Controller;
import Util.MudancaDeTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleNotasFinais20201 {//Retornar para o menu do semestre 2020.1.

/* ***************************************************************
* Metodo: voltarButton
* Funcao: Retornar para o menu do semestre 2020.1
* Parametros: event = Botao que ao pressionado, desencadeara a funcao
* Retorno: void
*************************************************************** */
  @FXML
  void voltarButton(ActionEvent event) {
    MudancaDeTela.changeScreenSemestre20201();
  }
}
