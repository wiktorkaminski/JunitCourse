package mockito.business;

import mockito.data.api.ToDoService;
import mockito.data.api.TodoServiceStub;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveToDosRelatedToSpring_usingAMock() {
        ToDoService todoServiceMock = mock(ToDoService.class);
    
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learns Spring", "Learn to dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);
        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");

        assertEquals(2, filteredToDos.size());
    }
    
    @Test
    public void testRetrieveToDosRelatedToSpring_emptyList() {
        ToDoService todoServiceMock = mock(ToDoService.class);
        
        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);
        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");
        
        assertEquals(0, filteredToDos.size());
    }
}
