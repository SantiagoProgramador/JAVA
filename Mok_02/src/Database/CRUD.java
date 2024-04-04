package Database;

import java.util.List;

public interface CRUD {
    public Object create(Object object);
    public List<Object> read();
    public boolean update(Object object);
    public void delete(int id);
    public Object findById(int id);
}

