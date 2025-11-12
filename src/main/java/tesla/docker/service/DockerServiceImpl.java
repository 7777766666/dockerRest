package tesla.docker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tesla.docker.model.QuickSort;
import tesla.docker.model.User;
import tesla.docker.util.AlgoUtil;

@Service
public class DockerServiceImpl implements DockerService {

    private final AlgoUtil algo;

    private final static Logger log = LoggerFactory.getLogger(DockerServiceImpl.class);

    public DockerServiceImpl(AlgoUtil algo) {
        this.algo = algo;
    }

    @Override
    public Integer sum2(Integer x, Integer y) {
        log.info("Return from Service SumImpl {} + {} = {} from http://localhost:8888/sum?x={}&y={}", x, y, x + y, x, y);

        return x + y;
    }

    @Override
    public String userString(User user) {
        log.info("Work with user {} in service", user.getName());
        String name = user.getName();
        String age = user.getAge().toString();
        log.info("Return from service UserName is {} and age is {}", name, age);
        return String.format("UserName is %s and age is %s", name, age);
    }

    @Override
    public Integer[] quickSort(QuickSort quickSort) {
        log.info("quickSort in service");
        return algo.qSort(quickSort);
    }

    @Override
    public Integer binarSearch(Integer[] arr, Integer target) {
        log.info("Start service binary search");
        return algo.binarySearch(arr, target);
    }

    @Override
    public Integer binarSearchOrNull(Integer[] arr, Integer target) {
        log.info("Start service binary search or Integer.MIN_VALUE");
        return algo.binSearchOrNull(arr, target);
    }
}
