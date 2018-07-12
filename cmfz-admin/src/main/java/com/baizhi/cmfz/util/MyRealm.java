package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * 自定义数据源类
 *
 * Created by Administrator on 2018/7/10.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private ManagerService ms;

    /**
     * 获取授权信息的方法(AuthorizingRealm)
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //1.获取角色用户信息
        String username = (String)principals.getPrimaryPrincipal();
        List<Role> roles = ms.queryRolesByName(username);

        //2.封装查询到的授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            //将角色标签保存到返回值当中
            info.addRole(role.getRoleTag());
        }

        //获取权限信息
        List<Permission> permissions = ms.queryPermissionsByName(username);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }

        return info;
    }

    /**
     * 获取认证信息的方法(AuthenticatingRealm)
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();

        Manager manager = ms.queryManagerByName(username);

        if(manager != null){
            return new SimpleAuthenticationInfo(manager.getMgrName(),
                    manager.getMgrPwd(),
                    ByteSource.Util.bytes(manager.getSalt()),
                    UUID.randomUUID().toString());
        }

        return null;
    }
}