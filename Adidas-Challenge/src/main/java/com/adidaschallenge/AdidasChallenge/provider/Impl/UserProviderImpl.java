package com.adidaschallenge.AdidasChallenge.provider.Impl;

import org.springframework.stereotype.Service;

@Service
public class UserProviderImpl{//	@Autowired
//	BCryptPasswordEncoder bcrypt;
//	
//	@Autowired
//	private UserRepository userRepository;	
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserEntity user = userRepository.findByUserName(username);
//		
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
//	
//		UserDetails userDetail = new User(user.getUserName(),user.getPassword(),authorities);		return userDetail;
//	}
//	
//	public boolean userCheck(UserDto user) throws Exception {
//		try {
//			UserEntity userEntity = userRepository.findByUserName(user.getUserName());
//			if (userEntity != null) {
//				if (bcrypt.matches(user.getPassword(), userEntity.getPassword())) {
//					return true;
//				}else {
//					return false;
//				}
//			}
//		} catch (Exception e) {
//			throw new Exception("Error - userCheck():" + e.getMessage());
//		}
//		return false;
//		
//	}

}
