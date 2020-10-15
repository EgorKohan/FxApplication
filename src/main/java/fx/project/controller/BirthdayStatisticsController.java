package fx.project.controller;

import fx.project.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class BirthdayStatisticsController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private final ObservableList<String> monthsNames = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        barChart.;
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        monthsNames.addAll(Arrays.asList(months));
        xAxis.setCategories(monthsNames);
    }

    public void setPersonData(List<Person> people){
        int[] monthCounter = new int[12];
        for (Person person : people) {
            int month = person.getBirthday().getMonthValue() - 1;
            monthCounter[month]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthsNames.get(i), monthCounter[i]));
        }

        barChart.getData().add(series);
    }

}
