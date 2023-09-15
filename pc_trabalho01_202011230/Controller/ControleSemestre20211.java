package Controller;
import Util.MudancaDeTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ControleSemestre20211 {//Essa classe serve para definir o que ira proceder no semestre em questao.

  @FXML
  private RadioButton disciplinaProfessoresRadioButton;

  @FXML
  private RadioButton horariosRadioButton;

  @FXML
  private ToggleGroup radioButtonGroup;

  @FXML
  private Label tipText;

/* ***************************************************************
* Metodo: continuarButton
* Funcao: Com uma das opcoes selecionada, realizar a alteracao de tela.
* Parametros: event = Botao que ao pressionado, desencadeara a funcao
* Retorno: void
*************************************************************** */
  @FXML
  void continuarButton(ActionEvent event) {
    if (horariosRadioButton.isSelected()) {//Esse if e os proximos else if servem para mudar a tela a depender de qual opcao selecionada.
      MudancaDeTela.changeScreenTabelaHorario20211();
    } else if (disciplinaProfessoresRadioButton.isSelected()) {
      MudancaDeTela.changeScreenProfessoresDisciplinas20211();
    } else {//Caso nenhuma opcao seja selecionada, ira exibir uma dica de como proceder.
      tipText.setVisible(true);
    }
  }

/* ***************************************************************
* Metodo: voltarButton
* Funcao: Retornar para o menu referente a escolha do semestre
* Parametros: event = Botao que ao pressionado, desencadeara a funcao
* Retorno: void
*************************************************************** */
  @FXML
  void voltarButton(ActionEvent event) {//Metodo para o botao de voltar, para voltar para a tela de menu.
    MudancaDeTela.changeScreenMenu();
  }
}
