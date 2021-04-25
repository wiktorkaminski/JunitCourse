package mockito.business;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


public class ListBDDTest {

    @Test
    public void listGetMethod_usingBDD() {
        // Given
        List<String> listMock = mock(List.class);
        given(listMock.get(0)).willReturn("Mock returns a String");

        // When
        String firstElement = listMock.get(0);

        // Then
        assertThat(firstElement, is("Mock returns a String"));
    }

}
