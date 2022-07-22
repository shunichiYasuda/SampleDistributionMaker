module com.GenSci.tools.sampleDistributionMaker {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.GenSci.tools.sampleDistributionMaker to javafx.fxml;
    exports com.GenSci.tools.sampleDistributionMaker;
}
