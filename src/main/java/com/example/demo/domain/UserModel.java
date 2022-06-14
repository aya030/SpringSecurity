package com.example.demo.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserModel implements UserDetails{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //1つのユーザーがROLEを複数持つときに使うみたい
        return null;
    }
    @Override
    public String getPassword() {
               //パスワードを返す
        return password;
    }
    @Override
    public String getUsername() {
               //ユーザー名（今回はid）を返す。
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        //ユーザアカウントが認証期限切れしていないかどうかを返す
                //認証期限切れしている場合falseを返すが、今回は特に考慮していないので
                //固定でtrueを返しておく（以下メソッドでも同様の理由でtrueを返している）
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        //ユーザアカウントがロックしていないかどうか
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        //ユーザアカウントの資格が認証期限切れしていないかどうか
        return true;
    }
    @Override
    public boolean isEnabled() {
        //ユーザアカウントが無効になっていないか
        return true;
    }
}
