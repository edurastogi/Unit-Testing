package unittest.business;

import unittest.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data){
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService(){
        int[] data = someDataService.retrieveAllData();
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }
}
