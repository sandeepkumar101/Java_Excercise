package streamexample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NestedFilter {
    public static void main(String[] args) {

        Deal s = new Deal();
        Set<DealOptions> ops = new HashSet<DealOptions>();
        DealOptions op = new DealOptions();
        s.setDealname("mongo");
        s.setDealprice("500");

        op = new DealOptions();
        op.setColor("red");
        op.setOptname("redop");

        ops.add(op);
        op = new DealOptions();
        op.setColor("blue");
        op.setOptname("blueop");

        ops.add(op);
        op = new DealOptions();
        op.setColor("green");
        op.setOptname("greenop");

        ops.add(op);

        s.setDealop(ops);

        List<Deal> dl = new ArrayList<Deal>();

        dl.add(s);
        ops = new HashSet<DealOptions>();
        s = new Deal();
        op = new DealOptions();
        s.setDealname("test2");
        s.setDealprice("200");

        op = new DealOptions();
        op.setColor("indigo");
        op.setOptname("indigop");

        ops.add(op);
        op = new DealOptions();
        op.setColor("violet");
        op.setOptname("violetop");

        ops.add(op);
        op = new DealOptions();
        op.setColor("orange");
        op.setOptname("orangeop");

        ops.add(op);

        s.setDealop(ops);

        dl.add(s);
        System.out.println(dl);
        List<Deal> dev = dl.stream().filter(
                p -> !(p.getDealop().stream().filter(po -> po.getColor().equals("red")).collect(Collectors.toSet()))
                        .isEmpty())
                .collect(Collectors.toList()); // error here
        System.out.println(dev);

        List<Deal> output = dl.stream()
                .filter(d -> d.getDealop().stream().anyMatch(po -> po.getColor().equals("red")))
                .collect(Collectors.toList());
        System.out.println(output);

        List<Deal> dd = filterDeals(dl, isFound("red"));
        System.out.println(dd);
    }

    public static Predicate<Deal> isFound(String color) {
        return p -> p.getDealop().stream().anyMatch(op -> op.getColor().equals(color));
    }

    public static List<Deal> filterDeals(List<Deal> deals, Predicate<Deal> predicate) {
        return deals.stream()
                .filter(predicate)
                .collect(Collectors.<Deal>toList());
    }

    static class Deal {
        String dealname;
        String dealprice;
        Set<DealOptions> dealop;

        public String getDealname() {
            return dealname;
        }

        public void setDealname(String dealname) {
            this.dealname = dealname;
        }

        public String getDealprice() {
            return dealprice;
        }

        public void setDealprice(String dealprice) {
            this.dealprice = dealprice;
        }

        public Set<DealOptions> getDealop() {
            return dealop;
        }

        public void setDealop(Set<DealOptions> dealop) {
            this.dealop = dealop;
        }

        @Override
        public String toString() {
            return "Deal [dealname=" + dealname + ", dealprice=" + dealprice + ", dealop=" + dealop + "]";
        }

    }

    static class DealOptions {
        String optname;
        String color;

        public String getOptname() {
            return optname;
        }

        public void setOptname(String optname) {
            this.optname = optname;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "DealOptions [optname=" + optname + ", color=" + color + "]";
        }

    }
}
