/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 04/01/2021
* Ultima alteracao.: 03/02/2021
* Nome.............: Portal do Aluno
* Funcao...........: O programa basicamente funciona como um sagres pessoal, que eh armazenado os horarios, professores/disciplinas e as notas dos semestres que ja fiz parte
*************************************************************** */
import java.io.IOException;

import Util.MudancaDeTela;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage cenario) throws IOException {
    MudancaDeTela.init(cenario);
  }
}