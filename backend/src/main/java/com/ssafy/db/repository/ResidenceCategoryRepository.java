package com.ssafy.db.repository;

import com.ssafy.db.entity.ResidenceCategory;
import com.ssafy.db.entity.ResidenceInfo;
import com.ssafy.db.idmodel.ResidenceInfoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 방 종류 옵션 모델 관련 디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의.
 */
@Repository
public interface ResidenceCategoryRepository extends JpaRepository<ResidenceCategory, Long> {
}