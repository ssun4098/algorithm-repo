import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // ✅ 패턴 수정
        List<Room> rooms = new ArrayList<>();

        // 예약 시간을 TimeRange 리스트로 변환
        List<TimeRange> timeRanges = new ArrayList<>();
        for (String[] time : book_time) {
            LocalTime startDate = LocalTime.parse(time[0], formatter);
            LocalTime endDate = LocalTime.parse(time[1], formatter);
            timeRanges.add(new TimeRange(startDate, endDate));
        }

        // 예약 시작 시간을 기준으로 정렬
        timeRanges.sort(Comparator.comparing(TimeRange::getStartDate));

        // 첫 번째 예약을 기본 방에 추가
        Room firstRoom = new Room();
        firstRoom.add(timeRanges.get(0));
        rooms.add(firstRoom);

        // 나머지 예약 처리
        for (int i = 1; i < timeRanges.size(); i++) {
            TimeRange now = timeRanges.get(i);
            boolean assigned = false;

            for (Room room : rooms) {
                if (room.check(now)) {
                    room.add(now);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                Room newRoom = new Room();
                newRoom.add(now);
                rooms.add(newRoom);
            }
        }

        return rooms.size();
    }
}

class Room {
    private List<TimeRange> times = new ArrayList<>();

    public void add(TimeRange range) {
        times.add(range);
    }

    public boolean check(TimeRange range) {
        for (TimeRange t : times) {
            if (t.getStartDate().isBefore(range.getEndDate()) && range.getStartDate().isBefore(t.getEndDate())) {
                return false; // 겹치면 false 반환
            }
        }
        return true;
    }
}

class TimeRange {
    private LocalTime startDate;
    private LocalTime endDate;
    static LocalTime endLimit = LocalTime.of(23, 59);

    public TimeRange(LocalTime startDate, LocalTime endDate) {
        this.startDate = startDate;
        if (endDate.isAfter(endLimit.minusMinutes(10))) {
            this.endDate = endLimit;
        } else {
            this.endDate = endDate.plusMinutes(10);
        }
    }

    public LocalTime getStartDate() {
        return startDate;
    }

    public LocalTime getEndDate() {
        return endDate;
    }
}
