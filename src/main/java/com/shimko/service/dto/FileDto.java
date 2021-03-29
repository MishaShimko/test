package com.shimko.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:41
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {

    private String fileName;
    private String mimetype;
    private Long size;
    private byte[] data;
}
