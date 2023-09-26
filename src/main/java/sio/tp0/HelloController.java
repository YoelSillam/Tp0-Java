package sio.tp0;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import sio.tp0.Class.Contact;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
public class HelloController implements Initializable{

    @FXML
    private AnchorPane apEntier;
    @FXML
    private TableView tvContact;
    @FXML
    private AnchorPane apExemple2;
    @FXML
    private Label lblContact1;
    @FXML
    private Label lblContact2;
    @FXML
    private Label lblContact3;
    @FXML
    private Button cmdAnimation;
    @FXML
    private Button cmdStop;
    ObservableList<Contact> lesContacts;
    @FXML
    private AnchorPane apExemple1;
    @FXML
    private TableColumn tcNom;
    @FXML
    private TableColumn tcPrenom;
    @FXML
    private TableColumn tcAge;
    @FXML
    private Button cmdExemple1;
    @FXML
    private Button cmdExemple2;
    @FXML
    private Button cmdExemple3;
    @FXML
    private AnchorPane apExemple3;
    @FXML
    private Label lblTitre;
    TranslateTransition translateTransition;
    RotateTransition rotateTransition;
    @FXML
    private ImageView imgSettings;
    @FXML
    private Circle rondBleu;


    public void apRootLoad(MouseEvent mouseEvent) {
        tvContact.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apExemple1.toFront();

        lesContacts = FXCollections.observableArrayList();
        lesContacts.add (new Contact("Fortin","François",50));
        lesContacts.add (new Contact("Annonier", "Eric", 49));
        lesContacts.add (new Contact("Cousinot", "Sebastian", 51));
        tcNom.setCellValueFactory(new PropertyValueFactory<Contact,String>("nom"));
        tcPrenom.setCellValueFactory(new PropertyValueFactory<Contact,String>("prenom"));
        tcAge.setCellValueFactory(new PropertyValueFactory<Contact,String>("age"));
        tvContact.setItems(lesContacts);



        //Pour l'exemple 3
        translateTransition =new TranslateTransition(Duration.seconds(1));
        translateTransition.setNode(rondBleu);
        translateTransition.setFromX(10);
        translateTransition.setToX(380);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition= new RotateTransition(Duration.seconds(1));
        rotateTransition.setNode(imgSettings);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
    }


    @FXML
    public void tvContactClicked(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Tp0Second-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        SecondController secondController = fxmlLoader.getController();
        secondController.initDatas(((Contact)tvContact.getSelectionModel().getSelectedItem()));
        Stage stage = new Stage();
        stage.setTitle("Modification d'un contact");
        stage.setScene(scene);
        stage.show();


    }


    @FXML
    public void cmdExemple1CLicked(Event event) {
        apExemple1.toFront();
    }

    @FXML
    public void cmdExemple2Clicked(Event event) {
        lblTitre.setText("Tp0 : Les bases / Exemple n°2");
        apExemple2.toFront();
        lblContact1.setText(lesContacts.get(0).getNom()+"\n"+lesContacts.get(0).getAge()+"ans");
        lblContact2.setText(lesContacts.get(1).getNom()+"\n"+lesContacts.get(1).getAge()+"ans");
        lblContact3.setText(lesContacts.get(2).getNom()+"\n"+lesContacts.get(2).getAge()+"ans");
    }

    @FXML
    public void cmdExemple3Clicked(Event event) {
        apExemple3.toFront();
    }

    @FXML
    public void cmdAnimationClicked(Event event) {
        translateTransition.play();
        rotateTransition.play();
    }

    @FXML
    public void cmdStopClicked(Event event) {
        translateTransition.stop();
        rotateTransition.stop();
    }



}