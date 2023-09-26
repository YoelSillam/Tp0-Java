module sio.tp0 {
    requires javafx.controls;
    requires javafx.fxml;

    opens sio.tp0.Class to javafx.base;
    opens sio.tp0 to javafx.fxml;
    exports sio.tp0;
}