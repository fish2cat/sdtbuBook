package cn.edu.sdtbu.book.dao;

import java.util.List;
import cn.edu.sdtbu.book.bean.Contract;

public interface ContractDao {
	List<Contract> searchByName(String name) throws Exception;	
}
