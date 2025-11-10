package tesla.docker.service;

import tesla.docker.model.User;

public interface DockerService {
    Integer sum2(Integer x, Integer y);
    String userString(User user);
}