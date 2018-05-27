/**
 * 
 */
package com.hubena.service;

import com.hubena.entity.PageData;
import com.hubena.entity.QueryPageData;
import com.hubena.entity.RequestStudent;

/**
 *
 * @author 曾谢波
 * @since 2018年5月27日
 */
public interface PageListTestService {
	public PageData findList(RequestStudent requestStudent,  QueryPageData queryPageData) throws Exception;
}
