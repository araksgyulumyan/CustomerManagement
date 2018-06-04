package com.example.core.service.auth;

/**
 * Created by araksgyulumyan
 * Date - 5/8/18
 * Time - 6:23 PM
 */
//@Service("customUserDetailsService")
//public class CustomUserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @Override
//    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
//        final User user = userService.getUserByEmail(email);
//        return new GlobalUserDetails(user);
//    }
//
//    public class GlobalUserDetails implements UserDetails {
//
//        private static final long serialVersionUID = -3214215200499248948L;
//
//        private final User user;
//
//        public GlobalUserDetails(final User user) {
//            this.user = user;
//        }
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().name()));
//        }
//
//        @Override
//        public String getPassword() {
//            return user.getPassword();
//        }
//
//        @Override
//        public String getUsername() {
//            return user.getEmail();
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return true;
//        }
//    }
//
//}