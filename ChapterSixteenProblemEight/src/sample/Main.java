package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Array of at least 20 ints
        int[] numbers = {18, 16, 1, 13, 8, 19, 2, 9, 14, 3, 20, 10, 17, 4, 11, 5, 6, 7, 12, 15};

        // Display unsorted Array
        Label arrayDetailsLabel = new Label(Arrays.toString(numbers));

        // Ruler Image
        Image rulerImage = new Image("file:C:\\dev\\saveFilesHere\\Cool\\ruler.jpg");
        ImageView rulerImageView = new ImageView(rulerImage);
        rulerImageView.setFitWidth(400);
        rulerImageView.setFitHeight(200);
        rulerImageView.preserveRatioProperty();

        // Sorting Benchmarks Text
        Text topDescription = new Text("SORTING BENCHMARKS");
        topDescription.setFont(new Font("Verdana", 20));
        topDescription.setFill(Color.BLACK);

        // Bubble Sort
        Label bubbleSortLabel = new Label("Bubble Sort:");
        Label bubbleSortBenchmarkLabel = new Label();
        HBox bubbleSortHBox = new HBox(5, bubbleSortLabel, bubbleSortBenchmarkLabel);
        bubbleSortHBox.setAlignment(Pos.CENTER);
        bubbleSortHBox.setPadding(new Insets(5));

        // Selection Sort
        Label selectionSortLabel = new Label("Selection Sort:");
        Label selectionSortBenchmarkLabel = new Label();
        HBox selectionSortHBox = new HBox(5, selectionSortLabel, selectionSortBenchmarkLabel);
        selectionSortHBox.setAlignment(Pos.CENTER);
        selectionSortHBox.setPadding(new Insets(5));

        // Insertion Sort
        Label insertionSortLabel = new Label("Insertion Sort:");
        Label insertionSortBenchmarkLabel = new Label();
        HBox insertionSortHBox = new HBox(5, insertionSortLabel, insertionSortBenchmarkLabel);
        insertionSortHBox.setAlignment(Pos.CENTER);
        insertionSortHBox.setPadding(new Insets(5));

        // Quicksort
        Label quickSortLabel = new Label("Quicksort Sort:");
        Label quickSortBenchmarkLabel = new Label();
        HBox quickSortHBox = new HBox(5, quickSortLabel, quickSortBenchmarkLabel);
        quickSortHBox.setAlignment(Pos.CENTER);
        quickSortHBox.setPadding(new Insets(5));

        // Button & Event Handling
        Button sortButton = new Button("Sort");

        sortButton.setOnAction(e->{
            // Four Arrays, one for each sorting method
            int[] arrayOne = {18, 16, 1, 13, 8, 19, 2, 9, 14, 3, 20, 10, 17, 4, 11, 5, 6, 7, 12, 15};
            int[] arrayTwo = {18, 16, 1, 13, 8, 19, 2, 9, 14, 3, 20, 10, 17, 4, 11, 5, 6, 7, 12, 15};
            int[] arrayThree = {18, 16, 1, 13, 8, 19, 2, 9, 14, 3, 20, 10, 17, 4, 11, 5, 6, 7, 12, 15};
            int[] arrayFour = {18, 16, 1, 13, 8, 19, 2, 9, 14, 3, 20, 10, 17, 4, 11, 5, 6, 7, 12, 15};

            // Bubble Sort
            int bubbleSortSwaps = IntBubbleSorter.bubbleSort(arrayOne);
            bubbleSortBenchmarkLabel.setText(String.valueOf(bubbleSortSwaps));

            // Selection Sort
            int selectionSortSwaps = IntSelectionSorter.selectionSort(arrayTwo);
            selectionSortBenchmarkLabel.setText(String.valueOf(selectionSortSwaps));

            // Insertion Sort
            int insertionSortSwaps = IntInsertionSorter.insertionSort(arrayThree);
            insertionSortBenchmarkLabel.setText(String.valueOf(insertionSortSwaps));

            // Quick Sort
            IntQuickSorter iqs =new IntQuickSorter();
            iqs.quickSort(arrayFour);
            quickSortBenchmarkLabel.setText(String.valueOf(iqs.getAccumulator()));
            // Reset to zero
            IntQuickSorter.setAccumulator(0);


        });

        // Main container
        VBox mainContainer = new VBox(10, rulerImageView, topDescription, arrayDetailsLabel, bubbleSortHBox, selectionSortHBox, insertionSortHBox, quickSortHBox, sortButton  );
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(10));

        // Scene
        Scene scene = new Scene(mainContainer, 600, 500);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("SORT BENCHMARKS");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
