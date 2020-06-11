package wpartone.service;


import wpartone.model.service.RoleServiceModel;

public interface RoleService {

    RoleServiceModel findByName(String name);
}
