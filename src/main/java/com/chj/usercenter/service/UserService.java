package com.chj.usercenter.service;

import com.chj.usercenter.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Page<UserDTO> findByCondition(UserDTO userDTO, Pageable pageable);

    UserDTO findById(Long id);

    List<UserDTO> findAll();

    UserDTO save(UserDTO userDTO);

    void saveAll(List<UserDTO> list);

    void deleteById(Long id);

//    void testTxPrivateLocal(UserDTO user);
//
//    void testTxPublicInterface(UserDTO user);

}
