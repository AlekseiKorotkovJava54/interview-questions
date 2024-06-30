package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

//all methods should have O[1] complexity
public class ConnectionPool {
	LinkedHashMap<Long, Connection> map;
	int size;
	
	@SuppressWarnings("serial")
	public ConnectionPool(int size) {
		this.size = size;
		this.map = new LinkedHashMap<Long, Connection>(10, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Long, Connection> entry) {
				return size() > 3;
				}
			};
			}
	
public Connection getConnection(Connection connection) {
	Connection res = map.get(connection.id());
	if(res == null) {
		res = connection;
		map.put(connection.id(), connection);
	}
	return res;
}
public boolean isInPool(long id) {
	return map.containsKey(id);
}
}
