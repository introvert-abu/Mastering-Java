enum WeekDays {
    sunday(1), monday(2), tuesday(3), wednesday(4), thursday(5), friday(6), saturday(7);

    private int day;
    
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    WeekDays(int day) {
        this.day = day;
    }
}

class Main {
    public static void main(String[] args) {
        WeekDays[] days = WeekDays.values();

        for (WeekDays day : days) {
            System.out.println(day + " " + day.getDay());
        }
    }
}
