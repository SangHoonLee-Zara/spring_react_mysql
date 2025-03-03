package com.hyundaiautoever.boardback.service;

import org.springframework.http.ResponseEntity;

import com.hyundaiautoever.boardback.dto.response.user.GetSignInUserResponseDto;
import com.hyundaiautoever.boardback.dto.response.user.GetUserResponseDto;

public interface UserService {
    
    ResponseEntity<? super GetUserResponseDto> getUser(String email);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    
}
