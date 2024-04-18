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
        spaceSizeSpinner.getValueFactory().setConverter(new DoubleStringConverter());
        //Text Area
        outputTextArea.setEditable(false);
        outputTextArea.setFont(Font.font("Arial Black", 18));
        //Submit button
        submitButton.setOnAction(this::handleSubmit);
    }

    private class DoubleStringConverter extends StringConverter<Double> {
        @Override
        public String toString(Double value) {
            if (value == null) {
                return "";
            }
            return String.format("%.3f", value);
        }

        @Override
        public Double fromString(String string) {
            try {
                if (string == null || string.isEmpty()) {
                    return 0.0;
                }
                return Double.parseDouble(string);
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }
    }
    @FXML
    private void handleSubmit(ActionEvent event) {
        double initWidth = initWidthSpinner.getValue();
        double initLength = initLengthSpinner.getValue();
        double finalWidth = finalWidthSpinner.getValue();
        double finalLength = finalLengthSpinner.getValue();
        int upness = upnessSpinner.getValue();
        int vertical = vSpacingSpinner.getValue();
        int horizontal = hSpacingSpinner.getValue();
        double space = spaceSizeSpinner.getValue();

        boolean condition1 = (vertical == 0 && horizontal == 0);
        boolean condition2 = vertical > 0;
        double offset1 = (initWidth - finalWidth);
        double offset2 = (initLength - finalLength);
        double offset3 = (initWidth - finalLength);
        double offset4 = (vertical * space) + (upness * finalWidth);
        double offset5 = (horizontal * space) + (upness * finalWidth);

        List<Double> cut = new ArrayList<>();

        if (upness == 1) {
            cut.add(initWidth - offset1 / 2);
            cut.add(initLength - offset2 / 2);
            cut.add(finalWidth);
            cut.add(finalLength);
            outputTextArea.setText(formatResults(cut));
        }
        else if (upness == 2) {
            if (condition1) {
                if (initWidth == finalLength) {
                    cut.add(finalWidth);

                }
                else {
                    cut.add(finalWidth / 2);
                }
                outputTextArea.setText(formatResults(cut));
            }
            else {
                if (condition2) {
                    cut.add(initWidth - offset3 / 2);
                    cut.add(initLength - (initLength - offset4) / 2);
                    cut.add(finalLength);
                    cut.add(offset4);
                    cut.add(offset4 - finalWidth);
                    cut.add(finalWidth);
                }
                else {
                    cut.add(initWidth - offset4);
                    cut.add(initLength - offset2);
                    cut.add(offset4);
                    cut.add(finalLength);
                    cut.add(offset4 - finalWidth);
                    cut.add(finalWidth + space);
                    cut.add(finalWidth);
                }
                outputTextArea.setText(formatResults(cut));
            }
        }
    }

    private String formatResults(List<Double> cut) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cut.size(); i++) {
            builder.append(i + 1).append(": ").append(cut.get(i)).append("\n");
        }
        return builder.toString();
    }
}
