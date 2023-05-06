package com.informatics.crud.rest;

import com.informatics.crud.common.Translator;
import com.informatics.crud.entity.LoginEntity;
import com.informatics.crud.entity.UserEntity;
import com.informatics.crud.entity.UserFieldEntity;
import com.informatics.crud.model.LoginResponse;
import com.informatics.crud.model.UserModel;
import com.informatics.crud.model.request.AddUserRequest;
import com.informatics.crud.model.request.AddUserSportFieldRequest;
import com.informatics.crud.model.request.LoginRequest;
import com.informatics.crud.model.response.AddUserResponse;
import com.informatics.crud.model.response.AddUserSportFieldResponse;
import com.informatics.crud.model.response.GetAllResponse;
import com.informatics.crud.service.CommonService;
import com.informatics.crud.service.LoginService;
import com.informatics.crud.service.UserSportFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.informatics.crud.service.UserService;
import java.util.stream.Collectors;

/**
 * @author Ali Alavi
 */

@RequestMapping("/mainRest")
@RestController
public class MainRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSportFieldService userSportFieldService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private LoginService loginService;


        @RequestMapping(value = "/login",method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<LoginResponse> getToken(@RequestBody LoginRequest request) throws Exception {
            String token=commonService.getToken(request.getUserName());
            LoginEntity entity=new LoginEntity();
            entity=loginService.save(request.getUserName(),request.getPassword());
            LoginResponse response=new LoginResponse();
            response.setToken(token);
            response.setId(entity.getId());
            return ResponseEntity.ok(response);
        }


        @RequestMapping(value = "/addUser",method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<AddUserResponse> add(@RequestBody AddUserRequest request) throws Exception {
                UserEntity user=userService.save(Translator.translate(request));
                return ResponseEntity.ok(Translator.translate(user));
            }


        @RequestMapping(value = "/getAll",method = RequestMethod.GET)
        public ResponseEntity<GetAllResponse> getAll(@RequestParam int pageNumber,int pageSize) throws Exception {
            Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Order.asc("name"), Sort.Order.desc("id")));
            Page<UserEntity> userEntities=userService.getAll(pageable);
            GetAllResponse response=new GetAllResponse();
            response.setList(userEntities.getContent().stream().map(Translator::translate).collect(Collectors.toList()));
            response.setTotalPages(userEntities.getTotalPages());
            response.setPageSize(userEntities.getSize());
            return ResponseEntity.ok(response);
        }


        @RequestMapping(value = "/getUser",method = RequestMethod.GET)
        public ResponseEntity<UserModel> getUser(@RequestParam String nationalCode) throws Exception {
            return ResponseEntity.ok(Translator.translate(userService.getUser(nationalCode)));
        }


        @RequestMapping(value = "/editUser",method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<AddUserResponse> editUser(@RequestBody UserEntity request) throws Exception {
            return ResponseEntity.ok(Translator.translate(userService.update(request)));
        }


        @RequestMapping(value = "/changeStatus",method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
        public Boolean changeStatus(@RequestParam long id,boolean status) throws Exception {
            return userService.changeStatus(id,status);
        }


        @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
        public void deleteUser(@RequestParam long id) throws Exception {
             userService.deleteUser(id);
        }


        //.................................................

        @RequestMapping(value = "/addUserSportField",method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<AddUserSportFieldResponse> addUserSportField(@RequestBody AddUserSportFieldRequest request) throws Exception {
            UserFieldEntity entity=userSportFieldService.save(Translator.translate(request));
            AddUserSportFieldResponse response=new AddUserSportFieldResponse();
            response.setId(entity.getId());
            response.setUserId(entity.getUserId());
            response.setSportField(entity.getSportField());
            return ResponseEntity.ok(response);
        }


        @RequestMapping(value = "/deleteUserSportField",method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
        public void deleteUserSportField(@RequestParam long id) throws Exception {
            userSportFieldService.delete(id);
        }

}




