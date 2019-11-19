package com.java98k.alipay.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java98k.alipay.dao.ZzryDao;
import com.java98k.alipay.service.ZzryService;
import com.java98k.alipay.vo.DianYingPojo;
import com.java98k.alipay.vo.PageObject;
import com.java98k.common.exception.ServiceException;

@Service
public class ZzryServiceImpl implements ZzryService {
	@Autowired
	private ZzryDao zzryDao;
	@Override
	public int deleteObjects(Integer... ids) {
		//1.参数校验
		if(ids==null||ids.length==0) {
            throw new IllegalArgumentException("参数无效");
        }
		//2.执行删除操作
		int rows=zzryDao.deleteObjects(ids);
		if(rows==0) {
            throw new ServiceException("记录可能已经不存在");
        }
		return rows;
	}
	
	@Override
	public PageObject<DianYingPojo> findPageObjects(
		String jiJiangShangYing, Integer pageCurrent) {
		//1.判定pageCurrent参数合法性
		if(pageCurrent==null||pageCurrent<1) {
            throw new IllegalArgumentException("当前页码值不正确");
        }
		//2.查询日志总记录数,并进行判定
		int rowCount=zzryDao.getRowCount(jiJiangShangYing);
		if(rowCount==0) {
            throw new ServiceException("没有找到对应记录");
        }
		//3.查询当前页日志记录
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<DianYingPojo> records=
		zzryDao.findPageObjects(jiJiangShangYing,
				startIndex, pageSize);
		//4.对查询结果进行封装并返回
		PageObject<DianYingPojo> po=new PageObject<>();
		po.setRowCount(rowCount);
		po.setRecords(records);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		/*int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pageCount++;
		}*/
		int pageCount=(rowCount-1)/pageSize+1;
		po.setPageCount(pageCount);
		return po;
	}

}








