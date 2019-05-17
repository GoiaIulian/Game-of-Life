package sample;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    Board board = new Board();

    Stage _window;
    Scene _menu;
    Scene _game;
    Timeline _t = new Timeline();

    @Override
    public void start(Stage stage)
    {
        _window = stage;
        _game = setupGame(board,_t);
        _menu = setupMenu();

        _window.setScene(_menu);
        _window.setTitle(" Game Of Life ");
        _window.setResizable(false);
        _window.setMaximized(false);
        _window.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        _window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public Scene setupMenu()
    {
        VBox firstScene = new VBox();
        firstScene.setStyle("-fx-alignment: center; ");
        firstScene.setSpacing(400);
        firstScene.setPadding(new Insets(100));

        Scene s2 = new Scene(firstScene,600,625);
        BackgroundImage background = new BackgroundImage(
                new Image(getClass().getResourceAsStream("bg.png")),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );


        firstScene.setBackground(new Background(background));
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        Rectangle r=new Rectangle(20,500);
        r.setStyle("-fx-background-color: linear-gradient(#e7e2ea, rgb(210,207,203));" +
                "-fx-border-color: gray;" + "-fx-border-style: dotted dashed solid;"
                + "-fx-border-width: 2px;" + "-fx-font-weight: bold;"
        );
        choiceBox.setStyle(r.getStyle());
        choiceBox.setShape(r);
        choiceBox.setPrefHeight(20);
        choiceBox.setPrefWidth(400);
        choiceBox.getItems().addAll("Random","Square","Pentadecatlon","Lines","Gosper glider gun","Infinite Growth");
        choiceBox.setValue("Random");

        Rectangle b = new Rectangle(20,100);

        Button start = new Button("START");
        start.setShape(b);
        start.prefHeight(20);
        start.prefWidth(100);
        start.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(start, Pos.CENTER);

        start.setStyle("-fx-text-alignment: center;" +
                "-fx-font-size: 15px;" + "-fx-background-color: #f0f0f5;"
                + "-fx-border-width: 2px;" + "-fx-border-color: gray;"
                + "-fx-font-weight: bold;"
        );
        start.setOnAction(e -> startClicked(choiceBox.getValue()));

        firstScene.setAlignment(Pos.CENTER);
        firstScene.getChildren().addAll(choiceBox,start);

        return s2;
    }

    public Scene setupGame(Board board,Timeline t)
    {


        t.setCycleCount(Animation.INDEFINITE);
        t.getKeyFrames().add(new KeyFrame(Duration.millis(150), e -> board.nextGeneration()));

        Button play = new Button("Play");
        play.prefHeight(20);
        play.setMaxHeight(20);
        play.setPrefWidth(200);
        play.setOnAction(event -> t.play());

        play.setStyle("-fx-text-alignment: center;" +
                "-fx-font-size: 12px;" + "-fx-background-color: #f0f0f5;"
                + "-fx-border-width: 2px;" + "-fx-border-color: gray;"
                + "-fx-font-weight: bold;"
        );
        Button pause = new Button("Pause");
        pause.setOnAction(event -> t.pause());
        pause.prefHeight(20);
        pause.setMaxHeight(20);
        pause.setPrefWidth(200);
        pause.setStyle("-fx-text-alignment: center;" +
                "-fx-font-size: 12px;" + "-fx-background-color: #f0f0f5;"
                + "-fx-border-width: 2px;" + "-fx-border-color: gray;"
                + "-fx-font-weight: bold;"
        );
        Button menu = new Button("Menu");
        menu.setStyle("-fx-text-alignment: center;" +
                "-fx-font-size: 12px;" + "-fx-background-color: #f0f0f5;"
                + "-fx-border-width: 2px;" + "-fx-border-color: gray;"
                + "-fx-font-weight: bold;"
        );
        menu.prefHeight(20);
        menu.setMaxHeight(20);
        menu.setPrefWidth(200);
        menu.setOnAction(e -> menuClicked());

        StackPane stackPane = new StackPane();

        HBox buttons = new HBox();

        buttons.setMaxWidth(601);
        buttons.prefWidth(600);
        buttons.getChildren().addAll(play,menu,pause);
        buttons.setAlignment(Pos.BOTTOM_CENTER);

        buttons.setSpacing(2);

        stackPane.getChildren().addAll(board._board,buttons);

        Scene s = new Scene(stackPane,600,625);

        return s;
    }

    public void menuClicked()
    {
        _t.pause();
        _window.setScene(_menu);
    }

    public void startClicked(String s)
    {
        switch(s) {
            case "Random":
            {
                board.clear();
                board.setRandomSeed();
                break;
            }
            case "Square":
            {
                board.clear();
                board.squareSeed();
                break;
            }
            case "Pentadecatlon":
            {
                board.clear();
                board.setPentadecatlonSeed();
                break;
            }
            case "Lines":
            {
                board.clear();
                board.line();
                break;
            }
            case "Gosper glider gun":
            {
                board.clear();
                board.setGosperGliderGunSeed();
                break;
            }
            case "Infinite Growth":
            {
                board.clear();
                board.setInfiniteGrowthSeed();
                break;
            }
        }
        _window.setScene(_game);
    }
}
