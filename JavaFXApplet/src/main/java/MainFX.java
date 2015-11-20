

import javafx.application.Application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainFX extends Application
{
    private TableView<Product> table;
    ObservableList<Product> data;
    Text textStatus;

    public ObservableList getInitialTableData()
    {
        HashMap<String, String> map = JDBC.executeQuery();
        List<Product> products = new ArrayList<Product>();

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            products.add(new Product(pair.getValue(), pair.getKey()));
        }

        return FXCollections.observableArrayList(products);
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Тестова прога");
  //      Group root = new Group();

        Label label = new Label("Товары и TM");
//        label.setLayoutX(10);
//        label.setLayoutY(10);
        label.setPrefSize(300, 30);
        label.setStyle("-fx-font: bold italic 16pt Georgia;-fx-text-fill:#000066;-fx-background-color:lightgrey;");
        label.setAlignment(Pos.CENTER);

        HBox HBoxLabel = new HBox();
        HBoxLabel.setAlignment(Pos.CENTER);
        HBoxLabel.getChildren().add(label);


        table = new TableView<Product>();
        table.setEditable(true);


        table.setTableMenuButtonVisible(true);
        table.setTooltip(new Tooltip("Мониторинг продуктов"));
        table.setStyle("-fx-font: 14pt Arial;");
        table.setPrefWidth(300);
        table.setPrefHeight(250);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.getSelectionModel().selectedIndexProperty().addListener(new RowSelectChangeListener());

        TableColumn productCol = new TableColumn("Продукт");
        productCol.setCellValueFactory( new PropertyValueFactory("productNameS") );

        productCol.setCellFactory(TextFieldTableCell.forTableColumn());
        productCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>()
        {

            public void handle(TableColumn.CellEditEvent event)
            {
                int index = table.getSelectionModel().getSelectedIndex();
                String tm = table.getItems().get(index).getTmS();

                String s = String.format("UPDATE snpch SET goods = '%s' WHERE goods = '%s' and tm = '%s' ", event.getNewValue(), event.getOldValue(), tm);
                System.out.println(s);


                int indexPos = event.getTablePosition().getRow();
                Product product = (Product)event.getTableView().getItems().get(indexPos);
                product.setProductNameS((String) event.getNewValue());

                JDBC.execute(s);
            }
        });


        TableColumn tmCol = new TableColumn("TM");
        tmCol.setCellValueFactory(new PropertyValueFactory("tmS"));


        tmCol.setCellFactory(TextFieldTableCell.forTableColumn());
        tmCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, String>>()
        {


            public void handle(TableColumn.CellEditEvent<Product, String> event)
            {
                int index = table.getSelectionModel().getSelectedIndex();
                String good = table.getItems().get(index).getProductNameS();

                String s = String.format("UPDATE snpch SET tm = '%s' WHERE tm = '%s' and goods = '%s' ", event.getNewValue(), event.getOldValue(), good);
                System.out.println(s);

                ((Product) event.getTableView().getItems().get(
                        event.getTablePosition().getRow())
                ).setTmS(event.getNewValue());

                JDBC.execute(s);

            }


        });



        data = getInitialTableData();
        table.setItems(data);
        table.getColumns().addAll(productCol, tmCol);

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new DeleteEventHadler());

        Button addButton = new Button("Add");
        addButton.setOnAction(new AddEventandler());

        HBox hBottons = new HBox(10);
        hBottons.getChildren().addAll(addButton, deleteButton);
        hBottons.setAlignment(Pos.CENTER);

        textStatus = new Text();
        textStatus.setFill(Color.FIREBRICK);

        table.getSelectionModel().select(0);
        Product product = table.getSelectionModel().getSelectedItem();
        textStatus.setText(product.toString());

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(25, 25, 25, 25));
        vbox.getChildren().addAll(HBoxLabel, table, hBottons, textStatus);

        Scene scene = new Scene(vbox, 350, 400, Color.AZURE);
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    class RowSelectChangeListener implements ChangeListener<Number>
    {

        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
        {
            int ix = newValue.intValue();
            Product product = data.get(ix);
            textStatus.setText(product.toString());

        }

    }


    class DeleteEventHadler implements EventHandler<ActionEvent>
    {

        public void handle(ActionEvent event)
        {
            int ix = table.getSelectionModel().getSelectedIndex();
            Product product = data.get(ix);

            String tm = String.format("DELETE FROM snpch WHERE tm='%s'", data.get(ix).getTmS());

            data.remove(ix);

           JDBC.execute(tm);

            table.requestFocus();
            table.getFocusModel().focus(ix - 1);
            table.getSelectionModel().select(ix - 1);

            textStatus.setText("Deleted: " + product.toString());
        }
    }

    class AddEventandler implements EventHandler<ActionEvent>
    {

        public void handle(ActionEvent event)
        {
            int ix = data.size();
            data.add(new Product("...", "..."));

            String addStars = "INSERT INTO snpch (goods, tm) VALUES ('...', '...')";
            JDBC.execute(addStars);

            table.requestFocus();
            table.getFocusModel().focus(ix);
            table.getSelectionModel().select(ix);

            textStatus.setText("New product: Enter NAME and TM. Press <Enter>.");
        }
    }
}