package com.cos.base.constants;

import com.quantz.common.enums.TaskStatusEnum;

import java.util.Arrays;
import java.util.List;

/**
 * @author shaojc
 * @date 2024/1/13 11:28
 * 模型验证流程控制 状态列表
 */
public class TaskStatusConstants {

    // 将TaskStatusEnum中的状态码提取出来作为常量列表
    public static final List<String> VERIFY_STATUS_FLOW = Arrays.asList(
            TaskStatusEnum.MODELDOWNLOAD.getTypeCode(), // 模型下发
            TaskStatusEnum.DATASETDOWNLOAD.getTypeCode(), // 数据集下发
            TaskStatusEnum.INFERENCEUPLOAD.getTypeCode(), // 结果上传
            TaskStatusEnum.INFERENCESUCCESS.getTypeCode(), // 推理完成
            TaskStatusEnum.INFERENCEFAILED.getTypeCode(), // 推理失败
            TaskStatusEnum.SCRIPTDOWNLOAD.getTypeCode() // 脚本下发
    );

}
