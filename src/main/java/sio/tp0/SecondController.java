package sio.tp0;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sio.tp0.Class.Contact;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
public class SecondController {
    @FXML
    private Label lblNomModif;
    @FXML
    private Label lblPrenomModif;
    @FXML
    private Label lblAgeModif;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtAge;

    @FXML
    private Button cmdModifier;
    private Contact leContact;

    public void initDatas (Contact c) {
        leContact = c;
        txtNom. setText (leContact.getNom ()) ;
        txtPrenom.setText(leContact.getPrenom());
        txtAge. setText(String.valueOf(leContact .getAge ())) ;
    }

    @FXML
    public void cmdModifierClicked(Event event) {
        leContact.setNom(txtNom.getText());
        leContact.setPrenom(txtPrenom.getText());
        leContact.setAge(Integer.parseInt(txtAge.getText()));
    }
}
