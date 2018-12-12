package com.chj.usercenter.service.mapper;

import com.chj.springbootdemo.domain.User;
import com.chj.springbootdemo.service.dto.UserDTO;
import com.chj.springbootdemo.web.rest.vm.UserVM;
import com.chj.springbootdemo.web.rest.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO vmToDto(UserVM vm);

    User toEntity(UserDTO dto);

    List<UserDTO> toDTO(List<User> entityList);
    UserDTO toDTO(User user);

    List<UserVO> toVO(List<UserDTO> dtoList);

    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVO toVO(UserDTO dto);
}
