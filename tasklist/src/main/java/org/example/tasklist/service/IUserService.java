package org.example.tasklist.service;

import org.example.tasklist.domain.user.User;

public interface IUserService {

    User getById(Long id);

    User getByUsername(String username);

    User update(User user);

    User create(User user);

    boolean isTaskOwner(Long userId, Long taskId);

    void delete(Long id);
}
