package com.shimko.service.dto;

import com.google.common.base.Objects;

import java.util.Arrays;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:41
 */

public class FileDto {

    private String fileName;
    private String mimetype;
    private Long size;
    private byte[] data;

    public FileDto(final String fileName, final String mimetype, final Long size, final byte[] data) {
        this.fileName = fileName;
        this.mimetype = mimetype;
        this.size = size;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(final String mimetype) {
        this.mimetype = mimetype;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(final Long size) {
        this.size = size;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(final byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FileDto)) return false;
        final FileDto fileDto = (FileDto)o;
        return Objects.equal(fileName, fileDto.fileName)
            && Objects.equal(mimetype, fileDto.mimetype)
            && Objects.equal(size, fileDto.size)
            && Objects.equal(data, fileDto.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            fileName, mimetype, size, data
        );
    }

    @Override
    public String toString() {
        return "FileDto{"
            + "fileName='" + fileName + '\''
            + ", mimetype='" + mimetype + '\''
            + ", size=" + size
            + ", data=" + Arrays.toString(data)
            + '}';
    }
}
