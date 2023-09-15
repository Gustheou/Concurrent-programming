package Controller;
import Util.MudancaDeTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitMenuButton;

public class ControleMenu {//Aqui eh onde se manipula o menu (a escolha do semestre).

  private String setSemestre;
	
  @FXML
  private SplitMenuButton splitMenuButton;

/* ***************************************************************
* Metodo: continuarButton
* Funcao: A depender de qual semestre foi modificado/selecionado, ocorrera a respectiva alteracao de tela.
* Parametros: event = Botao que ao pressionado, desencadeara a funcao
* Retorno: void
*************************************************************** */
  @FXML
  void continuarButton(ActionEvent event) {
    try {
      if (setSemestre.equals("2020.1")) {
        //Mudar tela para o semestre 2020.1.
        MudancaDeTela.changeScreenSemestre20201();
      } else if (setSemestre.equals("2020.2")){
        //Mudar tela para o semestre 2020.2.
        MudancaDeTela.changeScreenSemestre20202();
      } else if (setSemestre.equals("2021.1")){
        MudancaDeTela.changeScreenSemestre20211();
        //Mudar tela para o semestre 2021.1.
      } 
    } catch (NullPointerException n){//Vai pegar a excecao que eh causada por nao selecionar uma opcao e ira exibir a mensagem abaixo
        System.out.println("Selecione uma opcao!");
	}
  }

/* ***************************************************************
* Metodo: semestre20201
* Funcao: Caso selecione o semestre 2020.1, sera alterado o texto e a String recebera esse "valor" que foi selecionado.
* Parametros: event = Botao que ao pressionado, desencadeara a funcao
* Retorno: void
*************************************************************** */
  @FXML
  void semestre20201(ActionEvent event) {
    splitMenuButton.setText("Semestre 2020.1");
    setSemestre = "2020.1";
  }

/* ***************************************************************
* Metodo: semestre20202
* Funcao: Caso selecione o semestre 2020.2, sera alterado o texto e a String recebera esse "valor" que foi selecionado.
* Parametros: event = Botao que ao pressionado, desencadeara a funcao
* Retorno: void
*************************************************************** */
  @FXML
  void semestre20202(ActionEvent event) {
    splitMenuButton.setText("Semestre 2020.2");
    setSemestre = "2020.2";
  }

/* ***************************************************************
* Metodo: semestre20211
* Funcao: Caso selecione o semestre 2021.1, sera alterado o texto e a String recebera esse "valor" que foi selecionado.
* Parametros: event = Botao que ao pressionado, desencadeara a funcao
* Retorno: void
*************************************************************** */
  @FXML
  void semestre20211(ActionEvent event) {
    splitMenuButton.setText("Semestre 2021.1");
    setSemestre = "2021.1";
  }
}

