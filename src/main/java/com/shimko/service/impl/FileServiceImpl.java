package com.shimko.service.impl;

import com.shimko.domain.FileInfo;
import com.shimko.repository.FileInfoRepository;
import com.shimko.repository.FileRepository;
import com.shimko.service.FileService;
import com.shimko.service.dto.FileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:34
 */

@Service
@Transactional
public class FileServiceImpl implements FileService {

    private FileInfoRepository fileInfoRepository;
    private FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(final FileInfoRepository fileInfoRepository,
                           final FileRepository fileRepository) {

        this.fileInfoRepository = fileInfoRepository;
        this.fileRepository = fileRepository;
    }

    public FileDto getFile(final Integer fileId) {

        final FileInfo fileInfo = fileInfoRepository.findOne(fileId);

        return new FileDto(fileInfo.getFilename(), fileInfo.getMimetype().getSysname(), fileInfo.getSize(),
            fileInfo.getFile().getData());
    }
}
