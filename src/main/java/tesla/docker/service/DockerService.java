package tesla.docker.service;

import tesla.docker.model.QuickSort;
import tesla.docker.entity.User;

public interface DockerService {
    Integer sum2(Integer x, Integer y);
    String userString(User user);

    Integer[] quickSort(QuickSort quickSort);

    Integer binarSearch(Integer[] arr, Integer target);

    Integer binarSearchOrNull(Integer[] arr, Integer target);
}