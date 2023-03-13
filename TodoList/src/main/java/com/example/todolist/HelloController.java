package com.example.todolist;

import com.example.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    private List<TodoItem> todoItems;

    @FXML
    public void initialize() {
        TodoItem item1 = new TodoItem("mail card", "mail card to someone", LocalDate.of(2023, Month.APRIL, 25));
        TodoItem item2 = new TodoItem("doctor", "dentist", LocalDate.of(2023, Month.MAY, 23));
        TodoItem item3 = new TodoItem("design", "website mock up", LocalDate.of(2023, Month.APRIL, 22));
        TodoItem item4 = new TodoItem("pickup", "someone arriving", LocalDate.of(2023, Month.MARCH, 23));
        TodoItem item5 = new TodoItem("dry cleaning", "pick up", LocalDate.of(2023, Month.APRIL, 20));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);
    }
}