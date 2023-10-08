package common;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LogTimeWindow {

    /**
     * id timestamp count
     * 1 2018-10-10T08:00:00 12
     * 2 2018-10-10T08:30:00 5
     * 3 2018-10-10T08:45:00 7
     * 4 2018-10-10T09:10:00 9
     * 5 2018-10-10T09:50:00 3
     * 6 2018-10-10T10:15:00 8
     * 7 2018-10-10T12:00:00 6
     * 8 2018-10-10T12:30:00 1
     * 9 2018-10-10T12:45:00 2
     * 10 2018-10-10T17:30:00 4
     * 11 2018-10-10T17:35:00 7
     * 
     * @param args
     */
    public static void main(String[] args) {

        List<Log> logs = new ArrayList<Log>();
        LogTimeWindow l = new LogTimeWindow();
        Random rand = new Random();
        LocalDateTime lt = LocalDateTime.now();
        for(int j = 0; j < 10; j++)
        for (int i = 0; i < 50; i++) {
            logs.add(l.new Log(i, lt.minusMinutes(rand.nextInt(59)), rand.nextInt(10),"resource"+j));
        }
    
        /*
        List<Integer> logs1 = logs.stream().map(lg -> {
            LocalDateTime start = lg.getTimestamp();
            LocalDateTime end = lg.getTimestamp().plusHours(3);
            Map<String, List<Log>> logsWithinWindow = (Map<String, List<Log>>) logs.stream().filter(p -> isWithinRange1(start, end, p.getTimestamp(),lg.getResource(),p.getResource()));
            return ((IntStream) logsWithinWindow.mapToInt(Log::getCount)).sum();
        }).collect(Collectors.toList());
        logs.stream().forEach(System.out::println);
        Map<Set<Integer>, Double> map = logs.stream().map(log -> {
            var start = log.getTimestamp();
            var end = log.getTimestamp().plusHours(3);
            var logsWithinWindow = logs.stream().filter(p -> isWithinRange1(start, end, p.getTimestamp(),log.getResource(),p.getResource()));
            return ((IntStream) logsWithinWindow.map(t -> {})
        }).collect(Collectors.toList());
        
        */
        
    }

    public int countLogsInDuration(List<Log> logs, LocalDateTime start, LocalDateTime end) {
        return logs.stream()
                .filter(log -> isWithinRange(log.getTimestamp(), start, end))
                .mapToInt(Log::getCount)
                .sum();
    }

    public static boolean isWithinRange(LocalDateTime logTimestamp, LocalDateTime start, LocalDateTime end) {
        // return true or false based on comparison
        return logTimestamp.isAfter(start) && logTimestamp.isBefore(end) ? true : false;
    }

    public static boolean isWithinRange1(LocalDateTime logTimestamp, LocalDateTime start, LocalDateTime end, String res,
            String res2) {
        // return true or false based on comparison
        return logTimestamp.isAfter(start) && logTimestamp.isBefore(end) && res.equals(res2) ? true : false;
    }

    public class Log {
        private int id;
        private LocalDateTime timestamp;
        private int count;
        private String resource;

        public Log(int id, LocalDateTime timestamp, int count, String resource) {
            this.id = id;
            this.timestamp = timestamp;
            this.count = count;
            this.resource = resource;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "Log [count=" + count + ", id=" + id + ", resource=" + resource + ", timestamp=" + timestamp + "]";
        }

    }

}
