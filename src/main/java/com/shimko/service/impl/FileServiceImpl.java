package com.shimko.service.impl;

import com.shimko.domain.File;
import com.shimko.domain.FileInfo;
import com.shimko.domain.MimeType;
import com.shimko.repository.FileInfoRepository;
import com.shimko.repository.FileRepository;
import com.shimko.repository.MimeTypeRepository;
import com.shimko.service.FileService;
import com.shimko.service.dto.FileDto;
import com.shimko.service.dto.FileInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:34
 */

@Service
@Transactional
public class FileServiceImpl implements FileService {

    private FileRepository fileRepository;
    private FileInfoRepository fileInfoRepository;
    private MimeTypeRepository mimeTypeRepository;

    @Autowired
    public FileServiceImpl(final FileRepository fileRepository,
                           final MimeTypeRepository mimeTypeRepository,
                           final FileInfoRepository fileInfoRepository) {

        this.fileRepository = fileRepository;
        this.mimeTypeRepository = mimeTypeRepository;
        this.fileInfoRepository = fileInfoRepository;
    }

    @Override
    public FileInfoDto create(final MultipartFile file) {

        MimeType mimeType = mimeTypeRepository.findBySysname(file.getContentType());

        if(mimeType == null) {

            mimeType = new MimeType(file.getContentType());
            mimeTypeRepository.saveAndFlush(mimeType);
        }

        try {

            final Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            final File uploadedFile = new File(file.getBytes());

            fileRepository.saveAndFlush(uploadedFile);

            final FileInfo fileInfo = new FileInfo(
                currentTime, currentTime, file.getOriginalFilename(), mimeType, file.getSize(), uploadedFile
            );

            fileInfoRepository.saveAndFlush(fileInfo);

            return new FileInfoDto(
                fileInfo.getId(), fileInfo.getCreateDate(), fileInfo.getChangeDate(), fileInfo.getFilename(),
                mimeType.getSysname(), fileInfo.getSize()
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public FileDto findFile(final Integer fileId) {

        final FileInfo fileInfo = fileInfoRepository.findOne(fileId);

        return new FileDto(fileInfo.getFilename(), fileInfo.getMimetype().getSysname(), fileInfo.getSize(),
            fileInfo.getFile().getData());
    }
}
