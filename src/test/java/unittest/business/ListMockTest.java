package unittest.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock = Mockito.mock(List.class);

    @Test
    public void sizeBasicTest(){
        List mock = Mockito.mock(List.class);
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnDifferentValueTest(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParametersTest(){
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));

        //assertEquals("in28Minutes", mock.get(1)); //this will fail as 2nd element of list is not defined
    }

    @Test
    public void returnWithGenericParametersTest(){
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));
        assertEquals("in28Minutes", mock.get(1)); //Will pass
    }

    @Test
    public void verificationBasics(){
        //SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);
        //Verify
        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(2);
    }

    @Test
    public void argumentCapturingTest(){
       //SUT
        mock.add("SomeString");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturingTest(){
        //SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();

        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));//null
        System.out.println(arrayListMock.size());//0
        arrayListMock.add("Test");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());//0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());

        // A mock does not retain behavior (code) of the original class
        // A spy, by default, retains behavior (code) of the original class !

    }

    @Test
    public void spying(){
        // You can stub (override) and verify specific behavior (methods) on a Spy!
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));//null
        System.out.println(arrayListSpy.size());//0
        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());//0
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());

        arrayListSpy.add("Test4");
        System.out.println(arrayListSpy.size());

        verify(arrayListSpy).add("Test4");
    }
}
