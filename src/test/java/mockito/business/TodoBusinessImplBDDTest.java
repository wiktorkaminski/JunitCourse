package mockito.business;

import mockito.data.api.ToDoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

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

    @Test
    public void testDeleteToDosNotRelatedToSpring_usingBDD() {
        // Given
        ToDoService todoServiceMock = mock(ToDoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learns Spring", "Learn to dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);

        // When
        toDoBusinessImpl.deleteToDosNotRelatedToSpring("Dummy");

        // Then
        verify(todoServiceMock).deleteToDo("Learn to dance");
        then(todoServiceMock).should().deleteToDo("Learn to dance");
        verify(todoServiceMock, times(1)).deleteToDo("Learn to dance");
        then(todoServiceMock).should(times(1)).deleteToDo("Learn to dance");
        verify(todoServiceMock, never()).deleteToDo("Learn Spring MVC");
        then(todoServiceMock).should(never()).deleteToDo("Learn to dance");
    }

    @Test
    public void testDeleteToDosNotRelatedToSpring_usingBDD_argumentCapture() {

        //Declare Argument Captor
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        // Given
        ToDoService todoServiceMock = mock(ToDoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learns Spring", "Learn to dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);

        // When
        toDoBusinessImpl.deleteToDosNotRelatedToSpring("Dummy");

        // Then
        then(todoServiceMock).should().deleteToDo(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("Learn to dance"));

    }

    @Test
    public void testDeleteToDosNotRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {

        //Declare Argument Captor
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        // Given
        ToDoService todoServiceMock = mock(ToDoService.class);
        List<String> todos = Arrays.asList("Learn to dive", "Learns Spring", "Learn to dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        ToDoBusinessImpl toDoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);

        // When
        toDoBusinessImpl.deleteToDosNotRelatedToSpring("Dummy");

        // Then
        then(todoServiceMock).should(atLeast(1)).deleteToDo(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(2));

    }
}
