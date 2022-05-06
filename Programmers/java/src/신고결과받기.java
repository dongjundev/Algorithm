import java.util.*;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> banCnt = new HashMap<>();
        HashSet hashSet = new HashSet<>();
        List<String> banList = new ArrayList<>();
        List<Member> memberList = new ArrayList<>();
        Arrays.stream(id_list)
                .forEach(p -> memberList.add(new Member(p)));

        for (int i = 0; i < report.length; i++) {
            hashSet.add(report[i]);
        }

        for (Object str : hashSet) {
            String[] splitStr = String.valueOf(str).split(" ");
            banCnt.put(splitStr[1], banCnt.getOrDefault(splitStr[1], 0)+1);

            for (Member member : memberList) {

                if (member.getName().equals(splitStr[0])) {
                    member.report.add(splitStr[1]);
                }
            }
        }


        for (Map.Entry<String, Integer> entry : banCnt.entrySet()) {
            if (entry.getValue() >= k) {
                banList.add(entry.getKey());
            }
        }

        for (Member member : memberList) {
            for (String banMember : member.getReport()) {
                for (int i = 0; i < banList.size(); i++) {
                    if (banList.get(i).equals(banMember)) {
                        member.mailCnt++;
                    }
                }
            }
        }

        System.out.println(memberList);

        int[] answer = memberList.stream()
                .map(m -> m.getMailCnt())
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }

    class Member{
        String name =""; //이름
        List<String> report = new ArrayList<>();
        int mailCnt = 0; //메일수신횟수

        public List<String> getReport() {
            return report;
        }

        public Member(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getMailCnt() {
            return mailCnt;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}


