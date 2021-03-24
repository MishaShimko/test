package com.shimko.repository;

import com.shimko.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 23:57
 */

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

}
