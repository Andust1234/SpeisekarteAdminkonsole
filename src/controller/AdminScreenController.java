package controller;

import entitys.*;
import entitys.Menu;
import interfaces.LogoutListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdminScreenController {

    private LogoutListener logoutListener;
    private ObservableList<String> dishesList;
    private DishWrapper dishWrapper;
    private final FileChooser fileChooser = new FileChooser();
    private Stage stage;

    @FXML
    MenuItem btnLogout;

    @FXML
    ListView<String> dishListView;

    @FXML
    TextField title;

    @FXML
    TextArea description;

    @FXML
    TextArea allergy;

    @FXML
    TextField price;

    @FXML
    ComboBox<String> currency;

    @FXML
    ComboBox<String> menu;

    @FXML
    CheckBox meat, fish, vegetable;

    @FXML
    Button btnSave;

    @FXML
    MenuItem btnNew;

    @FXML
    ImageView image;

    @FXML
    Button btnChangeImage;

    @FXML
    private void initialize() {
        btnLogout.setOnAction(event -> logoutListener.onLogout());
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        initCurrency();
        initMenu();
        initCheckBox();
    }

    private void initCheckBox() {
        meat.setText(Category.MEAT.getName());
        fish.setText(Category.FISH.getName());
        vegetable.setText(Category.VEGETABLE.getName());
    }

    private void initMenu() {
        List<String> strings = new ArrayList<>();
        strings.add(Menu.SEASON.getName());
        strings.add(Menu.GENERAL.getName());
        strings.add(Menu.CACHE.getName());
        ObservableList<String> observableList = FXCollections.observableList(strings);
        menu.getItems().clear();
        menu.setItems(observableList);
    }

    private void initCurrency() {
        List<String> strings = new ArrayList<>();
        strings.add(Currency.EURO.getSign());
        strings.add(Currency.USD.getSign());
        ObservableList<String> observableList = FXCollections.observableList(strings);
        currency.getItems().clear();
        currency.setItems(observableList);
    }

    public void setLogoutListener(LogoutListener logoutListener) {
        this.logoutListener = logoutListener;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setDishes(DishWrapper dishes) {
        this.dishWrapper = dishes;
        if (dishesList != null) {
            dishesList.clear();
        }
        if (dishListView != null) {
            dishListView.refresh();
        }
        dishesList = FXCollections.observableArrayList(dishes.getNames());
        dishListView.setOrientation(Orientation.VERTICAL);
        dishListView.setItems(dishesList);
        dishListView.refresh();
        dishListView.setOnMouseClicked(event -> {
            System.out.println("Selected " + dishListView.getSelectionModel().getSelectedIndex());
            handleClick(dishListView.getSelectionModel().getSelectedIndex());
        });
        btnNew.setOnAction(event -> {
            dishListView.getSelectionModel().select(null);
            resetForm();
        });
    }

    private void resetForm() {
        title.setText("Titel");
        description.setText("Beschreibung");
        allergy.setText("Allergiehinweise");
        price.setText("0.0");
        meat.setSelected(false);
        fish.setSelected(false);
        vegetable.setSelected(false);
        currency.getSelectionModel().select(0);
        menu.getSelectionModel().select(0);
        btnSave.setOnAction(event -> {
            Currency selCurrency;
            if (currency.getSelectionModel().getSelectedItem().equals(Currency.USD.getSign())) {
                selCurrency = Currency.USD;
            } else {
                selCurrency = Currency.EURO;
            }
            List<Category> selList = new ArrayList<>();
            if (meat.isSelected()) {
                selList.add(Category.MEAT);
            }
            if (fish.isSelected()) {
                selList.add(Category.FISH);
            }
            if (vegetable.isSelected()) {
                selList.add(Category.VEGETABLE);
            }
            Menu selMenu;
            if (menu.getSelectionModel().getSelectedItem().equals(Menu.SEASON.getName())) {
                selMenu = Menu.SEASON;
            } else if (menu.getSelectionModel().getSelectedItem().equals(Menu.GENERAL.getName())) {
                selMenu = Menu.GENERAL;
            } else {
                selMenu = Menu.CACHE;
            }

            dishWrapper.getDishes().add(0, new Dish(title.getText(), description.getText(), Float.parseFloat(price.getText()), selCurrency, allergy.getText(), selList, selMenu));
            setDishes(dishWrapper);
        });
    }

    private void handleClick(int selectedIndex) {
        Dish selected = dishWrapper.getDishes().get(selectedIndex);
        title.setText(selected.getName());
        description.setText(selected.getDescription());
        allergy.setText(selected.getAlergyNotes());
        price.setText(String.valueOf(selected.getPrice()));

        currency.getSelectionModel().select(selected.getCurrency().getSign());
        menu.getSelectionModel().select(selected.getMenu().getName());

        meat.setSelected(false);
        fish.setSelected(false);
        vegetable.setSelected(false);

        image.setImage(selected.getImage());

        for (Category category : selected.getCategories()) {
            switch (category) {
                case MEAT:
                    meat.setSelected(true);
                    break;
                case FISH:
                    fish.setSelected(true);
                    break;
                case VEGETABLE:
                    vegetable.setSelected(true);
                    break;
            }
        }

        btnChangeImage.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                image.setImage(new Image(file.toURI().toString()));
            }
        });

        btnSave.setOnAction(event ->

        {
            selected.setName(title.getText());
            selected.setDescription(description.getText());
            selected.setAlergyNotes(allergy.getText());
            float pri = 0F;
            try {
                pri = Float.parseFloat(price.getText());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            selected.setPrice(pri);
            String s = currency.getSelectionModel().getSelectedItem();
            if (s.equals(Currency.EURO.getSign())) {
                selected.setCurrency(Currency.EURO);
            } else if (s.equals(Currency.USD.getSign())) {
                selected.setCurrency(Currency.USD);
            }
            String st = menu.getSelectionModel().getSelectedItem();
            if (st.equals(Menu.SEASON.getName())) {
                selected.setMenu(Menu.SEASON);
            } else if (st.equals(Menu.GENERAL.getName())) {
                selected.setMenu(Menu.GENERAL);
            } else {
                selected.setMenu(Menu.CACHE);
            }
            selected.getCategories().remove(Category.MEAT);
            if (meat.isSelected()) {
                selected.getCategories().add(Category.MEAT);
            }
            selected.getCategories().remove(Category.FISH);
            if (fish.isSelected()) {
                selected.getCategories().add(Category.FISH);
            }
            selected.getCategories().remove(Category.VEGETABLE);
            if (vegetable.isSelected()) {
                selected.getCategories().add(Category.VEGETABLE);
            }
            selected.setImage(image.getImage());
            setDishes(dishWrapper);
        });

    }
}
