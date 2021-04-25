package mockito.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ListTest {
    
    @Test
    public void listSizeMethodMock() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    public void listSizeMethodMock_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void listGetMethodMock() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Mock returns a String");
        assertEquals("Mock returns a String", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void listGetMethodMock_throwAnException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
        listMock.get(0);
    }

}
