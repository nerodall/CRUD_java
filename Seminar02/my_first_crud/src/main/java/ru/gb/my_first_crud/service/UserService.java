package ru.gb.my_first_crud.service;


import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import ru.gb.my_first_crud.aspect.TrackUserAction;
import ru.gb.my_first_crud.model.User;
import ru.gb.my_first_crud.repository.UserRepository;
import java.util.List;

@Service
@EnableAspectJAutoProxy
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @TrackUserAction
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @TrackUserAction
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public User getUser (int id){
        return userRepository.findById(id);
    }

    public void updateUser(User user){
        userRepository.update(user);
    }
}
