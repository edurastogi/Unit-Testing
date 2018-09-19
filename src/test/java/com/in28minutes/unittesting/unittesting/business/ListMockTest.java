package com.in28minutes.unittesting.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

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
}
