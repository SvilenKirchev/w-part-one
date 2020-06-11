package wpartone.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wpartone.model.entity.User;
import wpartone.model.service.UserServiceModel;
import wpartone.repository.UserRepository;
import wpartone.service.RoleService;
import wpartone.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        userServiceModel.setRole(this.roleService.findByName(this.userRepository.count() == 0 ? "ADMIN" : "USER"));

        User user = this.modelMapper
                .map(userServiceModel, User.class);


        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }
}
