package com.chj.usercenter.service.mapper;

import com.chj.usercenter.domain.UserE;
import com.chj.usercenter.service.dto.UserDTO;
import com.chj.usercenter.web.rest.vm.UserVM;
import com.chj.usercenter.web.rest.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO vmToDto(UserVM vm);

    UserE toEntity(UserDTO dto);

    List<UserDTO> toDTO(List<UserE> entityList);
    UserDTO toDTO(UserE user);

    List<UserVO> toVO(List<UserDTO> dtoList);

    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVO toVO(UserDTO dto);
}
