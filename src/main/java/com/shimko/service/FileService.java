package com.shimko.service;

import com.shimko.service.dto.FileDto;
import com.shimko.service.dto.FileInfoDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:36
 */
public interface FileService {

    FileInfoDto create(final MultipartFile file);

    FileDto findFile(final Integer fileId);
}
