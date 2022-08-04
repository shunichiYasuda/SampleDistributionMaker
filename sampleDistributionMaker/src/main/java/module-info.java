module com.GenSci.tools.sampleDistributionMaker {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens com.GenSci.tools.sampleDistributionMaker to javafx.fxml;
    exports com.GenSci.tools.sampleDistributionMaker;
}
