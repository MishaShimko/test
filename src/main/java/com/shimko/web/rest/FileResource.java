package com.shimko.web.rest;

import com.shimko.service.FileInfoService;
import com.shimko.service.FileService;
import com.shimko.service.dto.FileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:32
 */

@RestController
@RequestMapping("/api")
public class FileResource {

    private final FileService fileService;
    private final FileInfoService fileInfoService;

    @Autowired
    public FileResource(final FileService fileService, final FileInfoService fileInfoService) {
        this.fileService = fileService;
        this.fileInfoService = fileInfoService;
    }

    @RequestMapping(value = "/files/download/{fileId}", method = RequestMethod.GET)
    public HttpEntity<byte[]> download(@PathVariable("fileId") final Integer fileId) {

        final FileDto fileDto = fileService.getFile(fileId);

        HttpHeaders header = new HttpHeaders();

        header.setContentType(MediaType.valueOf(fileDto.getMimetype()));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileDto.getFileName());
        header.setContentLength(fileDto.getSize());

        return new HttpEntity<>(fileDto.getData(), header);
    }
}
