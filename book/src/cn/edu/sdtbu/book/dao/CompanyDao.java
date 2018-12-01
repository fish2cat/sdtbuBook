package cn.edu.sdtbu.book.dao;

import cn.edu.sdtbu.book.bean.Company;

public interface CompanyDao {
	Company searchById(int companyId) throws Exception;
}
