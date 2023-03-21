package com.example.todolist;

import com.example.todolist.datamodel.TodoData;
import com.example.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    private List<TodoItem> todoItems;

    @FXML
    public void initialize() {
//        TodoItem item1 = new TodoItem("mail card", "mail card to someone", LocalDate.of(2023, Month.APRIL, 25));
//        TodoItem item2 = new TodoItem("doctor", "dentist", LocalDate.of(2023, Month.MAY, 23));
//        TodoItem item3 = new TodoItem("design", "website mock up", LocalDate.of(2023, Month.APRIL, 22));
//        TodoItem item4 = new TodoItem("pickup", "someone arriving", LocalDate.of(2023, Month.MARCH, 23));
//        TodoItem item5 = new TodoItem("dry cleaning", "pick up", LocalDate.of(2023, Month.APRIL, 20));
//
//        todoItems = new ArrayList<TodoItem>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//
//        TodoData.getInstance().setTodoItems(todoItems);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem OldValue, TodoItem newValue) {
                if (newValue != null) {
                    TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }
}