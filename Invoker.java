import java.awt.List;
import java.util.ArrayList;
/*
 * Invoker Class
 * ArrayList of type CommandInterface is created.
 */

public class Invoker {
	
	public ArrayList<CommandInterface> list = new ArrayList<CommandInterface>();
/*
 * @param command	
 */
	public void addToList(CommandInterface command){
		
		list.add(command);
	}
	/*
	 * executes the entries in the list
	 */
	public void inTheList(){
		for (CommandInterface command : list){
			command.execute();
		}
		list.clear();
	}
}