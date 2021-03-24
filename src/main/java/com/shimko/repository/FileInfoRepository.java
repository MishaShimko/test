package com.shimko.repository;

import com.shimko.domain.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shimko
 * @date 24.03.2021
 * @time 23:35
 */

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, Integer> {

}
