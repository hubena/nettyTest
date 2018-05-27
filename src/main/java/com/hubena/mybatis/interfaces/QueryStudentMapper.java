/**
 * 
 */
package com.hubena.mybatis.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hubena.entity.QueryPageData;
import com.hubena.entity.RequestStudent;
import com.hubena.entity.StudentInfo;

/**
 * 
 * @author 曾谢波
 * @since 2018年5月27日
 */

@Repository
public interface QueryStudentMapper {
	/**
	 * @param requestStudent
	 * @param queryPageData
	 * @return
	 */
	public List<StudentInfo> findList(@Param("requestStudent") RequestStudent requestStudent, @Param("queryPageData") QueryPageData queryPageData);
	
	public Long findListCount();
	
	
	
}
