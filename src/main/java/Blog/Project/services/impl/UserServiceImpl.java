package Blog.Project.services.impl;

import Blog.Project.entity.User;
import Blog.Project.exceptions.ResourceNotFoundException;
import Blog.Project.paylods.UserDto;
import Blog.Project.reposeteries.UsersRepository;
import Blog.Project.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ModelMapper modelMapper;






//create user
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.usersRepository.save(user);


        return this.userToDto(savedUser);
    }





 //update user

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user= this.usersRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));


        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUSer = this.usersRepository.save(user);
        UserDto userDto1 = this.userToDto(updatedUSer);

        return userDto1;
    }


//get user by id

    @Override
    public UserDto getUser(Integer userId) {
        User user= this.usersRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));

        return this.userToDto(user);
    }


//get all users

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users =this.usersRepository.findAll();
        List<UserDto>  userDtos= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());


        return userDtos;
    }
//delete user
    @Override
    public void deleteUser(Integer userId) {

        User user= this.usersRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));
        this.usersRepository.delete(user);


    }

    public User dtoToUser(UserDto userDto) {
        User user=this.modelMapper.map(userDto,User.class);
        return user;

    }


    public UserDto userToDto(User user){
        UserDto userDto=this.modelMapper.map(user,UserDto.class);
        return userDto;
    }





}






















