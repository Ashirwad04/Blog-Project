package Blog.Project.services;

import Blog.Project.paylods.UserDto;

import java.util.List;

public interface UserService {


    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Integer userId);
    UserDto getUser(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);


    class UserServiceImpl implements UserService {


     //create user
        @Override
        public UserDto createUser(UserDto user) {
            return null;
        }



    //update user
        @Override
        public UserDto updateUser(UserDto user, Integer userId) {
            return null;
        }


    // get user by id

        @Override
        public UserDto getUser(Integer userId) {
            return null;
        }

    // get all users

        @Override
        public List<UserDto> getAllUsers() {
            return List.of();
        }
    //delete user by id
        @Override
        public void deleteUser(Integer userId) {

        }
    }
}
