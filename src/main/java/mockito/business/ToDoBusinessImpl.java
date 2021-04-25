package mockito.business;

import mockito.data.api.ToDoService;

import java.util.ArrayList;
import java.util.List;

public class ToDoBusinessImpl {
    private ToDoService toDoService;

    public ToDoBusinessImpl(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public List<String> retrieveToDosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = toDoService.retrieveTodos(user);
        for (String todo : todos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
