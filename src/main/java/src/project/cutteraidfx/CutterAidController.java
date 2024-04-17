package src.project.cutteraidfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CutterAidController implements Initializable {

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private AnchorPane anchorPane3;

    @FXML
    private Label finalLengthLabel;

    @FXML
    private Spinner<Double> finalLengthSpinner;

    @FXML
    private Label finalSizeLabel;

    @FXML
    private Label finalWidthLabel;

    @FXML
    private Spinner<Double> finalWidthSpinner;

    @FXML
    private Label initLengthLabel;

    @FXML
    private Spinner<Double> initLengthSpinner;

    @FXML
    private Label initWidthLabel;

    @FXML
    private Spinner<Double> initWidthSpinner;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private Label mainLabel;

    @FXML
    private Label midLengthLabel;

    @FXML
    private Spinner<Integer> hSpacingSpinner;

    @FXML
    private Label midSpaceLabel;

    @FXML
    private Label midWidthLabel;

    @FXML
    private Spinner<Integer> vSpacingSpinner;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Label paperSizeLabel;

    @FXML
    private Button printButton;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    private Button submitButton;

    @FXML
    private Label upnessLabel;

    @FXML
    private Spinner<Integer> upnessSpinner;

    @FXML
    private Spinner<Double> spaceSizeSpinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Spinners
        initWidthSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 26, 0));
        initLengthSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 44, 0));
        finalWidthSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 15, 0, 0.5));
        finalLengthSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 26, 0, 0.5));
        upnessSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 16, 1));
        vSpacingSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 8, 0));
        hSpacingSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 8, 0));
        spaceSizeSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, .500, 0, 0.125));
        //spaceSizeSpinner.getValueFactory().setConverter(new DoubleStringConverter());
        //Text Area
        outputTextArea.setEditable(false);
        outputTextArea.setFont(Font.font("Arial Black", 18));
        //Submit button
        //submitButton.setOnAction(this::handleSubmit);
    }
}
