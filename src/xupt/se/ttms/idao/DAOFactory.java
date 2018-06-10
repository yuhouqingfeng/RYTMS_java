package xupt.se.ttms.idao;
import xupt.se.ttms.dao.*;

public class DAOFactory {
	public static iStudioDAO creatStudioDAO(){
		return new StudioDAO();
	}
	public static iPlayDAO createPlayDAO(){
		return new  PlayDAO();
	}
	public static iData_dictDAO createData_dictDAO() {
		return  new Data_dictDAO();
	}
	
}
