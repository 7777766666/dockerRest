package tesla.docker.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class QuickSort {
    private Integer[] arr;

    public QuickSort(){
            }

    public QuickSort(Integer[] arr) {
        this.arr = arr;
    }

    public Integer[] getArr() {
        return arr;
    }
}
