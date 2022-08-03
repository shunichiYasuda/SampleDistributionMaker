package com.GenSci.tools.sampleDistributionMaker;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PrimaryController {

	@FXML
	TextArea log;
	@FXML
	Button execBtn;
	@FXML
	Button quitBtn;
	@FXML
	TextField popSizeNormal; // 母集団サイズ正規分布
	@FXML
	TextField popSizeUniform; //母集団サイズ一様分布
	@FXML
	TextField maxUniform; //一様分布データの最大値（サイコロで言えば「6」）
	@FXML
	TextField minUniform;//一様分布データの最小値（サイコロで言えば「1」）
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
	@FXML
	RadioButton rbt_Uniform;
	@FXML
	RadioButton rbt_Normal;
	@FXML
	ToggleGroup group;
	
	
double[] pop ; //母集団データ
	@FXML
	private void quitAction() {
		System.exit(0);
	}

	@FXML
	private void execAction() {
		// 母集団の作成
		makePop();
		
	}

	private void makePop() {
		//乱数ジェネレータ
		Random gen = new Random();
		// パラメータの読み込み
		int size = 0;
		if (popSizeNormal.getText() != "") { // textField になにか書いてある
			String txt = popSizeNormal.getText();
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
		pop = new double[size];
		//母集団のタイプが正規分布だった場合
		if(rbt_Normal.isSelected()) {
			for(int i=0;i<pop.length;i++) {
				pop[i] = gen.nextGaussian();
			}
		
		}
	}

}
