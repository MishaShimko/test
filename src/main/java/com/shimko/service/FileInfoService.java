package com.shimko.service;

import com.shimko.service.dto.FileInfoDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Shimko
 * @date 25.03.2021
 * @time 21:44
 */
public interface FileInfoService {

    FileInfoDto create(final MultipartFile file) throws IOException;

    FileInfoDto update(final Integer fileId, final MultipartFile file) throws IOException;

    void delete(final Integer fileId);
}
