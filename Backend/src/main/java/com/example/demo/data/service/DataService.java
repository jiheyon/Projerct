package com.example.demo.data.service;

import com.example.demo.data.entity.DataEntity;
import com.example.demo.data.repository.DataRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class DataService {
    private final DataRepository dataRepository;
    public DataEntity parseAllData(Element element) {
        ArrayList<String> tagList = new ArrayList<String>(
                Arrays.asList("c_YeonBeon","c_SiDo","c_SiKunKu","c_EubMyeonDong"
                        ,"c_DongRi","c_KyeongDo","c_WiDo","c_KuYeokKuBun","c_JangSo"));

        ArrayList<String> dataList = new ArrayList<String>();
        for (String tag : tagList) {
            dataList.add(element.getElementsByTagName(tag).item(0).getTextContent());
        }
        dataRepository.uploadData(new DataEntity(dataList));
        return new DataEntity(dataList);
    }

}
