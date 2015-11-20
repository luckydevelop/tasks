/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Test extends Application {
    Button btn;
    Button btnON;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("???????????? GUI-???????????");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.LIGHTGREEN);
        btn = new Button();
        btn.setLayoutX(20);
        btn.setLayoutY(20);
        btn.setText("??????????? ????????");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("????????, ?????????????? ?? ?????? Node:"+"\n"+
                        "???????? blendMode: "+btn.blendModeProperty().getValue()+"\n"+
                        "???????? boundsInLocal: "+btn.boundsInLocalProperty().getValue()+"\n"+
                        "???????? boundsInParent: "+btn.boundsInParentProperty().getValue()+"\n"+
                        "???????? cacheHint: "+btn.cacheHintProperty().getValue()+"\n"+
                        "???????? cache: "+btn.cacheProperty().getValue()+"\n"+
                        "???????? clip: "+btn.clipProperty().getValue()+"\n"+
                        "???????? cursor: "+btn.cursorProperty().getValue()+"\n"+
                        "???????? depthTest: "+btn.depthTestProperty().getValue()+"\n"+
                        "???????? disabled: "+btn.disabledProperty().getValue()+"\n"+
                        "???????? disable: "+btn.disableProperty().getValue()+"\n"+
                        "???????? effect: "+btn.effectProperty().getValue()+"\n"+
                        "???????? eventDispatcher: "+btn.eventDispatcherProperty().getValue()+"\n"+
                        "???????? focused: "+btn.focusedProperty().getValue()+"\n"+
                        "???????? focusTraversable: "+btn.focusTraversableProperty().getValue()+"\n"+
                        "???????? hover: "+btn.hoverProperty().getValue()+"\n"+
                        "???????? id: "+btn.idProperty().getValue()+"\n"+
                        "???????? inputMethodRequests: "+btn.inputMethodRequestsProperty().getValue()+"\n"+
                        "???????? layoutBounds: "+btn.layoutBoundsProperty().getValue()+"\n"+
                        "???????? layoutX: "+btn.layoutXProperty().getValue()+"\n"+
                        "???????? layoutY: "+btn.layoutYProperty().getValue()+"\n"+
                        "???????? managed: "+btn.managedProperty().getValue()+"\n"+
                        "???????? mouseTransparent: "+btn.mouseTransparentProperty().getValue()+"\n"+
                        "???????? onDragDetected: "+btn.onDragDetectedProperty().getValue()+"\n"+
                        "???????? onDragDone: "+btn.onDragDoneProperty().getValue()+"\n"+
                        "???????? onDragDropped: "+btn.onDragDroppedProperty().getValue()+"\n"+
                        "???????? onDragEntered: "+btn.onDragEnteredProperty().getValue()+"\n"+
                        "???????? onDragExited: "+btn.onDragExitedProperty().getValue()+"\n"+
                        "???????? onDragOver: "+btn.onDragOverProperty().getValue()+"\n"+
                        "???????? onInputMethodTextChanged: "+btn.onInputMethodTextChangedProperty().getValue()+"\n"+
                        "???????? onKeyPressed: "+btn.onKeyPressedProperty().getValue()+"\n"+
                        "???????? onKeyReleased: "+btn.onKeyReleasedProperty().getValue()+"\n"+
                        "???????? onKeyTyped: "+btn.onKeyTypedProperty().getValue()+"\n"+
                        "???????? onMouseClicked: "+btn.onMouseClickedProperty().getValue()+"\n"+
                        "???????? onMouseDragged: "+btn.onMouseDraggedProperty().getValue()+"\n"+
                        "???????? onMouseEntered: "+btn.onMouseEnteredProperty().getValue()+"\n"+
                        "???????? onMouseExited: "+btn.onMouseExitedProperty().getValue()+"\n"+
                        "???????? onMouseMoved: "+btn.onMouseMovedProperty().getValue()+"\n"+
                        "???????? onMousePressed: "+btn.onMousePressedProperty().getValue()+"\n"+
                        "???????? onMouseReleased: "+btn.onMouseReleasedProperty().getValue()+"\n"+
                        "???????? opacity: "+btn.opacityProperty().getValue()+"\n"+
                        "???????? parent: "+btn.parentProperty().getValue()+"\n"+
                        "???????? pickOnBounds: "+btn.pickOnBoundsProperty().getValue()+"\n"+
                        "???????? pressed: "+btn.pressedProperty().getValue()+"\n"+
                        "???????? rotate: "+btn.rotateProperty().getValue()+"\n"+
                        "???????? rotationAxis: "+btn.rotationAxisProperty().getValue()+"\n"+
                        "???????? scaleX: "+btn.scaleXProperty().getValue()+"\n"+
                        "???????? scaleY: "+btn.scaleYProperty().getValue()+"\n"+
                        "???????? scaleZ: "+btn.scaleZProperty().getValue()+"\n"+
                        "???????? scene: "+btn.sceneProperty().getValue()+"\n"+
                        "???????? style: "+btn.styleProperty().getValue()+"\n"+
                        "???????? translateX: "+btn.translateXProperty().getValue()+"\n"+
                        "???????? translateY: "+btn.translateYProperty().getValue()+"\n"+
                        "???????? translateZ: "+btn.translateZProperty().getValue()+"\n"+
                        "???????? visible: "+btn.visibleProperty().getValue()+"\n"+
                        "\n"+
                        "????????, ?????????????? ?? ?????? Parent:"+"\n"+
                        "???????? needsLayout: "+btn.needsLayoutProperty().getValue()+"\n"+
                        "\n"+
                        "????????, ?????????????? ?? ?????? Control:"+"\n"+
                        "???????? contextMenu: "+btn.contextMenuProperty().getValue()+"\n"+
                        "???????? height: "+btn.heightProperty().getValue()+"\n"+
                        "???????? maxHeight: "+btn.maxHeightProperty().getValue()+"\n"+
                        "???????? maxWidth: "+btn.maxWidthProperty().getValue()+"\n"+
                        "???????? minHeight: "+btn.minHeightProperty().getValue()+"\n"+
                        "???????? minWidth: "+btn.minWidthProperty().getValue()+"\n"+
                        "???????? prefHeight: "+btn.prefHeightProperty().getValue()+"\n"+
                        "???????? prefWidth: "+btn.prefWidthProperty().getValue()+"\n"+
                        "???????? skin: "+btn.skinProperty().getValue()+"\n"+
                        "???????? tooltip: "+btn.onMouseClickedProperty().getValue()+"\n"+
                        "???????? width: "+btn.widthProperty().getValue()+"\n"+
                        "\n"+
                        "????????, ?????????????? ?? ?????? Labeled"+"\n"+
                        "???????? alignment: "+btn.alignmentProperty().getValue()+"\n"+
                        "???????? contentDisplay: "+btn.contentDisplayProperty().getValue()+"\n"+
                        "???????? font: "+btn.fontProperty().getValue()+"\n"+
                        "???????? graphic: "+btn.graphicProperty().getValue()+"\n"+
                        "???????? graphicTextGap: "+btn.graphicTextGapProperty().getValue()+"\n"+
                        "???????? labelPadding: "+btn.labelPaddingProperty().getValue()+"\n"+
                        "???????? mnemonicParsing: "+btn.mnemonicParsingProperty().getValue()+"\n"+
                        "???????? textAlignment: "+btn.textAlignmentProperty().getValue()+"\n"+
                        "???????? textFill: "+btn.textFillProperty().getValue()+"\n"+
                        "???????? textOverrun: "+btn.textOverrunProperty().getValue()+"\n"+
                        "???????? text: "+btn.textProperty().getValue()+"\n"+
                        "???????? underline: "+btn.underlineProperty().getValue()+"\n"+
                        "???????? wrapText: "+btn.wrapTextProperty().getValue()+"\n"+
                        "\n"+
                        "????????, ?????????????? ?? ?????? ButtonBase:"+"\n"+
                        "???????? armed: "+btn.armedProperty().getValue()+"\n"+
                        "???????? onAction: "+btn.onActionProperty().getValue()+"\n"+
                        "\n"+
                        "???????? ?????? Button"+"\n"+
                        "???????? cancelButton: "+btn.cancelButtonProperty().getValue()+"\n"+
                        "???????? defaultButton: "+btn.defaultButtonProperty().getValue()+"\n"+
                        "\n");
            }
        });
        //Button btnON = new Button();
        btnON=ButtonBuilder.create().build();
        btnON.setLayoutX(20);
        btnON.setLayoutY(150);
        btnON.setText("?????????? ????????");
        btnON.setStyle("-fx-font:  bold italic 12pt Arial;-fx-text-fill: #660000; -fx-background-color: #ff99ff; -fx-border-width: 3px; -fx-border-radius: 30;-fx-background-radius: 30;-fx-border-color: #660066;" );
        btnON.setPrefSize(200,30);
        btnON.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                btn.setBlendMode(BlendMode.DARKEN);
                javafx.scene.shape.Circle clip =new javafx.scene.shape.Circle(75,53,80);
                //btn.setClip(clip);
                btn.setCursor(Cursor.CLOSED_HAND);
                DropShadow effect=new DropShadow();
                effect.setOffsetX(10);
                effect.setOffsetY(10);
                btn.setEffect(effect);
                //btn.setManaged(false);
                //btn.setMouseTransparent(true);
                btn.setOpacity(0.5);
                btn.setRotate(10);
                btn.setLayoutX(80);
                btn.setScaleX(1.8);
                btn.setLayoutY(170);
                btn.setTranslateZ(-50);
                btn.setPrefSize(150,100);
                btn.setTooltip(new Tooltip("??? ?????? ???????????? ??????? ?????? Button"));
                Image im=new Image(this.getClass().getResource("image.png").toString());
                ImageView imv=new ImageView(im);
                imv.setFitHeight(50);
                imv.setFitWidth(50);
                btn.setGraphic(imv);
                btn.setStyle("-fx-font:  bold italic 10pt Helvetica;");
                //btn.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 10));
                btn.setAlignment(Pos.CENTER);
                btn.setContentDisplay(ContentDisplay.RIGHT);
                btn.setUnderline(true);
                btn.setWrapText(true);
                // btn.setCancelButton(true);
                //btn.toBack();
            }
        });
        root.getChildren().add(btnON);
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
