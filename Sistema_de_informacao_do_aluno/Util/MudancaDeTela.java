/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 04/01/2021
* Ultima alteracao.: 03/02/2021
* Nome.............: MudancaDeTela
* Funcao...........: Realizar navegacao entre telas
*************************************************************** */
package Util;
import java.io.IOException;

import Controller.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MudancaDeTela {
  private static Stage stage;
  private static Scene menu;
  //Cenas do semestre 2020.1.
  private static Scene semestre20201;
  private static Scene tabelaHorario20201;
  private static Scene professoresDisciplinas20201;
  private static Scene notasFinais20201;
  //Cenas do semestre 2020.2.
  private static Scene semestre20202;
  private static Scene tabelaHorario20202;
  private static Scene professoresDisciplinas20202;
  private static Scene notasFinais20202;
  //Cenas do semestre 2021.1.
  private static Scene semestre20211;
  private static Scene tabelaHorario20211;
  private static Scene professoresDisciplinas20211;

/* ***************************************************************
* Metodo: start
* Funcao: Iniciar a exibição de telas
* Parametros: cenario=responsavel por permitir o uso de telas
* Retorno: void
*************************************************************** */
  public static void init (Stage cenario) throws IOException {
    stage = cenario;
    new ControleHorario20201();
    new ControleHorario20202();
    new ControleHorario20211();
    new ControleMenu();
    new ControleNotasFinais20201();
    new ControleNotasFinais20202();
    new ControleProfessoresDisciplina20201();
    new ControleProfessoresDisciplina20202();
    new ControleProfessoresDisciplina20211();
    new ControleSemestre20201();
    new ControleSemestre20202();
    new ControleSemestre20211();
    cenario.setTitle ("Portal aluno");//Para atribuir um titulo na barra superior do aplicativo.
    Parent fxmlMenu = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/Menu.fxml"));//Fazer com que o principal arquivo fxml seja no caso o menu.
    menu = new Scene (fxmlMenu); //Atribuir a cena principal a nova sena que e referente ao fxml principal.
    //Cenas do semestre 2020.1.
    Parent fxmlSemestre20201 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/Semestre20201.fxml"));
    Parent fxmlTabelaHorario20201 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/TabelaDeHorario20201.fxml"));
    Parent fxmlProfessoresDisciplinas20201 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/ProfessoresDisciplinas20201.fxml"));
    Parent fxmlNotasFinais20201 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/NotasFinais20201.fxml"));
    Parent fxmlSemestre20202 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/Semestre20202.fxml"));
    Parent fxmlTabelaHorario20202 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/TabelaDeHorario20202.fxml"));
    Parent fxmlProfessoresDisciplinas20202 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/ProfessoresDisciplinas20202.fxml"));
    Parent fxmlNotasFinais20202 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/NotasFinais20202.fxml"));
    Parent fxmlSemestre20211 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/Semestre20211.fxml"));
    Parent fxmlTabelaHorario20211 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/TabelaDeHorario20211.fxml"));
    Parent fxmlProfessoresDisciplinas20211 = FXMLLoader.load(MudancaDeTela.class.getResource("/View/Fxml/ProfessoresDisciplinas20211.fxml"));
    semestre20201 = new Scene (fxmlSemestre20201);
    tabelaHorario20201 = new Scene(fxmlTabelaHorario20201);
    professoresDisciplinas20201 = new Scene (fxmlProfessoresDisciplinas20201);
    notasFinais20201 = new Scene (fxmlNotasFinais20201);
    //Cenas do semestre 2020.2.
    semestre20202 = new Scene (fxmlSemestre20202);
    tabelaHorario20202 = new Scene (fxmlTabelaHorario20202);
    professoresDisciplinas20202 = new Scene (fxmlProfessoresDisciplinas20202);
    notasFinais20202 = new Scene (fxmlNotasFinais20202);
    //Cenas do semestre 2021.1.
    semestre20211 = new Scene (fxmlSemestre20211);
    tabelaHorario20211 = new Scene (fxmlTabelaHorario20211);
    professoresDisciplinas20211 = new Scene (fxmlProfessoresDisciplinas20211);

    cenario.setScene(menu);
    cenario.show();

    cenario.setOnCloseRequest(e -> {
      Platform.exit();
      System.exit(0);
    });
  }

/* ***************************************************************
* Metodo: changeScreenMenu
* Funcao: trocar a tela presente para a tela menu
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenMenu() {
    stage.setScene(menu);
  }
	
  //Semestre 2020.1.
	
/* ***************************************************************
* Metodo: changeScreenSemestre20201
* Funcao: trocar a tela presente para a tela referente ao semestre 2020.1
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenSemestre20201 () {
    stage.setScene(semestre20201);
  }
	
/* ***************************************************************
* Metodo: changeScreenTabelaHorario20201
* Funcao: trocar a tela presente para a tela referente a tabela de horario do semestre 2020.1
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenTabelaHorario20201() {
    stage.setScene(tabelaHorario20201);
  }
	
/* ***************************************************************
* Metodo: changeScreenProfessoresDisciplinas20201
* Funcao: trocar a tela presente para a tela referente a listagem dos professores e suas disciplinas do semestre 2020.1
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenProfessoresDisciplinas20201(){
    stage.setScene(professoresDisciplinas20201);
  }
	
/* ***************************************************************
* Metodo: changeScreenNotasFinais20201
* Funcao: trocar a tela presente para a tela referente as notas finais do semestre 2020.1
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenNotasFinais20201() {
    stage.setScene(notasFinais20201);
  }

  //Semestre 2020.2.
	
/* ***************************************************************
* Metodo: changeScreenSemestre20202
* Funcao: trocar a tela presente para a tela referente ao semestre 2020.2
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenSemestre20202 () {
    stage.setScene(semestre20202);
  }
	
/* ***************************************************************
* Metodo: changeScreenTabelaHorario20202
* Funcao: trocar a tela presente para a tela referente a tabela de horario do semestre 2020.2
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenTabelaHorario20202() {
    stage.setScene(tabelaHorario20202);
  }
	
/* ***************************************************************
* Metodo: changeScreenProfessoresDisciplinas20202
* Funcao: trocar a tela presente para a tela referente a listagem dos professores e suas disciplinas do semestre 2020.2
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenProfessoresDisciplinas20202(){
    stage.setScene(professoresDisciplinas20202);
  }
	
/* ***************************************************************
* Metodo: changeScreenNotasFinais20202
* Funcao: trocar a tela presente para a tela referente as notas finais do semestre 2020.2
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenNotasFinais20202() {
    stage.setScene(notasFinais20202);
  }

  //Semestre 2021.1.
	
  public static void changeScreenSemestre20211 () {
    stage.setScene(semestre20211);
  }
	
/* ***************************************************************
* Metodo: changeScreenTabelaHorario20211
* Funcao: trocar a tela presente para a tela referente a tabela de horario do semestre 2021.1
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenTabelaHorario20211() {
    stage.setScene(tabelaHorario20211);
  }
	
/* ***************************************************************
* Metodo: changeScreenProfessoresDisciplinas20211
* Funcao: trocar a tela presente para a tela referente a listagem dos professores e suas disciplinas do semestre 2021.1
* Parametros: void
* Retorno: void
*************************************************************** */
  public static void changeScreenProfessoresDisciplinas20211(){
    stage.setScene(professoresDisciplinas20211);
  }
}
