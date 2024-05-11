module com.example.focus_pomodoro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.focus_pomodoro to javafx.fxml;
    exports com.example.focus_pomodoro;
}