package com.shimko.domain;

import com.google.common.base.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    private Integer id;

    /**
     * Дата создания
     */
    @Column(name = "create_date")
    private Timestamp createDate;

    /**
     * Дата изменения
     */
    @Column(name = "change_date")
    private Timestamp changeDate;

    /**
     * Наименование файла
     */
    @Column(name = "filename")
    private String filename;

    /**
     * Идентификатор типа
     */
    @ManyToOne
    private MimeType mimetype;

    /**
     * Размер файла
     */
    @Column(name = "size")
    private Long size;

    /**
     * Файл
     */
    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    private File file;

    public FileInfo() {
    }

    public FileInfo(final Timestamp createDate, final Timestamp changeDate, final String filename,
                    final MimeType mimetype, final Long size, final File file) {

        this.createDate = createDate;
        this.changeDate = changeDate;
        this.filename = filename;
        this.mimetype = mimetype;
        this.size = size;
        this.file = file;
    }

    public FileInfo(final Integer id, final Timestamp createDate, final Timestamp changeDate, final String filename,
                    final MimeType mimetype,
                    final Long size, final File file) {
        this.id = id;
        this.createDate = createDate;
        this.changeDate = changeDate;
        this.filename = filename;
        this.mimetype = mimetype;
        this.size = size;
        this.file = file;
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

    public MimeType getMimetype() {
        return mimetype;
    }

    public void setMimetype(final MimeType mimetype) {
        this.mimetype = mimetype;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(final Long size) {
        this.size = size;
    }

    public File getFile() {
        return file;
    }

    public void setFile(final File file) {
        this.file = file;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FileInfo)) return false;
        final FileInfo fileInfo = (FileInfo)o;
        return Objects.equal(id, fileInfo.id)
            && Objects.equal(createDate, fileInfo.createDate)
            && Objects.equal(changeDate, fileInfo.changeDate)
            && Objects.equal(filename, fileInfo.filename)
            && Objects.equal(mimetype, fileInfo.mimetype)
            && Objects.equal(size, fileInfo.size)
            && Objects.equal(file, fileInfo.file);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            id, createDate, changeDate, filename, mimetype, size, file
        );
    }

    @Override
    public String toString() {
        return "FileInfo{"
            + "id=" + id
            + ", createDate=" + createDate
            + ", changeDate=" + changeDate
            + ", filename='" + filename + '\''
            + ", mimetype=" + mimetype
            + ", size=" + size
            + ", file=" + file
            + '}';
    }
}
