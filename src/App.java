import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import convert.BaseUnits;
import convert.TypeOfUnit;
import convert.length.Length;
import convert.mass.Mass;
import convert.time.Time;
import convert.volume.Volume;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;             
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class App extends Application{
    
    private ComboBox<TypeOfUnit> categoryOfUnit = new ComboBox<>();
    private ComboBox<BaseUnits> leftUnitBox = new ComboBox<>();
    private TextField leftValue = new TextField();
    private ComboBox<BaseUnits> rightUnitBox = new ComboBox<>();
    private TextField rightValue = new TextField();
    private Text equalsSign = new Text("=");
    private TypeOfUnit lengthUnit = new Length();
    private TypeOfUnit volumeUnit = new Volume();
    private TypeOfUnit massUnit = new Mass();
    private TypeOfUnit timeUnit = new Time();
    private List<TypeOfUnit> listOfUnits 
    = new ArrayList<>(Arrays.asList(lengthUnit, volumeUnit, massUnit,timeUnit));
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane allPanes = new GridPane();
        allPanes.setAlignment(Pos.CENTER);
        allPanes.setVgap(25);
        allPanes.setHgap(1);

        VBox leftUnitConverter =  new VBox();
        leftValue.setPrefWidth(50);
        leftUnitConverter.setPadding(new Insets(10,10,10,10));
        leftUnitConverter.setSpacing(10);
        leftUnitConverter.getChildren().addAll(leftValue, leftUnitBox);

        VBox equals = new VBox();
        equalsSign.setFont((Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,20)));
        equals.setPadding(new Insets(10,10,10,10));
        equals.setSpacing(10);
        equals.getChildren().addAll(equalsSign);
        

        VBox rightUnitConverter = new VBox();
        rightValue.setPrefWidth(50);
        rightUnitConverter.setPadding(new Insets(10,10,10,10));
        rightUnitConverter.setSpacing(10);
        rightUnitConverter.getChildren().addAll(rightValue, rightUnitBox );
      

        HBox unitTypeBox = new HBox();
        categoryOfUnit.getItems().addAll(listOfUnits);
        categoryOfUnit.setConverter(new StringConverter<TypeOfUnit>() {

            @Override
            public TypeOfUnit fromString(String arg0) {
                return null;
            }

            @Override
            public String toString(TypeOfUnit typeOfUnit) {
                return typeOfUnit.getTypeOfUnit();
            }  
        });
        categoryOfUnit.getSelectionModel().selectFirst();
        unitTypeBox.setPadding(new Insets(10,10,10,10));
        unitTypeBox.setSpacing(10);
        unitTypeBox.getChildren().addAll(categoryOfUnit);

        List<BaseUnits> listOfBaseUnits = categoryOfUnit.getValue().getListOfBaseUnit();
        leftUnitBox.getItems().addAll(listOfBaseUnits);
        rightUnitBox.getItems().addAll(listOfBaseUnits);
        
        StringConverter<BaseUnits> baseUnitStringConverter = new StringConverter<BaseUnits>() {

            @Override
            public BaseUnits fromString(String arg0) {
                return null;
            }

            @Override
            public String toString(BaseUnits baseUnits) {
                return baseUnits.getName();
            }
            
        };

        leftUnitBox.setConverter(baseUnitStringConverter);
        leftUnitBox.getSelectionModel().selectFirst();

        rightUnitBox.setConverter(baseUnitStringConverter);
        rightUnitBox.getSelectionModel().selectLast();

        leftValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()== KeyCode.ENTER){
                    convertLeftToRight();
                }
            }
            
        });

        rightValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    convertRightToLeft();
                }
            }
            
        });

        leftUnitBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                convertRightToLeft();
            }
        });

        rightUnitBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                convertLeftToRight();
            }
        });

        categoryOfUnit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                unitTypeChange();
            }
        });


        allPanes.add(rightUnitConverter, 2, 1);
        allPanes.add(leftUnitConverter, 0, 1);
        allPanes.add(equals,1, 1);
        allPanes.add(unitTypeBox, 0,0);


        Scene scene = new Scene(allPanes, 400, 200);
        primaryStage.setTitle("Metric Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void unitTypeChange(){
        ObservableList <BaseUnits> newBaseUnits = 
        FXCollections.observableArrayList(categoryOfUnit.getValue().getListOfBaseUnit());
        
        leftValue.setText("");
        rightValue.setText("");


        leftUnitBox.setItems(newBaseUnits);
        rightUnitBox.setItems(newBaseUnits);

        leftUnitBox.getSelectionModel().selectFirst();
        rightUnitBox.getSelectionModel().selectLast();
    }

    private void convertLeftToRight(){
        if(leftValue.getText().isBlank()){
            rightValue.setText("");
        }else{
            TypeOfUnit typeOfUnit = categoryOfUnit.getValue();
            Double fromValue = Double.parseDouble(leftValue.getText());
            Double toValue = typeOfUnit.convert(fromValue, leftUnitBox.getValue(), rightUnitBox.getValue());
            rightValue.setText(toValue.toString());
        }
    }

    private void convertRightToLeft(){
        if(rightValue.getText().isBlank()){
            leftValue.setText("");
        }else{
            TypeOfUnit typeOfUnit = categoryOfUnit.getValue();
            Double fromValue = Double.parseDouble(rightValue.getText());
            Double toValue = typeOfUnit.convert(fromValue, rightUnitBox.getValue(), leftUnitBox.getValue());
            leftValue.setText(toValue.toString());
        }   
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
