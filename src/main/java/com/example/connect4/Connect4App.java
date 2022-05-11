package com.example.connect4;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Connect4App extends Application {

    private static final int TILE = 80;
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;

    private boolean move = true;
    private Disc[][] dyski = new Disc[COLUMNS][ROWS];

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
            //rect.setOnMouseClicked(e -> dropDisc(new Disc(move), kolumna));

            wybor.add(rect);
        }

        return wybor;
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