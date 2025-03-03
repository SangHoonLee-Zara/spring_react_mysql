package com.hyundaiautoever.boardback.service.implement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hyundaiautoever.boardback.dto.response.ResponseDto;
import com.hyundaiautoever.boardback.dto.response.search.GetPopularListResponseDto;
import com.hyundaiautoever.boardback.dto.response.search.GetRelationListResponseDto;
import com.hyundaiautoever.boardback.repository.SearchLogRepository;
import com.hyundaiautoever.boardback.repository.resultSet.GetPopularListResultSet;
import com.hyundaiautoever.boardback.repository.resultSet.GetRelationResultSet;
import com.hyundaiautoever.boardback.service.SearchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchServiceImplement implements SearchService {

    private final SearchLogRepository searchLogRepository;
    
    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {

        List<GetPopularListResultSet> resultSets = new ArrayList<>();

        try {

            resultSets = searchLogRepository.getPopularList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetPopularListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord) {

        List<GetRelationResultSet> resultSets = new ArrayList<>();

        try {

            resultSets = searchLogRepository.getRelationList(searchWord);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetRelationListResponseDto.success(resultSets);
    }

    
    
}
