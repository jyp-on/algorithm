class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;
        m = m.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
        
        for(String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            String[] time = info[0].split(":");
            int start = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            time = info[1].split(":");
            int end = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            int play = end - start;
            
            info[3] = info[3].replace("C#", "c")
                            .replace("D#", "d")
                            .replace("F#", "f")
                            .replace("G#", "g")
                            .replace("A#", "a");
            
            String melody = info[3];
            
            // 악보의 길이보다 총 재생시간이 작거나 같으면
            if(play <= info[3].length()) {
                // 해당 길이만큼 악보를 나눔
                melody = info[3].substring(0, play);
            } else { // 악보 길이보다 총 재생시간이 길다면
                for(int i=0; i<play / info[3].length(); i++) {
                    melody += info[3];
                }
                melody += info[3].substring(0, play % info[3].length());
            }
            
            if(melody.contains(m) && play>maxTime) {
                maxTime = play;
                answer = info[2];
            }
            
            
        }
        
        return answer;
    }
}