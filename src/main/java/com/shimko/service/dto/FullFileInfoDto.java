package com.shimko.service.dto;

import com.shimko.domain.FileInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shimko
 * @date 27.03.2021
 * @time 19:31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullFileInfoDto {

    private Integer id;
    private Long createDate;
    private Long changeDate;
    private String filename;
    private String mimetype;
    private Long size;
    private String downloadLink;

    public FullFileInfoDto(final FileInfo fileInfo, final String downloadLink) {

        this.id = fileInfo.getId();
        this.createDate = fileInfo.getCreateDate();
        this.changeDate = fileInfo.getChangeDate();
        this.filename = fileInfo.getFilename();
        this.mimetype = fileInfo.getMimetype().getSysname();
        this.size = fileInfo.getSize();
        this.downloadLink = downloadLink;
    }
}
