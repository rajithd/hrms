package hrm.repo.service;

import hrm.repo.domain.User;

import java.sql.SQLException;

public interface UserRepository {

    public void create(User user) throws SQLException;

    public void changePassword(String newPassword, String username) throws SQLException;

    public boolean isCorrectCurrentPassword(String password, String username) throws SQLException;
}
