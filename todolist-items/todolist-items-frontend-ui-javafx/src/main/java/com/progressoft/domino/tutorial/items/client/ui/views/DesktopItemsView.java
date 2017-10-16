package com.progressoft.domino.tutorial.items.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.sample.items.client.presenters.ItemsPresenter;
import com.progressoft.brix.domino.sample.items.client.views.ItemsView;
import com.progressoft.brix.domino.sample.layout.shared.extension.LayoutContext;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.util.List;
import java.util.Optional;

@UiView(presentable = ItemsPresenter.class)
public class DesktopItemsView implements ItemsView {


    private final VBox vBox = new VBox();
    private NewItemHandler newItemHandler;

    @Override
    public void showAdd() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add item");

        ButtonType loginButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Title");
        TextArea description = new TextArea();
        description.setPromptText("Description");


        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        Label descriptionLabel = new Label("Description:");
        grid.add(descriptionLabel, 0, 1);
        grid.add(description, 1, 1);
        GridPane.setValignment(descriptionLabel, VPos.TOP);
        Node addButton = dialog.getDialogPane().lookupButton(loginButtonType);
        addButton.setDisable(true);

        description.textProperty().addListener((observable, oldValue, newValue) -> {
            addButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(title::requestFocus);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(title.getText(), description.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(titleDesc -> {
            newItemHandler.onNewItem(titleDesc.getKey(), titleDesc.getValue());
        });
    }

    @Override
    public LayoutContext.LayoutContent<VBox> getContent() {
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(10));
        return () -> vBox;
    }

    @Override
    public void addNewItemHandler(NewItemHandler newItemHandler) {
        this.newItemHandler = newItemHandler;
    }

    @Override
    public void addItem(String title, String description, SuccessAddHandler successAddHandler) {
        CenterItem pane = new CenterItem();
        pane.setMinHeight(50);
        pane.setMinWidth(vBox.getMinWidth() - 100);
        pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(3), BorderStroke.DEFAULT_WIDTHS)));

        VBox itemBox = new VBox();
        itemBox.setSpacing(5);
        HBox item = new HBox();
        item.setPadding(new Insets(10));
        item.setSpacing(10);
        CheckBox checkBox = new CheckBox();

        item.getChildren().add(checkBox);

        Text titleLabel = new Text(title);
        titleLabel.setFont(Font.font("Sans-serif", FontWeight.BOLD, 14));
        item.getChildren().add(titleLabel);

        itemBox.getChildren().add(item);


        Text descriptionLabel = new Text(description);
        descriptionLabel.setFont(Font.font("Sans-serif", FontWeight.BOLD, 14));
        HBox descriptionContainer = new HBox();
        descriptionContainer.setPadding(new Insets(0, 0, 5, 10));
        descriptionContainer.getChildren().add(descriptionLabel);
        itemBox.getChildren().add(descriptionContainer);

        pane.getChildren().add(itemBox);

        vBox.getChildren().add(pane);
        checkBox.setOnAction(event -> {
            descriptionLabel.setStrikethrough(checkBox.isSelected());
            titleLabel.setStrikethrough(checkBox.isSelected());
            pane.setDone(checkBox.isSelected());
        });
        successAddHandler.onSuccess(pane);
    }

    @Override
    public void clearAll() {
        vBox.getChildren().clear();

    }

    @Override
    public void remove(List<TodoItem> doneItems) {
        doneItems.stream().map(d -> (CenterItem) d).forEach(p -> vBox.getChildren().remove(p));
    }

    private class CenterItem extends HBox implements TodoItem {

        private boolean done;

        @Override
        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }
}
