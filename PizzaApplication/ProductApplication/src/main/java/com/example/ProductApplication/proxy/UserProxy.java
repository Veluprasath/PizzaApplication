package com.example.ProductApplication.proxy;


import com.example.ProductApplication.domain.User;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "AuthApp",url = "localhost:1212")
public interface UserProxy {
    @PostMapping("/auth-app/addUser")
    public ResponseEntity<?>  userSave(@RequestBody User user);

}
//@FeignClient(name = "serviceAuthentication", url = "localhost:7087")
//public interface UserProxy {
//    @PostMapping("/api/user/saveUser")
//    public ResponseEntity<?> userSave(@RequestBody User user);
//}