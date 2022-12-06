package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[][] map = new String[8][8];
        String[] mappingArr = {"", "A", "B", "C", "D", "E", "F", "G", "H"};
        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        Queue<String> step = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            step.add(st.nextToken());
        }

        Loc kingLoc = new Loc(Arrays.asList(mappingArr).indexOf(king.substring(0, 1)), Integer.parseInt(king.substring(1, 2)));
        Loc stoneLoc = new Loc(Arrays.asList(mappingArr).indexOf(stone.substring(0, 1)), Integer.parseInt(stone.substring(1, 2)));

        while (!step.isEmpty()) {
            boolean f = false;

            String poll = step.poll();
            move(poll, kingLoc);

            if (kingLoc.equals(stoneLoc)) {
                move(poll, stoneLoc);
                f = true;
            }

            boolean kingCheck = check(kingLoc);
            boolean stoneCheck = check(stoneLoc);

            if (kingCheck == true) {
                chkMove(poll, kingLoc);
                if (f)
                    chkMove(poll, stoneLoc);
            }

            if (stoneCheck == true) {
                chkMove(poll, kingLoc);
                chkMove(poll, stoneLoc);
            }

        }

        System.out.println(mappingArr[kingLoc.x]+kingLoc.y);
        System.out.println(mappingArr[stoneLoc.x]+stoneLoc.y);
    }

    public static void move(String dir, Loc loc) {
        switch (dir) {
            case "R":
                loc.x += 1;
                break;
            case "L":
                loc.x -= 1;
                break;
            case "B":
                loc.y -= 1;
                break;
            case "T":
                loc.y += 1;
                break;
            case "RT":
                loc.x += 1;
                loc.y += 1;
                break;
            case "LT":
                loc.x -= 1;
                loc.y += 1;
                break;
            case "RB":
                loc.x += 1;
                loc.y -= 1;
                break;
            case "LB":
                loc.x -= 1;
                loc.y -= 1;
                break;
        }
    }

    public static boolean check(Loc loc) {
        boolean chk = false;

        if (loc.x < 1 || loc.x > 8 || loc.y < 1 || loc.y > 8)
            chk = true;

        return chk;
    }

    public static void chkMove(String dir, Loc loc) {
        switch (dir) {
            case "R":
                loc.x -= 1;
                break;
            case "L":
                loc.x += 1;
                break;
            case "B":
                loc.y += 1;
                break;
            case "T":
                loc.y -= 1;
                break;
            case "RT":
                loc.x -= 1;
                loc.y -= 1;
                break;
            case "LT":
                loc.x += 1;
                loc.y -= 1;
                break;
            case "RB":
                loc.x -= 1;
                loc.y += 1;
                break;
            case "LB":
                loc.x += 1;
                loc.y += 1;
                break;
        }
    }

    static class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Loc loc = (Loc) o;
            return x == loc.x && y == loc.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
