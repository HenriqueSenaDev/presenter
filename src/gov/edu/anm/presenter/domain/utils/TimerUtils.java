package gov.edu.anm.presenter.domain.utils;

public class TimerUtils {

    public static int getTotalSeconds(int minutes, int seconds) {
        return minutes * 60 + seconds;
    }

    public static String getCountdownLabel(int totalSeconds) {
        int minutes = (int) Math.floor(totalSeconds / 60);
        int seconds = totalSeconds % 60;

        String labelMinutes = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        String labelSeconds = seconds < 10 ? "0" + seconds : String.valueOf(seconds);

        return labelMinutes + ":" + labelSeconds;
    }
}
