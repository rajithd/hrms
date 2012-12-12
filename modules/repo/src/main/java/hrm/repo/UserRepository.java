package hrm.repo;

import hrm.repo.domain.User;

public interface UserRepository {

    public void createAccount(User user);

    public void changePassword(String currentPassword, String newPassword);
}
