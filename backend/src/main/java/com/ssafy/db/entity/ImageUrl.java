package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * 이미지 모델 정의.
 */
@Entity
@Getter
@Setter
public class ImageUrl extends BaseEntity {
    String url;
}