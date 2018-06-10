package xupt.se.ttms.idao;
import java.util.List;

import xupt.se.ttms.model.Data_dict;


public interface iData_dictDAO {
	public  int insert(Data_dict data_dict);
	public int update(Data_dict data_dict);
	public int  delete(int ID);
	public List<Data_dict> select(String condt);
}