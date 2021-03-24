package com.shimko.service.dto;

import com.google.common.base.Objects;

import java.sql.Timestamp;

/**
 * @author Shimko
 * @date 25.03.2021
 * @time 0:09
 */
public class FileInfoDto {

    private Integer id;
    private Timestamp createDate;
    private Timestamp changeDate;
    private String filename;
    private String mimetypeId;
    private Long size;

    public FileInfoDto(final Integer id, final Timestamp createDate, final Timestamp changeDate, final String filename,
                       final String mimetypeId, final Long size) {

        this.id = id;
        this.createDate = createDate;
        this.changeDate = changeDate;
        this.filename = filename;
        this.mimetypeId = mimetypeId;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(final Timestamp changeDate) {
        this.changeDate = changeDate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(final String filename) {
        this.filename = filename;
    }

    public String getMimetypeId() {
        return mimetypeId;
    }

    public void setMimetypeId(final String mimetypeId) {
        this.mimetypeId = mimetypeId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(final Long size) {
        this.size = size;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FileInfoDto)) return false;
        final FileInfoDto that = (FileInfoDto)o;
        return Objects.equal(id, that.id)
            && Objects.equal(createDate, that.createDate)
            && Objects.equal(changeDate, that.changeDate)
            && Objects.equal(filename, that.filename)
            && Objects.equal(mimetypeId, that.mimetypeId)
            && Objects.equal(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            id, createDate, changeDate, filename, mimetypeId, size
        );
    }
}
