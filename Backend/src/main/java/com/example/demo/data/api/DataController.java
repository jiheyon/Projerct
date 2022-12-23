package com.example.demo.data.api;

import com.example.demo.data.entity.DataEntity;
import com.example.demo.data.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/data")
@Slf4j
@CrossOrigin
public class DataController {

    private final DataService dataService;

    @GetMapping
    public void getData() throws Exception {
        // api로 부터 데이터받아와서 xml 파일로 저장
        URL url = new URL("http://apis.data.go.kr/1532000/LIFE_SAVING_EQ_POSITION/list_view?serviceKey=QhSXKeRfEm%2Fta1A%2BlRgrKy31QfXPr%2FEaKwLqugrWFUFIaMDIgbQWkfwWkUO%2Fb9cwEhOVYBzv61ufkkt1SSgnwg%3D%3D&rowsCount=854&startPage=1");
        URLConnection connection = url.openConnection();

        try (InputStream inputStream = connection.getInputStream())
        {
            File file = new File("example.xml");
            FileUtils.copyInputStreamToFile(inputStream, file);
        }
    }

    @GetMapping("/processing")
    public void processing() throws ParserConfigurationException, IOException, SAXException {
        // xml 읽어와서 원하는 데이터만 따로출력
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // xml 파일 읽기
        Document document = builder.parse("example.xml");
        NodeList nodeList = document.getElementsByTagName("content");
        for (int index=0; index < nodeList.getLength(); index++) {
            Node node = nodeList.item(index);
            Element element = (Element) node;
            DataEntity dataEntity = dataService.parseAllData(element);
            System.out.println(dataEntity);
        }
    }
}
