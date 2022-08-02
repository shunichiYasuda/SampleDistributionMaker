package com.GenSci.tools.sampleDistributionMaker;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    Button execBtn;
    @FXML
    Button quitBtn;
    @FXML
    TextField popSize; //母集団サイズ
    @FXML
    TextField popAve; //母集団平均値
    @FXML
    TextField popStdev; //母集団標準偏差
    @FXML
    TextField sampleSize; //標本サイズ
    @FXML
    TextField sampleNumber; //標本採取回数
    @FXML
    Label sampleAve; //標本平均の平均（標本平均）
    @FXML
    Label sampleStdev; //標本平均の標準偏差
    @FXML
    Label sampleUnVar; //標本平均の平均（標本平均）
    @FXML
    Label sampleStErr; //標準誤差
    
}
