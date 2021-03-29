package com.shimko.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:02
 */

@Entity
@Table(name = "file_infos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Integer id;

    /**
     * Дата создания
     */
    @Column(name = "create_date")
    private Long createDate;

    /**
     * Дата изменения
     */
    @Column(name = "change_date")
    private Long changeDate;

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

    public FileInfo(final Long createDate, final Long changeDate, final String filename,
                    final MimeType mimetype, final Long size, final File file) {

        this.createDate = createDate;
        this.changeDate = changeDate;
        this.filename = filename;
        this.mimetype = mimetype;
        this.size = size;
        this.file = file;
    }
}
