package com.example.selectionsortdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.File;


public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextArea inputArray;
    @FXML
    private TextArea outputArray;

    // create file chooser object
    final FileChooser fc = new FileChooser();

    @FXML
    protected void onHelloButtonClick() {
        fc.setTitle("Choose CSV File");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files", "*.txt"));
        File file = fc.showOpenDialog(null);
        // check if there is a file that is uploaded
        if (file != null){
            welcomeText.setText(file.getName());
            ReadFile fileReader = new ReadFile();
            // display array as csv on text area
            inputArray.setText(fileReader.readArray(file));
            // display result of selection sort as string in output text area
            SelectionSort selectSort = new SelectionSort();
            outputArray.setText(selectSort.SelectionSortAlgorithm());
        }
        else {
            welcomeText.setText("File not valid!");
        }


    }



}