package com.chj.usercenter.web.rest;

import com.chj.usercenter.domain.UserE;
import com.chj.usercenter.service.UserService;
import com.chj.usercenter.service.dto.UserDTO;
import com.chj.usercenter.service.mapper.UserMapper;
import com.chj.usercenter.web.rest.vm.UserVM;
import com.chj.usercenter.web.rest.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<UserVO> findById(@PathVariable Long id) {
        UserDTO dto = userService.findById(id);
        UserVO vo = userMapper.toVO(dto);
        return ResponseEntity.ok(vo);
    }

    @PostMapping("/save")
    public ResponseEntity<UserVO> save(@RequestBody UserVM vm) {
        UserDTO userDTO = userMapper.vmToDto(vm);
        UserDTO savedDTO = userService.save(userDTO);
        UserVO userVO = userMapper.toVO(savedDTO);
        return ResponseEntity.ok(userVO);
    }

    @PostMapping("/queryCondition")
    public ResponseEntity<Page<UserVO>> queryCondition(@RequestBody UserVM vm) {
        Pageable pageable = PageRequest.of(vm.getPage(), vm.getSize(), Sort.Direction.DESC, "createTime");
        UserDTO userDTO = userMapper.vmToDto(vm);

        //use default
        userDTO.setStartTime(userDTO.getStartTime() + "T00:00:00");
        userDTO.setEndTime(userDTO.getEndTime() + "T23:59:59");

        Page<UserDTO> dtoPage = userService.findByCondition(userDTO, pageable);
        List<UserVO> voList = userMapper.toVO(dtoPage.getContent());
        Page<UserVO> voPage = new PageImpl<>(voList, dtoPage.getPageable(), dtoPage.getTotalElements());
        return ResponseEntity.ok(voPage);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<UserVO>> findAll() {
//        List<UserVO> list = userService.findAll()
//                .stream()
//                .map(userMapper::toDTO)
//                .map(userMapper::toVO)
//                .collect(Collectors.toList());
        List<UserVO> vos = null;
        return ResponseEntity.ok(vos);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/testTxPrivateLocal")
    public ResponseEntity<Void> testTxPrivateLocal(@RequestBody UserE user) {
//        userService.testTxPrivateLocal(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/testTxPublicInterface")
    public ResponseEntity<Void> testTxPublicInterface(@RequestBody UserE user) {
//        userService.testTxPublicInterface(user);
        return ResponseEntity.ok().build();
    }
}
