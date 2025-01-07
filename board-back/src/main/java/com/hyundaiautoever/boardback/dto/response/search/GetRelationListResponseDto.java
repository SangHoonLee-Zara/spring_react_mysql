package com.hyundaiautoever.boardback.dto.response.search;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import com.hyundaiautoever.boardback.common.ResponseCode;
import com.hyundaiautoever.boardback.common.ResponseMessage;
import com.hyundaiautoever.boardback.dto.response.ResponseDto;
import com.hyundaiautoever.boardback.repository.resultSet.GetRelationResultSet;

import lombok.Getter;

@Getter
public class GetRelationListResponseDto extends ResponseDto {

    private List<String> relativeWordList;

    private GetRelationListResponseDto(List<GetRelationResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        List<String> relativeWordList = new ArrayList<>();
        for (GetRelationResultSet resultSet: resultSets) {
            String relativeWord = resultSet.getSearchWord();
            relativeWordList.add(relativeWord);
        }

        this.relativeWordList = relativeWordList;
    }

    public static ResponseEntity<GetRelationListResponseDto> success(List<GetRelationResultSet> resultSets) {
        GetRelationListResponseDto result = new GetRelationListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
