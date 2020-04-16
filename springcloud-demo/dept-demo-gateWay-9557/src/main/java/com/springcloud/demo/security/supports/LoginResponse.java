package com.springcloud.demo.security.supports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author：xiaojiaxin
 * @Date：2020-04-16 15:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private int code;//返回码
    private String desc;//描述
    private Object obj;//返回信息
}
