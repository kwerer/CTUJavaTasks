module com.example.selectionsortdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.selectionsortdemo to javafx.fxml;
    exports com.example.selectionsortdemo;
}