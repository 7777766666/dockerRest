package tesla.docker.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tesla.docker.model.QuickSort;

@Component
public class AlgoUtil {

    private final static Logger log = LoggerFactory.getLogger(AlgoUtil.class);

    public Integer binarySearch(Integer[] arr, Integer target){
        log.info("start binarySearch in Util class");
        Integer result = bSearch(arr, target);
        return result;
    }

    private Integer bSearch(Integer[] arr, Integer target) {
        Integer l = 0;
        Integer r = arr.length - 1;


        while (l <= r){
            Integer pivot = l + (r - l) / 2;

            if (arr[pivot] == target){
                log.info("Result is {}", pivot);
                return pivot;
            }else if (arr[pivot] < target){
                l = pivot + 1;
            }else {
                r = pivot - 1;
            }
        }


        log.info("Result is {}", l);
        return l;
    }

    public Integer binSearchOrNull(Integer[] arr, Integer target){
        Integer l = 0;
        Integer r = arr.length - 1;


        while (l < r){
            Integer pivot = l + (r - l) / 2;

            if (arr[pivot] == target){
                log.info("Result is {}", pivot);
                return pivot;
            }else if (arr[pivot] < target){
                l = pivot + 1;
            }else {
                r = pivot - 1;
            }
        }


        log.info("Result is NULL");
        return Integer.MIN_VALUE;
    }

    public Integer[] qSort(QuickSort quickSort) {
        log.info("start quick sort in AlgoUtil");
        Integer[] arr = quickSort.getArr();

        Integer[] quSort = quSort(arr);


        return quSort;
    }

    private Integer[] quSort(Integer[] arr) {
        Integer l = 0;
        Integer r = arr.length -1;

        while (l < r){
            Integer pivot = l + (l + r) / 2;

        }

        return null;
    }

}
