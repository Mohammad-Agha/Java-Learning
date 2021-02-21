package ds;

public interface List {

  public int getSize();

  public void add(int... values);

  public void add(int values);

  public void add(int index, int value);

  public int getValueAt(int index);

  public int getIndexOf(int value);

  public void update(int index, int value);

  public void removeIndex(int index);

  public boolean removeValue(int value);

  public void reverse();

  public String toString();
}
