/**
 * 
 */
package com.hubena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hubena.entity.PageData;
import com.hubena.entity.QueryPageData;
import com.hubena.entity.RequestStudent;
import com.hubena.service.PageListTestService;
import com.hubena.util.JsonUtils;

import io.netty.channel.ChannelHandlerContext;

/**
 *
 * @author 曾谢波
 * @since 2018年5月27日
 */
@Controller("studentController")
public class StudentController {
	@Autowired
	PageListTestService pageListTestService;
	
	public PageData queryList(ChannelHandlerContext ctx, String jsonString){
		PageData pageData = null;
		QueryPageData queryPageData= new QueryPageData(2L, 15L, "id", QueryPageData.SORTTYPE_ASC);
		RequestStudent requestStudent = JsonUtils.parseToObject(jsonString, RequestStudent.class);
		try {
			pageData = pageListTestService.findList(requestStudent, queryPageData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageData;
	}
	
}
