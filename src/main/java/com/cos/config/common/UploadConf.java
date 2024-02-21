package com.cos.config.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luXinYu
 * @create 2024/1/18 14:43
 */
@Data
@Component
@ConfigurationProperties(prefix = "file")
public class UploadConf {

    @Value("${file.base-url}")
    private String baseUrl;

    @Value("${file.annotations}")
    private String annotations;

    @Value("${file.annotations-name}")
    private String annotationsName;

    @Value("${file.images}")
    private String images;

    @Value("${file.labels}")
    private String labels;

    @Value("${file.path-file-name}")
    private String pathFileName;

    @Value("${file.annotations-tag-name}")
    private String annotationsTagName;

    @Value("${file.data-set-url}")
    private String datasetUrl;

    @Value("${file.cut-pic-url}")
    private String cutPicUrl;

    @Value("${file.cut-pic-url-annotion}")
    private String cutPicUrlAnnotion;


    @Value("${file.original-dataset-url}")
    private String originalDatasetUrl;

    @Value("${file.original-annotation}")
    private String originalAnnotation;

    @Value("${file.original-images}")
    private String originalImages;

    @Value("${file.original-annotations-name}")
    private String originalAnnotationsName;

    @Value("${file.original-labels}")
    private String originalLabels;

    @Value("${file.original-train}")
    private String originalTrain;

    @Value("${file.original-val}")
    private String originalVal;

    @Value("${file.original-annotations-tag-name}")
    private String originalAnnotationsTagName;

    @Value("${file.original-val-path-file-name}")
    private String originalValPathFileName;

    @Value("${file.original-train-path-file-name}")
    private String originalTrainPathFileName;



    @Value("${file.temp-dataset-url}")
    private String tempDatasetUrl;

    @Value("${file.temp-annotation}")
    private String tempAnnotation;

    @Value("${file.temp-images}")
    private String tempImages;

    @Value("${file.temp-annotations-name}")
    private String tempAnnotationsName;

    @Value("${file.temp-labels}")
    private String tempLabels;

    @Value("${file.temp-annotations-tag-name}")
    private String tempAnnotationsTagName;

    @Value("${file.temp-path-file-name}")
    private String tempPathFileName;


    @Value("${file.output-dataset-url}")
    private String outputDatasetUrl;


    @Value("${file.output-percent}")
    private String outputPercent;



}
