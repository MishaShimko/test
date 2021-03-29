package com.shimko.service.impl;

import com.shimko.domain.File;
import com.shimko.domain.FileInfo;
import com.shimko.domain.MimeType;
import com.shimko.repository.FileInfoRepository;
import com.shimko.repository.FileRepository;
import com.shimko.service.FileInfoService;
import com.shimko.service.FileService;
import com.shimko.service.MimeTypeService;
import com.shimko.service.dto.FileInfoDto;
import com.shimko.service.dto.FullFileInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Shimko
 * @date 25.03.2021
 * @time 21:44
 */

@Service
@Transactional
public class FileInfoServiceImpl implements FileInfoService {

    @Value("${server.address}")
    private String serverAddress;

    @Value("${server.port}")
    private String serverPort;

    private FileRepository fileRepository;
    private FileInfoRepository fileInfoRepository;
    private MimeTypeService mimeTypeService;
    private FileService fileService;

    @Autowired
    public FileInfoServiceImpl(final FileRepository fileRepository,
                               final MimeTypeService mimeTypeService,
                               final FileInfoRepository fileInfoRepository,
                               final FileService fileService) {

        this.fileRepository = fileRepository;
        this.mimeTypeService = mimeTypeService;
        this.fileInfoRepository = fileInfoRepository;
        this.fileService = fileService;
    }

    public FileInfoDto create(final MultipartFile file) throws IOException {

        final MimeType mimeType = mimeTypeService.findOrCreate(file.getContentType());

        final Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        final File uploadedFile = new File(file.getBytes());

        final FileInfo fileInfo = new FileInfo(
            currentTime.getTime(), currentTime.getTime(), file.getOriginalFilename(), mimeType, file.getSize(),
            uploadedFile
        );

        fileInfoRepository.saveAndFlush(fileInfo);

        return new FileInfoDto(
            fileInfo.getId(), fileInfo.getCreateDate(), fileInfo.getChangeDate(), fileInfo.getFilename(),
            mimeType.getSysname(), fileInfo.getSize()
        );
    }

    public FileInfoDto find(final Integer id) {

        final FileInfo fileInfo = fileInfoRepository.findOne(id);

        return new FileInfoDto(
            fileInfo.getId(), fileInfo.getCreateDate(), fileInfo.getChangeDate(), fileInfo.getFilename(),
            fileInfo.getMimetype().getSysname(), fileInfo.getSize()
        );
    }

    public List<String> fetchFileNames() {

        return fileInfoRepository.findAll().stream().map(FileInfo::getFilename).collect(Collectors.toList());
    }

    public List<FullFileInfoDto> fetchFileList(final String name, final Timestamp fromDate, final Timestamp toDate,
                                               final List<String> fileTypes) {

        return fileInfoRepository
            .findAll()
            .stream()
            .map(this::mapperFullFileInfoDto)
            .collect(Collectors.toList());
    }

    public FileInfoDto update(final Integer fileId, final MultipartFile uploadedFile) throws IOException {

        final MimeType mimeType = mimeTypeService.findOrCreate(uploadedFile.getContentType());

        final FileInfo fileInfo = fileInfoRepository.findOne(fileId);

        final File newFile = fileInfo.getFile();

        newFile.setData(uploadedFile.getBytes());

        fileInfo.setChangeDate(new Timestamp(System.currentTimeMillis()).getTime());
        fileInfo.setFilename(uploadedFile.getOriginalFilename());
        fileInfo.setMimetype(mimeType);
        fileInfo.setFile(newFile);
        fileInfo.setSize(uploadedFile.getSize());

        fileInfoRepository.saveAndFlush(fileInfo);

        return new FileInfoDto(
            fileInfo.getId(), fileInfo.getCreateDate(), fileInfo.getChangeDate(), fileInfo.getFilename(),
            mimeType.getSysname(), fileInfo.getSize()
        );
    }

    public void delete(final Integer fileId) {
        fileInfoRepository.delete(fileId);
    }


    private FullFileInfoDto mapperFullFileInfoDto(final FileInfo fileInfo) {

        return new FullFileInfoDto(fileInfo,   "http://" + serverAddress + ":" + serverPort + "/api/files/download/" + fileInfo.getId());
    }
}
