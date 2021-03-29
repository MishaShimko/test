package com.shimko.service;

import com.shimko.service.dto.FileInfoDto;
import com.shimko.service.dto.FullFileInfoDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Shimko
 * @date 25.03.2021
 * @time 21:44
 */
public interface FileInfoService {

    FileInfoDto create(final MultipartFile file) throws IOException;

    FileInfoDto find(final Integer id);

    List<String> fetchFileNames();

    List<FullFileInfoDto> fetchFileList(final String name, final Timestamp fromDate, final Timestamp toDate,
                                        final List<String> fileTypes);

    FileInfoDto update(final Integer fileId, final MultipartFile file) throws IOException;

    void delete(final Integer fileId);
}
