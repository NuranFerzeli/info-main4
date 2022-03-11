//package com.firstnews.info.model;//package model;
//
//import com.firstnews.info.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
////
////
////import entity.User;
////import lombok.extern.log4j.Log4j2;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.userdetails.UserDetails;
////
////import java.util.Collection;
////import java.util.List;
////@Log4j2
////public class UserPrincipal implements UserDetails {
//
//   private  final User user;
//
//   public UserPrincipal(User user) {
//     this.user = user;
//   }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
////
////   @Override
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////
////        /* List<GrantedAuthority> authorities=new ArrayList<>();
////      this.user.getPermissionList().forEach(p->{
////            GrantedAuthority authority=new SimpleGrantedAuthority(p);
////            authorities.add(authority);
////        });
////        this.user.getRoleList().forEach(r->{
////            GrantedAuthority authority=new SimpleGrantedAuthority("ROLE_" + r);
////            System.out.println("rolde" +authority);
////            authorities.add(authority);
////        });*/
////        return null;
////    }
////
////    @Override
////    public String getPassword() {
////       // session.setAttribute("role", this.user.getPassword());
////       // log.info("sizin huququnuz" +session.getAttribute("role"));
////        return this.user.getPassword();
////    }
////
////    @Override
////    public String getUsername() {
////
////        return user.getUsername();
////    }
////
////
////    @Override
////    public boolean isAccountNonExpired() {
////        return true;
////    }
////
////    @Override
////    public boolean isAccountNonLocked() {
////        return true;
////    }
////
////    @Override
////    public boolean isCredentialsNonExpired() {
////        return true;
////    }
////
////    @Override
////    public boolean isEnabled() {
////        return true;
////    }
////
////}