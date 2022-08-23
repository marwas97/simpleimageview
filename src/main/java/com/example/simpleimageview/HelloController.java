package com.example.simpleimageview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private String path = "images";
    private String[] files;
    private int index;

    @FXML
    private ImageView imageView;
    @FXML
    private Label info;
    @FXML
    private Button nextButton;

        @FXML
    protected void onNextButtonClick() {
            try{index++;
        if(index <= files.length) {
                info.setText(String.valueOf(index-files.length + "/" + files.length));
                imageView.setImage(new Image("file:" +path + "/" + files[index] ));
            }else{info.setText(String.valueOf(index-1 + "/" + files.length));}
        }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("koniec plików");
            if(index <= files.length) {
                info.setText(String.valueOf(index-files.length + "/" + files.length));
            }else{info.setText(String.valueOf(index-1 + "/" + files.length));}
            index=0;
        }
    }
    @FXML
    protected void onPreviousButtonClick() {
                try{index--;
            if(index <= files.length) {
                imageView.setImage(new Image("file:" +path + "/" + files[index] ));
                info.setText(String.valueOf(index-files.length + "/" + files.length));
            }else{info.setText(String.valueOf(index-1 + "/" + files.length));}
        }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("koniec plików");
            if(index <= files.length) {
                info.setText(String.valueOf(files.length+index + "/" + files.length));
            }else{info.setText(String.valueOf(index-1 + "/" + files.length));}
            index = files.length;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        files = new File(path).list();
        System.out.printf(Arrays.toString(files));
        index=0;
        if(index <= files.length) {
            imageView.setImage(new Image("file:" +path + "/" + files[index] ));
            info.setText(String.valueOf(index-files.length + "/" + files.length + files[index]));
        }else{info.setText(String.valueOf(index-1 + "/" + files.length));}
            }
}