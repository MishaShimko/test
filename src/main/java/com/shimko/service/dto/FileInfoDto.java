package com.shimko.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shimko
 * @date 25.03.2021
 * @time 0:09
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileInfoDto {

    private Integer id;
    private Long createDate;
    private Long changeDate;
    private String filename;
    private String mimetype;
    private Long size;
}
