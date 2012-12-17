package hrm.repo.service;

import hrm.repo.domain.User;

public interface UserRepository {

    public void create(User user);

    public void changePassword(String currentPassword, String newPassword);
}
