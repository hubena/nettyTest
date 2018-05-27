/**
 * 
 */
package com.hubena.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubena.entity.PageData;
import com.hubena.entity.QueryPageData;
import com.hubena.entity.RequestStudent;
import com.hubena.entity.StudentInfo;
import com.hubena.mybatis.interfaces.QueryStudentMapper;
import com.hubena.service.PageListTestService;

/**
 *
 * @author 曾谢波
 * @since 2018年5月27日
 */
@Service
public class PageListTestServiceImpl implements PageListTestService{
	private static final Logger logger = Logger.getLogger("PageListTestServiceImpl");
	
	@Autowired
	QueryStudentMapper queryStudentMapper;

	public PageData findList(RequestStudent requestStudent, QueryPageData queryPageData) throws Exception {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		logger.debug("请求到了PageListTestServiceImpl------------------------");
//		List<StudentInfo> list = queryStudentMapper.findAll();
		
		List<StudentInfo> list = queryStudentMapper.findList(requestStudent, queryPageData);
		if (list == null || list.isEmpty()) {
			return new PageData(true, "数据为空", 0L, Collections.EMPTY_LIST);
		}
		Long count = queryStudentMapper.findListCount();
		return new PageData(true, "查询成功", count, list);
//		return new PageData(true, "查询成功", (long) list.size(), list);
	}
	
}
