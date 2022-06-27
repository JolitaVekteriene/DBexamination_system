package lt.codeacademy.repository;

import lt.codeacademy.entity.User;

import java.util.List;

public class UserRepository extends AbstractRepository{   //darbas su DB priima is User Serviso
        public void createUser(User user) {
            modifyEntity(session -> session.persist(user));
        }
    public void updateUser(User user) {
        modifyEntity(session -> session.update(user));
    }
    public List<User> getUsers() {
        return getValue(session -> session.createQuery("FROM user", User.class).list());
    }
}
