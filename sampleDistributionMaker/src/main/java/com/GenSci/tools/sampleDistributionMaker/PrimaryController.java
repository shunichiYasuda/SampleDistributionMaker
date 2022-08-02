package com.GenSci.tools.sampleDistributionMaker;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

	@FXML
	TextArea log;
	@FXML
	Button execBtn;
	@FXML
	Button quitBtn;
	@FXML
	TextField popSize; // 母集団サイズ
	@FXML
	TextField popAve; // 母集団平均値
	@FXML
	TextField popStdev; // 母集団標準偏差
	@FXML
	TextField sampleSize; // 標本サイズ
	@FXML
	TextField sampleNumber; // 標本採取回数
	@FXML
	Label sampleAve; // 標本平均の平均（標本平均）
	@FXML
	Label sampleStdev; // 標本平均の標準偏差
	@FXML
	Label sampleUnVar; // 標本平均の平均（標本平均）
	@FXML
	Label sampleStErr; // 標準誤差
	//

	@FXML
	private void quitAction() {
		System.exit(0);
	}

	@FXML
	private void execAction() {
		double[] pop ; //母集団データ
		// 母集団の作成
		makePop();
	}

	private void makePop() {
		// パラメータの読み込み
		int size = 0;
		if (popSize.getText() != "") { // textField になにか書いてある
			String txt = popSize.getText();
			try {
				size = Integer.parseInt(txt);
			} catch (NumberFormatException e) {
				log.appendText("Error in makePop()\n");
				log.appendText("母集団のデータ数が入っていません。\n");
			}
		}
		double ave = 0.0;
		double stdev = 0.0;
		if (popAve.getText() != "") { // textField になにか書いてある
			String txt = popAve.getText();
			try {
				ave = Double.parseDouble(txt);
			} catch (NumberFormatException e) {
				log.appendText("Error in makePop()\n");
				log.appendText("母集団の平均値が入っていません。\n");
			}
		}
		if (popStdev.getText() != "") { // textField になにか書いてある
			String txt = popStdev.getText();
			try {
				stdev = Double.parseDouble(txt);
			} catch (NumberFormatException e) {
				log.appendText("Error in makePop()\n");
				log.appendText("母集団の標準偏差が入っていません。\n");
			}
		}
		//母集団データの生成
		
	}

}
