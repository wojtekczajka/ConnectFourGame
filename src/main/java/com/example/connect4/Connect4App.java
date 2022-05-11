package com.example.connect4;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Connect4App extends Application {

    private static final int TILE = 80;
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    private boolean move = true;
    private Disc[][] dyski = new Disc[COLUMNS][ROWS];

    private Pane discRoot = new Pane();

    private static class Disc extends Circle {
        private final boolean color;

        public Disc(boolean color){
            super(TILE / 2, color ? Color.RED : Color.YELLOW);
            this.color = color;

            setCenterX(TILE / 2);
            setCenterY(TILE / 2);
        }
    }

    private Parent createBoard() {
        Pane root = new Pane();
        root.getChildren().add(discRoot);

        Shape grid = createGrid();
        root.getChildren().add(grid);
        root.getChildren().addAll(makeChoiceLight());
        return root;
    }

    private Shape createGrid() {
        Shape grid = new Rectangle((COLUMNS + 1) * TILE, (ROWS + 1) * TILE);

        for (int i = 0; i<ROWS; i++){
            for (int j = 0; j<COLUMNS; j++){
                Circle okrag = new Circle(TILE / 2);
                okrag.setCenterX(TILE / 2);
                okrag.setCenterY(TILE / 2);
                okrag.setTranslateX(j * (TILE + 5) + TILE / 4);
                okrag.setTranslateY(i * (TILE + 5) + TILE / 4);

                grid = Shape.subtract(grid,okrag);

            }
        }

        grid.setFill(Color.BLUE);
        grid.setEffect(lightUp());

        return grid;
    }

    private Lighting lightUp(){
        Light.Distant light = new Light.Distant();
        light.setAzimuth(45.0);
        light.setElevation(30.0);

        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);

        return lighting;
    }

    private List<Rectangle> makeChoiceLight(){
        List<Rectangle> wybor = new ArrayList<Rectangle>();

        for (int i = 0; i < COLUMNS; i++){
            Rectangle rect = new Rectangle(TILE, (ROWS + 1) * TILE);
            rect.setTranslateX(i * (TILE + 5) + TILE / 4);
            rect.setFill(Color.TRANSPARENT);
            rect.setOnMouseEntered(e -> rect.setFill(Color.rgb(200,200,50, 0.3)));
            rect.setOnMouseExited(e -> rect.setFill(Color.TRANSPARENT));

            final int kolumna = i;
            rect.setOnMouseClicked(e -> dropDisc(new Disc(move), kolumna));

            wybor.add(rect);
        }

        return wybor;
    }

    private void dropDisc(Disc disc, int kolumna){
        int test = 0, i;
        for (i = ROWS-1; i >= 0; i--){
            if(getDisc(kolumna,i)==null) {
                dyski[kolumna][i] = disc;
                test = 1;
                break;
            }
        }

        if (test == 0) return;

        discRoot.getChildren().add(disc);
        disc.setTranslateX(kolumna * (TILE + 5) + TILE / 4);
        move = !move;

        final int wiersz = i;

        //if (gameEnded(kolumna, wiersz2)) gameOver();
        if (checkTie()) gameTie();

        TranslateTransition animation = new TranslateTransition(Duration.seconds(0.5),disc);
        animation.setToY(i * (TILE + 5) + TILE / 4);
        animation.play();
    }

    /*private boolean gameEnded(int kolumna, int wiersz){

    }*/

    private boolean checkTie(){
        int test = 0;
        for (int i = 0; i<COLUMNS; i++){
            for (int j = 0; j<ROWS; j++){
                if(dyski[i][j] == null) test = 1;
            }
        }
        return test == 0;
    }

    private void gameOver(){
        System.out.println("Wygrał " + (move ? "czerwony!" : "żółty!"));
    }

    private void gameTie(){
        System.out.println("Remis!");
    }

    private Disc getDisc(int kolumna, int wiersz){
        return dyski[kolumna][wiersz];
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createBoard());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}