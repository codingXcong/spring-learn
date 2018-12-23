package cn.zgc.spring.security.demo.web.controller;

import cn.zgc.spring.security.demo.domain.User;
import cn.zgc.spring.security.demo.domain.UserQueryConditon;
import cn.zgc.spring.security.demo.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping
    public User create(@Valid @RequestBody User user) {  //valid校验不过，会向调用方响应400状态码

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getUserInfo(@PathVariable String id){
        System.out.println("进入getUserInfo服务,id:"+id);
        throw new UserNotExistException(id);

        /*User user = new User();
        user.setUsername("Tomcat");
        user.setId("1");
        return user;*/
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> getUserInfos(UserQueryConditon condition,
                                   @PageableDefault(page=1,size=10,sort="username desc") Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getOffset());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if(errors.hasErrors()){
            List<ObjectError> allErrors = errors.getAllErrors();
            for (int i=0; i<allErrors.size(); i++){
                System.out.println("error:"+allErrors.get(i).getDefaultMessage());
            }
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }
}
