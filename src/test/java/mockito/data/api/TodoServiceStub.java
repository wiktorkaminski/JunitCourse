package mockito.data.api;


import java.util.Arrays;
import java.util.List;


public class TodoServiceStub implements ToDoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learns Spring", "Learn to dance");
    }
}
