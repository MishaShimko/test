package com.shimko.web.rest;

import com.shimko.service.FileInfoService;
import com.shimko.service.FileService;
import com.shimko.service.dto.FileInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;

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

    @RequestMapping(value = "/files/upload", method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA)
    public ResponseEntity<FileInfoDto> upload(@RequestParam("file") final MultipartFile file) throws IOException{

        final FileInfoDto fileInfoDto = fileInfoService.create(file);

        return new ResponseEntity<>(fileInfoDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/file/{fileId}", method = RequestMethod.GET)
    public ResponseEntity<FileInfoDto> find(@PathVariable("fileId") final Integer fileId) {

        final FileInfoDto fileInfoDto = fileInfoService.find(fileId);

        return new ResponseEntity<>(fileInfoDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/files/{fileId}", method = RequestMethod.POST)
    public ResponseEntity<FileInfoDto> update(@PathVariable("fileId") final Integer fileId,
                                              @RequestParam("file") final MultipartFile file) throws IOException {

        final FileInfoDto fileInfoDto = fileInfoService.update(fileId, file);

        return new ResponseEntity<>(fileInfoDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/files/{fileId}", method = RequestMethod.DELETE)
    public ResponseEntity<FileInfoDto> delete(@PathVariable("fileId") final Integer fileId) {

        fileInfoService.delete(fileId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/files/names", method = RequestMethod.GET)
    public ResponseEntity<List<String>> fetchFileNames() {

        final List<String> fileNames = fileInfoService.fetchFileNames();

        return new ResponseEntity<>(fileNames, HttpStatus.OK);
    }
}
