package com.shimko.domain;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:02
 */

@Entity
@Table(name = "file_infos")
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    /**
     * Дата создания
     */
    @Column(name = "create_date")
    private Timestamp createDate;

    /**
     * Дата изменения
     */
    @Column(name = "change_date")
    private Timestamp sysname;

    /**
     * Наименование файла
     */
    @Column(name = "filename")
    private String filename;

    /**
     * Идентификатор типа
     */
    @Column(name = "mimetype_id")
    private Integer mimetypeId;

    /**
     * Размер файла
     */
    @Column(name = "size")
    private Long size;

    /**
     * Файл
     */
    @Column(name = "file_id")
    private Integer file;

    public FileInfo(final Long id, final Timestamp createDate, final Timestamp sysname, final String filename,
                    final Integer mimetypeId,
                    final Long size, final Integer file) {
        this.id = id;
        this.createDate = createDate;
        this.sysname = sysname;
        this.filename = filename;
        this.mimetypeId = mimetypeId;
        this.size = size;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getSysname() {
        return sysname;
    }

    public void setSysname(final Timestamp sysname) {
        this.sysname = sysname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(final String filename) {
        this.filename = filename;
    }

    public Integer getMimetypeId() {
        return mimetypeId;
    }

    public void setMimetypeId(final Integer mimetypeId) {
        this.mimetypeId = mimetypeId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(final Long size) {
        this.size = size;
    }

    public Integer getFile() {
        return file;
    }

    public void setFile(final Integer file) {
        this.file = file;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FileInfo)) return false;
        final FileInfo fileInfo = (FileInfo)o;
        return Objects.equal(id, fileInfo.id)
            && Objects.equal(createDate, fileInfo.createDate)
            && Objects.equal(sysname, fileInfo.sysname)
            && Objects.equal(filename, fileInfo.filename)
            && Objects.equal(mimetypeId, fileInfo.mimetypeId)
            && Objects.equal(size, fileInfo.size)
            && Objects.equal(file, fileInfo.file);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            id, createDate, sysname, filename, mimetypeId, size, file
        );
    }

    @Override
    public String toString() {
        return "FileInfo{"
            + "id=" + id
            + ", createDate=" + createDate
            + ", sysname=" + sysname
            + ", filename='" + filename + '\''
            + ", mimetypeId=" + mimetypeId
            + ", size=" + size
            + ", file=" + file
            + '}';
    }
}
