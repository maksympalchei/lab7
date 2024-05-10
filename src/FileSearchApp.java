import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSearchApp extends Application {

    private ListView<String> fileListView;
    private Label directoryLabel;
    private ComboBox<String> extensionComboBox;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пошук файлів");
        fileListView = new ListView<>();
        fileListView.setPrefSize(400, 300);
        directoryLabel = new Label("Оберіть директорію для пошуку файлів");
        Button chooseDirectoryButton = new Button("Обрати директорію");
        chooseDirectoryButton.setOnAction(event -> chooseDirectory());
        extensionComboBox = new ComboBox<>();
        ObservableList<String> extensions = FXCollections.observableArrayList(".txt", ".doc", ".pdf");
        extensionComboBox.setItems(extensions);
        extensionComboBox.setValue(".txt");
        Button searchButton = new Button("Пошук з потоками");
        searchButton.setOnAction(event -> searchWithThreads());
        Button searchWithoutThreadsButton = new Button("Пошук без потоків");
        searchWithoutThreadsButton.setOnAction(event -> searchWithoutThreads());
        Button openButton = new Button("Відкрити обраний файл");
        openButton.setOnAction(event -> openSelectedFile());
        VBox vbox = new VBox(10, directoryLabel, chooseDirectoryButton, extensionComboBox, searchButton, searchWithoutThreadsButton, fileListView, openButton);
        Scene scene = new Scene(vbox, 420, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void chooseDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Виберіть папку для пошуку");
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            directoryLabel.setText("Обрана директорія: " + selectedDirectory.getAbsolutePath());
        } else {
            directoryLabel.setText("Директорія не обрана.");
            fileListView.getItems().clear();
        }
    }

    private void searchWithThreads() {
        String extension = extensionComboBox.getValue();
        if (extension == null || extension.isEmpty()) {
            return;
        }
        File selectedDirectory = new File(directoryLabel.getText().replace("Обрана директорія: ", ""));
        if (!selectedDirectory.exists()) {
            directoryLabel.setText("Директорія не існує.");
            return;
        }
        Thread searchThread = new Thread(() -> {
            List<String> foundFiles = new ArrayList<>();
            search(selectedDirectory, extension, foundFiles);
            displayFiles(foundFiles);
        });
        searchThread.start();
    }

    private void searchWithoutThreads() {
        String extension = extensionComboBox.getValue();
        if (extension == null || extension.isEmpty()) {
            return;
        }

        File selectedDirectory = new File(directoryLabel.getText().replace("Обрана директорія: ", ""));
        if (!selectedDirectory.exists()) {
            directoryLabel.setText("Директорія не існує.");
            return;
        }

        List<String> foundFiles = new ArrayList<>();
        search(selectedDirectory, extension, foundFiles);
        displayFiles(foundFiles);
    }

    private void search(File directory, String extension, List<String> foundFiles) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                search(file, extension, foundFiles);
            } else {
                if (file.getName().endsWith(extension)) {
                    foundFiles.add(file.getAbsolutePath());
                }
            }
        }
    }

    private void displayFiles(List<String> foundFiles) {
        fileListView.getItems().clear();
        fileListView.getItems().addAll(foundFiles);
    }

    private void openSelectedFile() {
        String selectedFilePath = fileListView.getSelectionModel().getSelectedItem();
        if (selectedFilePath != null) {
            File selectedFile = new File(selectedFilePath);
            if (selectedFile.exists()) {
                try {
                    Desktop.getDesktop().open(selectedFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
