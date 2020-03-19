package com.school.domain.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@ApiModel("用户详细信息")
public class UserDetail implements UserDetails {
    @ApiModelProperty(value = "用户ID")
    private long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "加密用户密码")
    private String password;

    @ApiModelProperty(value = "用户角色")
    private Role role;

    @ApiModelProperty(value = "最后一次重置密码")
    private Date lastPasswordResetDate;

    public UserDetail(long id, String username, Role role, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDetail(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDetail(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    public long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 账户是否未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *  账户是否未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     * 密码是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /** 账户是否激活
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
}
