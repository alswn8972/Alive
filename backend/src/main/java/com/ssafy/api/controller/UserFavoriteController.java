package com.ssafy.api.controller;

import com.ssafy.api.request.ResidenceGetReq;
import com.ssafy.api.response.*;
import com.ssafy.api.service.RoomSearchService;
import com.ssafy.api.service.UserFavoriteService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.ResidenceCategory;
import com.ssafy.db.entity.ResidenceInfo;
import com.ssafy.db.entity.ResidenceType;
import com.ssafy.db.entity.UserFavorite;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 찜하기 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "찜하기 API", tags = {"Favorite Residence"})
@RestController
@RequestMapping("/api/v1/favorites")
public class UserFavoriteController {

    @Autowired
    UserFavoriteService userFavoriteService;

    @PostMapping()
    @ApiOperation(value = "관심 매물 찜하기", notes = "관심있는 매물을 찜한다.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code = 500, message = "실패")
    })
    public ResponseEntity<? extends BaseResponseBody> createFavoriteResidence(
            @RequestBody @ApiParam(value = "방 종류", required = true) Long residenceId, @ApiIgnore Authentication authentication) {
        try {
            userFavoriteService.createFavoriteResidence(residenceId, authentication);
            return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(500).body(BaseResponseBody.of(500, "fail"));
        }
    }

    @GetMapping()
    @ApiOperation(value = "찜한 관심 매물 조회", notes = "찜한 관심 매물을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<UserFavoriteRes> getFavoriteResidence(@ApiIgnore Authentication authentication) {
        try {
            List<UserFavorite> userFavorites = userFavoriteService.getFavoriteResidence(authentication);
            return ResponseEntity.status(200).body(UserFavoriteRes.of(userFavorites));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(500).body(UserFavoriteRes.of(500, "fail"));
        }
    }

    @DeleteMapping()
    @ApiOperation(value = "관심 매물 찜 삭제", notes = "찜한 관심 매물을 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "삭제 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<BaseResponseBody> deleteFavoriteResidence(
            @RequestBody @ApiParam(value = "찜한 관심 매물 삭제", required = true) List<Long> userFavoriteIds, @ApiIgnore Authentication authentication) {
        try {
            userFavoriteService.deleteFavoriteResidence(userFavoriteIds, authentication);
            return ResponseEntity.status(200).body(UserLoginPostRes.of(201, "Success"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(UserLoginPostRes.of(500, "Fail"));
        }
    }
}