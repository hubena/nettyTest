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
import com.threeweidu.entity.AgentIPWhiteRecord;
import com.threeweidu.view.req.page.Page;

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
	public List<StudentInfo> findList(@Param(value = "requestStudent") RequestStudent requestStudent, @Param(value = "queryPageData") QueryPageData queryPageData);
	
	/**
	 * @return
	 */
	public Long findListCount();
	
	/**
	 * @return
	 */
	public List<StudentInfo> findAll();
	
	
	
	
	
}
