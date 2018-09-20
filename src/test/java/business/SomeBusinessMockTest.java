package business;

import data.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @Mock
    SomeDataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl business;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3, 4});
        assertEquals(10, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5, business.calculateSumUsingDataService());
    }

    //SomeBusinessImpl business = new SomeBusinessImpl();
    //SomeDataService dataServiceMock = mock(SomeDataService.class);

    /*@Before
    public void before() {
        business.setSomeDataService(dataServiceMock);
    }*/
}
