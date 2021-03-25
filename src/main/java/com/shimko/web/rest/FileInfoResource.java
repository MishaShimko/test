package com.shimko.web.rest;

import com.shimko.service.FileInfoService;
import com.shimko.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shimko
 * @date 25.03.2021
 * @time 22:26
 */

@RestController
@RequestMapping("/api")
public class FileInfoResource {

    private final FileService fileService;
    private final FileInfoService fileInfoService;

    @Autowired
    public FileInfoResource(final FileService fileService, final FileInfoService fileInfoService) {
        this.fileService = fileService;
        this.fileInfoService = fileInfoService;
    }

}
