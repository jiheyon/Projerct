package com.example.demo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Setter @Getter @ToString
@AllArgsConstructor
public class DataEntity {
    /*
    데이터구조
    연번:854
    시도:제주특별자치도
    시군구:서귀포시
    읍면동:대정읍
    동리:상모리
    경도:33.20611111
    위도:126.2908333
    구역구번:연안사고 위험구역
    장소:선착장
     */
    private int id;
    private String siDo;
    private String siKunKu;
    private String eubMyeonDong;
    private String dongRi;
    private String kyeongDo;
    private String wiDo;
    private String kuYeokKuBun;
    private String jangSo;

    public DataEntity(ArrayList<String> list) {
        this.id = Integer.parseInt(list.get(0));
        this.siDo = list.get(1);
        this.siKunKu = list.get(2);
        this.eubMyeonDong = list.get(3);
        this.dongRi = list.get(4);
        this.kyeongDo = list.get(5);
        this.wiDo = list.get(6);
        this.kuYeokKuBun = list.get(7);
        this.jangSo = list.get(8);
    }
}
