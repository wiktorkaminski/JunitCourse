package mockito.business;

import static org.junit.Assert.*;
import mockito.data.api.ToDoService;
import mockito.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.List;

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveToDosRelatedToSpring_usingAStub() {
        ToDoService todoServiceStub = new TodoServiceStub();
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceStub);

        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");

        assertEquals(2, filteredToDos.size());
    }
}
