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
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class PrimaryController {

	@FXML
	TextArea log;
	@FXML
	Button execBtn;
	@FXML
	Button quitBtn;
	@FXML
	Button clearBtn;
	@FXML
	Button copyBtn;
	@FXML
	TextField popSizeNormal; // 母集団サイズ正規分布
	@FXML
	TextField popSizeUniform; // 母集団サイズ一様分布
	@FXML
	TextField maxUniform; // 一様分布データの最大値（サイコロで言えば「6」）
	@FXML
	TextField minUniform;// 一様分布データの最小値（サイコロで言えば「1」）
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

	double[] pop; // 母集団データ（実数）
	int[] popInt; //母集団データ（整数）
//乱数ジェネレータ
	Random gen = new Random();
	int size = 0;// 母集団サイズ

	@FXML
	private void quitAction() {
		System.exit(0);
	}

	@FXML
	private void execAction() {

		// 分布の型に応じた処理
		if (rbt_Normal.isSelected()) {
			makeNormalPop();
		}
		if(rbt_Uniform.isSelected()) {
			makeUniformPop();
		}

	}

	private void makeNormalPop() {
		size  = readParamInt(popSizeNormal, "母集団のデータ数");
		double ave = 0.0;
		double stdev = 0.0;
		ave = readParamDouble(popAve, "母集団の平均値");
		stdev = readParamDouble(popStdev, "母集団の標準偏差");
		// 母集団データの生成
		pop = new double[size];
		for (int i = 0; i < pop.length; i++) {
			double d = gen.nextGaussian();
			pop[i] = d * stdev + ave;
		}
		log.appendText("正規分布母集団：size="+size+"平均="+ave + "標準偏差"+stdev+"\n");
		for(double d:pop) {
			log.appendText(d+"\n");
		}
	}

	private void makeUniformPop() {
		size =readParamInt(popSizeUniform, "母集団のデータ数");
		int min =0;
		int max = 0;
		min = readParamInt(minUniform, "一様分布データの最小値");
		max = readParamInt(maxUniform, "一様分布データの最大値");
		//max - min +1 個の連続する整数が母集団のデータ
		int dataRange = max - min +1;
		//Random#nextInt(n) は 0 から n-1 の整数を等確率でランダムに吐き出すので
		//min から max までを出力するには nextInt(n) が吐き出した数値にminを足す。
		//min =1,max=6 ：dataRange =6, なので 0 - 5を出す。これに min を足すと 1 - 6
		//min = -3, max = 5 : dataRange = 9 なので、 0～8 を出す。これに min を足すと
		//-3 ～ 5 
		//System.out.println("min="+min);
		popInt = new int[size];
		for(int i=0;i<popInt.length;i++) {
			popInt[i] = gen.nextInt(dataRange)+min;
		}
		//log への出力
		log.appendText("一様分布：サイズ: "+size+" min:"+min+"  max:"+max+"\n");
		for(int d:popInt) {
			log.appendText(d+"\n");
		}
//		//check
//		for(int i=0;i<popInt.length;i++) {
//			System.out.println(":"+popInt[i]);
//		}
	}// end of makeUniformPop()

	// パラメータ読み込み
	//
	private double readParamDouble(TextField tf, String errMsg) {
		double r = 0.0;
		String txt = tf.getText();
		try {
			r = Double.parseDouble(txt);
		} catch (NumberFormatException e) {
			log.appendText("Error in makePop()\n");
			log.appendText(errMsg + "が入っていません。\n");
		}
		return r;
	}
	//
	private int readParamInt(TextField tf,String errMsg) {
		int r = 0;
		String txt = tf.getText();
		try {
			r = Integer.parseInt(txt);
		} catch (NumberFormatException e) {
			log.appendText("Error in makePop()\n");
			log.appendText(errMsg + "が入っていません。\n");
		}
		return r;
	}
	//
	@FXML
	private void clear() {
		log.clear();
	}
	//
	@FXML
	private void copy() {
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		content.putString(log.getText());
		clipboard.setContent(content);
	}

}
