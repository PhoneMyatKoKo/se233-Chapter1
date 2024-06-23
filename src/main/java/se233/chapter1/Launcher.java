package se233.chapter1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import se233.chapter1.controller.GenCharacter;
import se233.chapter1.controller.GenItemList;
import se233.chapter1.model.character.BasedCharacter;
import se233.chapter1.model.item.Armor;
import se233.chapter1.model.item.BasedEquipment;
import se233.chapter1.model.item.Weapon;
import se233.chapter1.view.CharacterPane;
import se233.chapter1.view.EquipPane;
import se233.chapter1.view.InventoryPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher extends Application {

    public static Scene getMainScene() {
        return MainScene;
    }

    public static void setMainScene(Scene mainScene) {
        MainScene = mainScene;
    }

    public static ArrayList<BasedEquipment> getAllEquipments() {
        return allEquipments;
    }

    public static void setAllEquipments(ArrayList<BasedEquipment> allEquipments) {
        Launcher.allEquipments = allEquipments;
    }

    public static Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public static void setEquippedWeapon(Weapon equippedWeapon) {
        Launcher.equippedWeapon = equippedWeapon;
    }

    public static Armor getEquippedArmor() {
        return equippedArmor;
    }

    public static void setEquippedArmor(Armor equippedArmor) {
        Launcher.equippedArmor = equippedArmor;
    }

    public static EquipPane getEquipPane() {
        return equipPane;
    }

    public static void setEquipPane(EquipPane equipPane) {
        Launcher.equipPane = equipPane;
    }

    public static InventoryPane getInventoryPane() {
        return inventoryPane;
    }

    public static void setInventoryPane(InventoryPane inventoryPane) {
        Launcher.inventoryPane = inventoryPane;
    }

    private static Scene MainScene;
    private static BasedCharacter mainChacter=null;
    private static ArrayList<BasedEquipment> allEquipments=null;
    private static Weapon equippedWeapon=null;
    private static Armor equippedArmor=null;
    private static CharacterPane characterPane=null;
    private static EquipPane equipPane=null;
    private static InventoryPane inventoryPane=null;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Chapter 1");
        primaryStage.setResizable(false);
        primaryStage.show();
        mainChacter= GenCharacter.setUpCharacter();
        allEquipments= GenItemList.setUpItemList();

        Pane mainPane=getMainPane();
        Scene mainScene=new Scene(mainPane);
        primaryStage.setScene(mainScene);

    }

    public static BasedCharacter getMainChacter() {
        return mainChacter;
    }

    public static void setMainChacter(BasedCharacter mainChacter) {
        Launcher.mainChacter = mainChacter;
    }

    public Pane getMainPane() {
        BorderPane mainPane=new BorderPane();
         characterPane=new CharacterPane();
         equipPane=new EquipPane();
         inventoryPane=new InventoryPane();
        refreshPane();
        mainPane.setCenter(characterPane);
        mainPane.setLeft(equipPane);
        mainPane.setBottom(inventoryPane);
        return mainPane;
    }

    public static void refreshPane() {
        characterPane.drawPane(mainChacter);
        equipPane.drawPane(equippedWeapon,equippedArmor);
        inventoryPane.drawPane(allEquipments);

    }

    public static void main(String[] args) {
        launch();
    }
}