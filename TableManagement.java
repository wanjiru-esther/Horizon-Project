package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.LinkedList;
import java.util.Queue;

public class TableManagement extends Application {

    private Queue<String> orderQueue = new LinkedList<>();

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        int tableCount = 1;

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                int currentTable = tableCount;
                Button tableBtn = new Button("Table " + tableCount);
                tableBtn.setMinSize(60, 40); // Smaller button size
                tableBtn.setOnAction(e -> handleTableClick(currentTable, stage)); // Hide stage when clicked
                grid.add(tableBtn, col, row);
                tableCount++;
            }
        }

        Scene scene = new Scene(grid, 400, 300); // Smaller window
        stage.setTitle("Compact Table Manager");
        stage.setScene(scene);
        stage.show();
    }

    private void handleTableClick(int tableNumber, Stage stage) {
        String order = "Table " + tableNumber + ": 1 x Caesar Salad";
        orderQueue.offer(order);
        System.out.println("Added: " + order);

        if (!orderQueue.isEmpty()) {
            String processed = orderQueue.poll();
            System.out.println("Processing: " + processed);
        }

        // Hide the window once a table is clicked
        stage.hide();  // Hides the stage (GUI window)
        System.out.println("GUI hidden. You must restart the application to interact again.");
        // Uncomment the next line to close the program entirely:
        // System.exit(0); // Optional: Terminates the program
    }

    public static void main(String[] args) {
        launch(args);
    }
}
