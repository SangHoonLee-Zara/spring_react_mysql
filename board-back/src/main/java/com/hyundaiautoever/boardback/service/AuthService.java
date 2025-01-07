package com.hyundaiautoever.boardback.service;

import org.springframework.http.ResponseEntity;

import com.hyundaiautoever.boardback.dto.request.auth.SignUpRequestDto;
import com.hyundaiautoever.boardback.dto.request.auth.SignInRequestDto;
import com.hyundaiautoever.boardback.dto.response.auth.SignInResponseDto;
import com.hyundaiautoever.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
    
}
