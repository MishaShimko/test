package com.shimko.web.rest;

import com.shimko.service.FileService;
import com.shimko.service.dto.FileDto;
import com.shimko.service.dto.FileInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:32
 */

@RestController
@RequestMapping("/api")
public class FileResource {

    private final FileService fileService;

    @Autowired
    public FileResource(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/files/upload", method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA)
    public ResponseEntity<FileInfoDto> addFile(@RequestParam("file") final MultipartFile file) {

        final FileInfoDto fileInfoDto = fileService.create(file);

        return new ResponseEntity<>(fileInfoDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/files/{fileId}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getFile(@PathVariable("fileId") final Integer fileId) {

        final FileDto fileDto = fileService.findFile(fileId);

        HttpHeaders header = new HttpHeaders();

        header.setContentType(MediaType.valueOf(fileDto.getMimetype()));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileDto.getFileName());
        header.setContentLength(fileDto.getSize());

        return new HttpEntity<>(fileDto.getData(), header);
    }

}
