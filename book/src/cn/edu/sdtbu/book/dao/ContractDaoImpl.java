package cn.edu.sdtbu.book.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import cn.edu.sdtbu.book.bean.*;
import cn.edu.sdtbu.book.util.DBTool;

public class ContractDaoImpl implements ContractDao {

	@Override
	public List<Contract> searchByName(String name) throws Exception {
		List<Contract> list = new ArrayList<Contract>();
		Connection conn = DBTool.getConnection();
		ResultSet rs;
		PreparedStatement pst = conn.prepareStatement("select * from "
				+ "contracts where name like ? order by "
				+ "convert(name using GBK)");
		pst.setString(1, "%"+name+"%");
		rs = pst.executeQuery();		
		while(rs.next()) {
			int id = rs.getInt(1);
			String n = rs.getString(2);
			String gender = rs.getString(3);
			String email = rs.getString(4);
			String phones = rs.getString(5);
			Date birth = rs.getDate(6);
			String addr = rs.getString(7);
			int companyId = rs.getInt(8);
			String title = rs.getString(9);
			int catalog = rs.getInt(10);
			List<String> listPhones = Arrays.asList(phones.split(";"));
			if(catalog == 1) {
				Family f = new Family(id,n,gender,email,listPhones,
						new java.util.Date(birth.getTime()),addr);
				list.add(f);
				continue;
			}else	if(catalog == 2) {
				CompanyDao dao = new CompanyDaoImpl();
				Partner p = new Partner(id,n,gender,email,listPhones,
						title,dao.searchById(companyId));
					list.add(p);
					continue;
				}else {
			Contract c = new Contract(id,n,gender,email,listPhones);
			list.add(c);
				}
		}
		rs.close();
		pst.close();		
		return list;
	}

}
