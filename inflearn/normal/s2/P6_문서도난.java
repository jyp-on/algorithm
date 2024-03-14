package org.example.inflearn.normal.s2;
import java.util.*;

public class P6_문서도난 {
    class Report implements Comparable<Report>{
        String name;
        int time;
        public Report(String name, int time){
            this.name = name;
            this.time = time;
        }
        public int compareTo(Report ob){
            return this.time-ob.time;
        }
    }
    public int parseTime(String time){
        String[] sp = time.split(":");
        int hour = Integer.parseInt(sp[0]);
        int min = Integer.parseInt(sp[1]);
        return (hour * 60) + min;
    }
    public String[] solution(String[] reports, String times){
        String[] answer;
        ArrayList<Report> reportList = new ArrayList<>();
        int startT = parseTime(times.split(" ")[0]);
        int endT = parseTime(times.split(" ")[1]);

        for(String report : reports){
            String[] name_time = report.split(" ");
            String n = name_time[0];
            String t = name_time[1];
            int time = parseTime(t);
            if(startT <= time && endT >= time){
                reportList.add(new Report(n, time));
            }
        }

        Collections.sort(reportList);
        answer = new String[reportList.size()];
        for(int i=0; i<reportList.size(); i++){
            answer[i] = reportList.get(i).name;
        }
        return answer;
    }

    public static void main(String[] args){
        P6_문서도난 T = new P6_문서도난();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
