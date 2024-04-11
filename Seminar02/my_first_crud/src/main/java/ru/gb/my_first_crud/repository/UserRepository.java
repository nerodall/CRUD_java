package ru.gb.my_first_crud.repository;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.my_first_crud.model.User;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {



    private final JdbcTemplate jdbc;


    /**
     * Метод для сбора всех пользователей из БД в List
     * @return
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };


        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Метод сохранения пользователя в БД
     * @param user
     * @return
     */
    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Метод для удаления пользователя из БД по id
     * @param id
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Метод для поиска пользователя в БД по id
     * @param id
     * @return
     */
    public User findById(int id) {
        return findAll().stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .get();

    }

    /**
     * Метод для изменения пользователя в БД
     * @param user
     */
    public void update(User user){
        String sql = "UPDATE userTable SET firstName =?, lastName=? WHERE id =?";
        jdbc.update(sql,user.getFirstName(),user.getLastName(),user.getId());
    }
}
