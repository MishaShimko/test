package com.shimko.service;

import com.shimko.service.dto.FileDto;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:36
 */
public interface FileService {

    FileDto getFile(final Integer fileId);
}
