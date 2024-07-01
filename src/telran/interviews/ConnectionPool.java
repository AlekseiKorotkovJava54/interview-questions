package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

//all methods should have O[1] complexity
public class ConnectionPool {
	private LinkedHashMap<Long, Connection> pool;
	@SuppressWarnings("serial")
	public ConnectionPool(int size) {
		pool = new LinkedHashMap<>(16, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Long, Connection> entry) {
				return size() > size;
			}
		};
	}
public Connection getConnection(Connection connection) {
	//return a connection from the pool if it exists
	//otherwise creates new connection, adds in pool and returns new created connection
	long id = connection.id();
	return pool.computeIfAbsent(id, k -> new Connection(id));
}
public boolean isInPool(long id) {
	// returns true if  a given connection exists in the pool
	//otherwise returns false
	return pool.containsKey(id);
}
}
