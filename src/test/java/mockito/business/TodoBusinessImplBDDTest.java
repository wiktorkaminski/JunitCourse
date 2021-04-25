package mockito.business;

import mockito.data.api.ToDoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

public class TodoBusinessImplBDDTest {

    @Test
    public void testRetrieveToDosRelatedToSpring_usingBDD() {
        // Given
        ToDoService todoServiceMock = mock(ToDoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learns Spring", "Learn to dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);

        // When
        List<String> filteredToDos = toDoBusinessImpl.retrieveToDosRelatedToSpring("Dummy");

        // Then
        assertThat(filteredToDos.size(), is(2));

    }
}
