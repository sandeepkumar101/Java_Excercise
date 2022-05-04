package Common;
import java.util.HashSet;
import java.util.Set;

public class LowestCommonLeader {

    // Find the lowest common leader of two given employees using the given data
    // structure,
    public interface Employee {
        int getId();

        String getName();

        Employee getManager(); // expensive
    }

    public Employee findLowestCommonLeader(Employee e1, Employee e2) {
        Set<Integer> managerids = new HashSet<Integer>();
        Employee m1 = e1.getManager();
        Employee m2 = e2.getManager();
        if (m1.getId() == m2.getId())
            return m1;
        managerids.add(m1.getId());
        managerids.add(m2.getId());

        while (true) {

            if (m1.getManager() != null) {
                m1 = m1.getManager();
                if (managerids.contains(m1.getId()))
                    return m1;
                else {
                    managerids.add(m1.getId());
                }
            }
            if (m2.getManager() != null) {
                m2 = m2.getManager();
                if (managerids.contains(m2.getId()))
                    return m2;
                else {
                    managerids.add(m2.getId());
                }
            }

        }

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
