import java.util.Iterator;
import java.util.LinkedList;

public class CustomStek {

    private LinkedList<String> customStek = new LinkedList<String>();

    public void add(String line) {

        if (checkAdding(line))
            customStek.addFirst(line);
    }

    public boolean checkAdding(String line) {

        if ((customStek.size() == 0))
            return true;
        if (customStek.getFirst().equals(line)) {
            customStek.poll();
            return false;
        }
        Iterator x = customStek.listIterator();
        while (x.hasNext()) {
            if (x.next().equals(line)) {
                customStek.remove(line);
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return customStek.size();
    }
}
